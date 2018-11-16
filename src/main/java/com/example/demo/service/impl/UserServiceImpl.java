package com.example.demo.service.impl;

import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import com.example.demo.service.UserService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    @Resource
    UserMapper userMapper;
    @Override
    public List<User> querAll() {
        return userMapper.queryAll();
    }

    @Override
    public boolean deleteUser(int id) {
        int del = userMapper.deletUser(id);
        return true;
    }

    @Override
    public boolean updateUser(User user) {
        int update = userMapper.updateUser(user);
        return true;
    }

    @Override
    public boolean addUser(User user) {
        int add = userMapper.addUser(user);
        return true;
    }

    @Override
    public User getUserById(int id) {
        return userMapper.getUserById(id);
    }
}
