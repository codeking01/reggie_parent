package com.codeking.serverMessage.controller;

import com.codeking.serverMessage.entity.Messages;
import com.codeking.serverMessage.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author CodeKing
 * @since 2023/6/1  11:47
 */
@RestController
@RequestMapping("message")
public class MessageController {
    @Autowired
    private MessageService messageService;

    @PostMapping("/send")
    public void sendMessage(@RequestBody Messages messages) {
        messageService.sendMessage(messages.getSenderId(), messages.getReceiveId(), messages.getSubject(), messages.getContent());
        // 返回适当的响应
    }

    @GetMapping("/{messageId}")
    public ResponseEntity<List<Messages>> getMessages(@PathVariable Long messageId) {
        List<Messages> messages = messageService.getMessages(messageId);
        // 返回适当的响应
        return ResponseEntity.ok(messages);
    }

    @PutMapping("/{messageId}/read")
    public void markMessageAsRead(@PathVariable Long messageId) {
        messageService.markMessageAsRead(messageId);
        // 返回适当的响应
    }

    @DeleteMapping("/{messageId}")
    public void deleteMessage(@PathVariable Long messageId) {
        messageService.deleteMessage(messageId);
        // 返回适当的响应
    }

}
