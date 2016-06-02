package org.simble.member.service.transaction.impl;

import org.simble.member.dao.mapper.gen.UserMapper;
import org.simble.member.dao.po.User;
import org.simble.member.service.transaction.HelloTransactionService;

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
