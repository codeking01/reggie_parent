package com.codeking.serverMessage.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;


@Data
public class Messages implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.AUTO)
    private Long messageId;

    private Long senderId;

    private Long receiveId;

    private String subject;

    private String content;

    @TableField(fill = FieldFill.INSERT)
    private boolean isRead;

    @TableField(value = "sent_time", fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime sentTime;
}