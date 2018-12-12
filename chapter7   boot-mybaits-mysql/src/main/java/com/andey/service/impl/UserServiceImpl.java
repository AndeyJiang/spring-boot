package com.andey.service.impl;
import com.andey.dao.UserMapper;
import com.andey.entity.User;
import com.andey.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by jiangbin on 2018/11/27.
 */
@Service
public class UserServiceImpl  implements UserService{
     @Autowired
     private  UserMapper userMapper;


    @Override
    public User findByUserName(String userName) {

        return userMapper.findByName(userName);
    }
}
