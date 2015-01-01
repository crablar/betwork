class AddOauthExp < ActiveRecord::Migration
  def change
    remove_column :users, :oath_expires_at
    add_column :users, :oauth_expires_at, :datetime
  end
end
