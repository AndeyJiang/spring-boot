package com.andey.controller;

import com.andey.vo.User;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by jiangbin on 2018/11/15.
 */
@RestController
@RequestMapping(value = "/users")
public class UserController {

      @ApiOperation(value = "获取所有用户列表",notes="")
      @RequestMapping(value = "/getUsers",method = RequestMethod.POST)
      public Map<Long,User> getUserList(){
          Map<Long,User>  userList= Collections.synchronizedMap(new HashMap<Long,User>());
          User user=new User();
          user.setName("Swagger2");
          user.setAge(20);
          user.setId("SEW1");
          userList.put(1L,user);
          return  userList;
      }

      @ApiOperation(value = "获取用户名称",notes = "根据用户ID来获取用户姓名")
      @RequestMapping(value = "/getName",method = RequestMethod.POST)
      @ApiImplicitParam(name="id",value = "用户ID", required = true,dataType="String")
      public  String getUserName(String id){
          User user=new User();
          user.setName("Swagger2");
          user.setAge(20);
          user.setId("SEW1");
          return user.getName();
      }

}
