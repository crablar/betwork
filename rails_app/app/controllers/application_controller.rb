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
  
  def get_random_pair_of_businesses
    businesses = get_businesses_in_city
    random = rand(businesses.length)
    biz1 = businesses[random]
    businesses.delete(random)
    random = rand(businesses.length)
    biz2 = businesses[random]
    return biz1, biz2
  end
  
  helper_method :current_user, :get_user_city, :get_businesses_in_city, :get_random_pair_of_businesses, :choose_business
end
