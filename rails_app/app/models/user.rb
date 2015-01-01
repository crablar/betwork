class User < ActiveRecord::Base
  
  def self.from_omniauth(auth)
      where(auth.slice(:provider, :uid)).first_or_initialize.tap do |user|
        user.provider = auth.provider
        user.uid = auth.uid
        user.name = auth.info.name
        user.oauth_token = auth.credentials.token
        user.oauth_expires_at = Time.at(auth.credentials.expires_at)
        facebook = Koala::Facebook::API.new(user.oauth_token)
        fb_callback = facebook.get_object("me?fields=name,picture")
        user.profile_image_url = fb_callback['picture']['data']['url']
        user.save!
      end
   end
   
end
