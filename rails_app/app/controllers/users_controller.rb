class UsersController < ApplicationController

  # POST /posts
  # POST /posts.json
  def create
  	puts "PARAMSSSS" + params.to_s
  	old_investment = Investment.where(
  		owner_id: params["userId"],
  		value_type: params["valueType"],
  		purchase_price: params["price"],
  		subject: params["subjectName"],
  		subject_value: params["value"]
  		).first
    puts "OLD INVESTMENT #{old_investment.to_s}"
  	new_num_shares = old_investment == nil ?
  		1 : old_investment["num_shares"] + 1;
  	@investment = Investment.new(
  		"purchase_price" => params["price"],
  		"num_shares" => new_num_shares,
  		"subject" => params["subjectName"],
  		"subject_value" => params["value"],  		  		
  		"value_type" => params["valueType"],
  		"owner_id" => params["userId"]
  		)
    puts "NEW INVESTMENT #{@investment.to_s}"
  	@investment.save
  	@user = User.find(params["userId"].to_i)
    @user.decrement!(:balance, params["price"].to_i)
    params[:new_balance] = @user.balance
    subject_name = params["subjectName"]
    value_type = params["valueType"]
    current_value = params["value"].to_i
    new_ownership = get_ownership(subject_name, value_type, current_value)
    puts "NEW OWNERSHIP #{new_ownership}"
    params[:new_ownership] = new_ownership
    puts "PARAMS: " + params.to_s
    respond_to do |format|
  		format.json{ render json: params }
  	end
  end

end