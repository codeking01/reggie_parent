package com.codeking.serverMessage.controller;

import com.codeking.serverMessage.entity.Message;
import com.codeking.serverMessage.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/message")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @PostMapping
    public ResponseEntity<String> sendMessage(@RequestBody Message message) {
        messageService.sendMessage(message);
        return ResponseEntity.ok("Message sent successfully");
    }

    @GetMapping("/received/{receiverId}")
    public ResponseEntity<List<Message>> getReceivedMessages(@PathVariable int receiverId) {
        List<Message> receivedMessages = messageService.getReceivedMessages(receiverId);
        return ResponseEntity.ok(receivedMessages);
    }

    @GetMapping("/sent/{senderId}")
    public ResponseEntity<List<Message>> getSentMessages(@PathVariable int senderId) {
        List<Message> sentMessages = messageService.getSentMessages(senderId);
        return ResponseEntity.ok(sentMessages);
    }

    @PostMapping("/{messageId}/read")
    public ResponseEntity<String> markAsRead(@PathVariable int messageId) {
        messageService.markAsRead(messageId);
        return ResponseEntity.ok("Message marked as read");
    }

    @DeleteMapping("/{messageId}")
    public ResponseEntity<String> deleteMessage(@PathVariable int messageId) {
        messageService.deleteMessage(messageId);
        return ResponseEntity.ok("Message deleted");
    }
}
