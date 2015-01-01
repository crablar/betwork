class AddOathExpirationToUser < ActiveRecord::Migration
  def change
    add_column :users, :oath_expires_at, :datetime, :default => Time.now
  end
end
