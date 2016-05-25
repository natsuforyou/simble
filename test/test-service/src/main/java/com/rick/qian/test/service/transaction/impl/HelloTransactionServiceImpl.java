/*
 * ©2016 Rick Qian. some rights reserved.
 */

/*
 * ©2016 Rick Qian. some rights reserved.
 */

package com.rick.qian.test.service.transaction.impl;

import com.rick.qian.test.dao.mapper.gen.UserMapper;
import com.rick.qian.test.dao.po.User;
import com.rick.qian.test.service.transaction.HelloTransactionService;

import javax.annotation.Resource;

/**
 * Created by Rick Qian on 16-5-17.
 */
public class HelloTransactionServiceImpl implements HelloTransactionService {

    @Resource
    private UserMapper userMapper;

    @Override
    public void addUser(User user) {
        userMapper.insert(user);
    }
}
