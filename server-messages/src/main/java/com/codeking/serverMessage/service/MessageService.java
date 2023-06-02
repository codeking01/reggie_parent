package com.codeking.serverMessage.service;

import com.codeking.serverMessage.entity.Message;

import java.util.List;

public interface MessageService {
    void sendMessage(Message message);
    List<Message> getReceivedMessages(int receiverId);
    List<Message> getSentMessages(int senderId);
    void markAsRead(int messageId);
    void deleteMessage(int messageId);
}
