package com.andy.mbplus.controller;


import com.alibaba.fastjson.JSON;

import com.andy.mbplus.entity.OauthClientDetails;
import com.andy.mbplus.entity.User;
import com.andy.mbplus.mapper.OauthClientDetailsMapper;
import com.andy.mbplus.mapper.TPermissionMapper;
import com.andy.mbplus.mapper.TRoleMapper;
import com.andy.mbplus.mapper.UserMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;


/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Andy
 * @since 2019-12-26
 */
@RestController
@Api(value = "测试接口", tags = "测试接口")
@RequestMapping("/user")
@Slf4j
public class TestController {

//    @Autowired
//    UserMapper userMapper;
//    @Autowired
//    OauthClientDetailsMapper oauthClientDetailsMapper;
      @Autowired
      private TRoleMapper tRoleMapper;

    @Autowired
    private TPermissionMapper tPermissionMapper;

    @ApiOperation(value = "Mybatis-Plus测试入口",notes = "Insert Delete Query IPage...")
    @RequestMapping(value = "/getUserInfo",method = RequestMethod.POST)
    @ResponseBody
    public String getUserInfo(String  userName){
//        userMapper.updateById(new User());
         Set<String> roleName=tRoleMapper.getRole(userName);
         Set<String> permission=tPermissionMapper.getPermission(userName);
//        log.info("step 1 --> get one record by id");
//        User user=userMapper.selectOne(new QueryWrapper<User>().lambda().eq(User::getUserId,123456));
//
//        log.info("step 2--> select more than one record as a list");
//        List<User>  userList=userMapper.selectList(new QueryWrapper<User>());
//
//        log.info("step 3--> insert one record");
//        User user1=new User();
//        user1.setUserId(111);
//        user1.setUserName("Test insert");
//        user1.setPassWord("6666");
//        user1.setAuthRole("one");
//        //userMapper.insert(user1);
//
//
//        log.info("step 4 --> insert or update one record by Table Bean through BeanId");
//        User user2=new User();
//        user2.setUserId(222);
//        user2.setUserName("Test insert");
//        user2.setPassWord("6666");
//        user2.setAuthRole("tow");
//        user2.insertOrUpdate();
//
//        log.info("step 5 --> Get only one record from more than one record list");
//        User user3=userMapper.selectOne(new QueryWrapper<User>().lambda().eq(User::getUserName,"Test insert").last("limit 1"));
//
//        log.info("step 6 --> Paging Query ");
//        int pageNum=1;
//        int pageSize=2;
//        IPage<User> userIPage=userMapper.selectPage(new Page<>(pageNum,pageSize),new QueryWrapper<User>().lambda().eq(User::getPassWord,"6666"));
//        List<User> userList1=userIPage.getRecords();
//        long totalPage=userIPage.getPages();
//        log.info("userList1={},totalPage={}",JSON.toJSONString(userList1),totalPage);
//
//
//        log.info("step 7--> Delete one record use Table Bean only or through obvious Interface");
//        userMapper.deleteById(777);
//        User detUser=new User();
//        detUser.deleteById(888);
//        List<User> finaList=userMapper.selectList(new QueryWrapper<User>());
//        log.info("finaResult={}",finaList.toString());
//
//        List<OauthClientDetails> oauthClientDetails =oauthClientDetailsMapper.selectList(new QueryWrapper<OauthClientDetails>());

        return permission.toString();

    }

}

