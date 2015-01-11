class UsersController < ApplicationController

  # POST /posts
  # POST /posts.json
  def create
  	puts params
	respond_to do |format|
		format.json{ render json: params }
	end
  end

end