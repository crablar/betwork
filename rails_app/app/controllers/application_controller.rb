class ApplicationController < ActionController::Base
  protect_from_forgery 
  
  private
  def current_user
    @current_user ||= User.find(session[:user_id]) if session[:user_id]
  end
  
  #facebook helpers
  def get_user_city
    @current_user ||= User.find(session[:user_id]) if session[:user_id]
    graph = Koala::Facebook::API.new(@current_user.oauth_token)
    graph.get_connections("me", "likes")
    city_id = graph.get_object("me")["location"]["name"]
  end
  
  #yelp helpers
  def get_businesses_in_city
    parameters = { term: params[:term], limit: 16 }
    json = Yelp.client.search(get_user_city, parameters).as_json
    json['hash']['businesses']
  end
  
  def get_charts
    puts "CURRENT USER #{current_user}"
    if current_user == nil
      puts "RETURNNNN"
      return []
    end
    require 'open-uri'
      data_hash = JSON.load(open("https://s3-us-west-2.amazonaws.com/betwork/charts.json"))
      File.open("public/charts.json","w") do |f|
        f.write(data_hash.to_json)
      end
      data_hash.each do |chart|
        chart["subjectName"] = chart["chartSubject"]["subjectName"]
        chart["valueType"] = chart["chartSubject"]["valueType"]
      end
      puts data_hash
      data_hash
  end

  def get_ownership(subject_name, value_type, current_value)
    puts current_value
    investments = Investment.where(
      owner_id: current_user.id,
      value_type: value_type,
      subject: subject_name
      )
    if !investments.first
      return nil
    else
      worth = 0
      investments.to_a.each do |investment|
        value_multiplier = 1.0 * current_value / investment.subject_value.to_i
        worth += value_multiplier * investment.purchase_price * investment.num_shares
      end
      worth
    end
  end



  helper_method :current_user, :get_user_city, :get_businesses_in_city, :get_random_pair_of_businesses, 
  :choose_business, :get_charts, :get_ownership
end
