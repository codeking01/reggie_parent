package com.codeking.serverMessage.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.codeking.serverMessage.entity.Messages;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author CodeKing
 * @since 2023/5/31  22:42
 */
@Mapper
public interface MessageMapper extends BaseMapper<Messages> {
}
