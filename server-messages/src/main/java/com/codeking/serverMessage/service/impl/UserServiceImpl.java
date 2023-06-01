package com.codeking.serverMessage.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.codeking.serverMessage.entity.Users;
import com.codeking.serverMessage.mapper.UserMapper;
import com.codeking.serverMessage.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author CodeKing
 * @since 2023/5/31  21:39
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, Users> implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public int saveUser(Users users) {
        return userMapper.insert(users);
    }

    @Override
    public Users getId(Long userId) {
        // 这里可以实现获取用户ID的业务逻辑
        return userMapper.selectById(userId);
    }
}
