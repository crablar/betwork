class UsersController < ApplicationController

  # POST /posts
  # POST /posts.json
  def create
  	puts params
  	old_investment = Investment.where(
  		owner_id: params["userId"],
  		value_type: params["valueType"],
  		purchase_price: params["price"],
  		subject: params["subject"],
  		subject_value: params["value"]
  		).first
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
  	@investment.save
  	User.find(params["userId"].to_i).decrement!(:balance, params["price"].to_i)
  	respond_to do |format|
		format.json{ render json: params }
	end
  end

end