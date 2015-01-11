class AddValueTypeToInvestments < ActiveRecord::Migration
  def change
	add_column :investments, :value_type, :string
	remove_column :investments, :investment_id
  end
end
