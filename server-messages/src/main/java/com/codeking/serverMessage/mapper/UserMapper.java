package com.codeking.serverMessage.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.codeking.serverMessage.entity.Users;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<Users> {
}
