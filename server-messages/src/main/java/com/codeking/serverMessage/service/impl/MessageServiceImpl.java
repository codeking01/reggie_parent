package com.codeking.serverMessage.service.impl;

import com.codeking.serverMessage.entity.Message;
import com.codeking.serverMessage.service.MessageService;
import org.redisson.api.RKeys;
import org.redisson.api.RMap;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {

    private static final String MESSAGE_KEY_PREFIX = "messages:";

    @Autowired
    private final RedissonClient redissonClient;

    public MessageServiceImpl(RedissonClient redissonClient) {
        this.redissonClient = redissonClient;
    }

    @Override
    public void sendMessage(Message message) {
        RMap<Integer, Message> messagesMap = redissonClient.getMap(MESSAGE_KEY_PREFIX + message.getReceiverId());
        messagesMap.put(message.getMessageId(), message);
    }

    @Override
    public List<Message> getReceivedMessages(int receiverId) {
        RMap<Integer, Message> messagesMap = redissonClient.getMap(MESSAGE_KEY_PREFIX + receiverId);
        return new ArrayList<>(messagesMap.values());
    }

    @Override
    public List<Message> getSentMessages(int senderId) {
        RMap<Integer, Message> messagesMap = redissonClient.getMap(MESSAGE_KEY_PREFIX + senderId);
        return new ArrayList<>(messagesMap.values());
    }

    @Override
    public void markAsRead(int messageId) {
        RMap<Integer, Message> messagesMap = getMessagesMapContainingMessage(messageId);
        if (messagesMap != null) {
            Message message = messagesMap.get(messageId);
            if (message != null) {
                message.setRead(true);
                messagesMap.put(messageId, message);
            }
        }
    }

    @Override
    public void deleteMessage(int messageId) {
        RMap<Integer, Message> messagesMap = getMessagesMapContainingMessage(messageId);
        if (messagesMap != null) {
            messagesMap.remove(messageId);
        }
    }

    private RMap<Integer, Message> getMessagesMapContainingMessage(int messageId) {
        RKeys keys = redissonClient.getKeys();
        Iterable<String> messageKeyIterable = keys.getKeysByPattern(MESSAGE_KEY_PREFIX + "*");
        for (String messageKey : messageKeyIterable) {
            RMap<Integer, Message> messagesMap = redissonClient.getMap(messageKey);
            if (messagesMap.containsKey(messageId)) {
                return messagesMap;
            }
        }
        return null;
    }

}
