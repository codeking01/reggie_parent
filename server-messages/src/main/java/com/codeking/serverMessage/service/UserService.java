package com.codeking.serverMessage.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.codeking.serverMessage.entity.Users;

/**
 * @author CodeKing
 * @since 2023/5/31  21:08
 */
public interface UserService extends IService<Users> {
    int saveUser(Users users);

    Users getId(Long userId);
}
