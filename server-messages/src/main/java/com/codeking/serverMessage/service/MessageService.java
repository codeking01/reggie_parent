package com.codeking.serverMessage.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.codeking.serverMessage.entity.Messages;

import java.util.List;

/**
 * @author CodeKing
 * @since 2023/5/31  22:40
 */
public interface MessageService extends IService<Messages> {
    void sendMessage(Long senderId, Long receiveId, String subject, String content);

    List<Messages> getMessages(Long messageId);

    void markMessageAsRead(Long messageId);

    void deleteMessage(Long messageId);
}
