package com.andey.service;

import com.andey.entity.User;
import org.apache.ibatis.annotations.Param;

/**
 * Created by jiangbin on 2018/11/27.
 */
public interface UserService {

    User findByUserName(@Param("userName") String userName);
}
