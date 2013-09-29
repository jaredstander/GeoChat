class ChatsController < ApplicationController

  def index
    @messages = Message.all
    @message = Message.new
  end

  def chat
    Message.create!(from: params["From"], text: params["Body"])
  end

end


