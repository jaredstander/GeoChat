class SecretMessagesController < ApplicationController

  def create
    client = Twilio::REST::Client.new TWILIO_ACCOUNT_SID, TWILIO_AUTH_TOKEN
    
    params[:message][:from] = "GeoChat Secret" 
    @message = Message.create(params[:message].permit(:to, :from, :text))

    client.account.sms.messages.create(
    :from => TWILIO_NUMBER,
    :to => params[:message][:to],
    :body => params[:message][:text]
    )
  end


end

