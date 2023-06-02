package com.codeking.serverMessage.entity;

import lombok.Data;

import java.util.Date;

/**
 * 这个是基于redis做的
 */
@Data
public class Message {
    private Integer messageId;
    private String senderId;
    private String receiverId;
    private String subject;
    private String content;
    private boolean isRead;
    private Date sentTime;
}
