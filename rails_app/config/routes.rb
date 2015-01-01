Anypost::Application.routes.draw do
  root :to => 'posts#index'
  
  match 'auth/:provider/callback', to: 'sessions#create', via: [:get, :post]
  match 'auth/failure', to: redirect('/'), via: [:get, :post]
  match 'signout', to: 'sessions#destroy', as: 'signout', via: [:get, :post]
    
  resources :posts do
    resources :comments, :only => [:create]
  end
end