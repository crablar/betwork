class ChangeInvestmentOwnerToOwnerId < ActiveRecord::Migration
  def change
  	remove_column :investments, :owner
  	add_column :investments, :owner_id, :integer
  end
end
