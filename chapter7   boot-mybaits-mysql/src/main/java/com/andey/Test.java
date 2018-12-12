package com.andey;

import com.andey.entity.User;
import com.andey.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by jiangbin on 2018/12/7.
 */
@RestController
public class Test {
    @Autowired
    UserService userService;

    @RequestMapping("/test")
    public  void  test(String userName){
        User user=userService.findByUserName(userName);

        System.out.print(user.getEmail());
    }
}
