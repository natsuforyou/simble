/*
 * ©2016 Jesse. some rights reserved.
 */

package com.jesse.test.service.transaction.impl;

import com.jesse.test.dao.mapper.gen.UserMapper;
import com.jesse.test.dao.po.User;
import com.jesse.test.service.transaction.HelloTransactionService;

import javax.annotation.Resource;

/**
 * Created by Jesse Qian on 16-5-17.
 */
public class HelloTransactionServiceImpl implements HelloTransactionService {

    @Resource
    private UserMapper userMapper;

    @Override
    public void addUser(User user) {
        userMapper.insert(user);
    }
}
