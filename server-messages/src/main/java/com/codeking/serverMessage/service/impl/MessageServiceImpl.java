package com.codeking.serverMessage.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.codeking.serverMessage.entity.Messages;
import com.codeking.serverMessage.mapper.MessageMapper;
import com.codeking.serverMessage.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author CodeKing
 * @since 2023/5/31  22:42
 */
@Service
public class MessageServiceImpl extends ServiceImpl<MessageMapper, Messages> implements MessageService {
    @Autowired
    private MessageMapper messageMapper;

    @Override
    public void sendMessage(Long senderId, Long receiveId, String subject, String content) {
        // 创建站内信实体对象
        Messages messages = new Messages();
        messages.setSenderId(senderId);
        messages.setReceiveId(receiveId);
        messages.setSubject(subject);
        messages.setContent(content);
        // 先手动实现时间
        //messages.setSentTime(LocalDateTime.now());
        // 保存消息到数据库
        messageMapper.insert(messages);
    }

    // 获取站内信
    public List<Messages> getMessages(Long messageId) {
        // 根据用户ID查询站内信列表
        QueryWrapper<Messages> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("message_id", messageId);
        queryWrapper.orderByDesc("sent_time");
        return messageMapper.selectList(queryWrapper);
    }

    // 标记已读
    public void markMessageAsRead(Long messageId) {
        // 根据站内信ID更新状态为已读
        Messages messages = messageMapper.selectById(messageId);
        if (messages != null) {
            messages.setRead(true);
            messageMapper.updateById(messages);
        }
    }

    public void deleteMessage(Long messageId) {
        // 根据站内信ID删除站内信
        messageMapper.deleteById(messageId);
    }

}
