class CreateInvestments < ActiveRecord::Migration
  def change
    create_table :investments do |t|
      t.integer :investment_id
      t.integer :purchase_price
      t.string :owner
      t.integer :num_shares
      t.string :subject
      t.string :subject_value

      t.timestamps
    end
  end
end
