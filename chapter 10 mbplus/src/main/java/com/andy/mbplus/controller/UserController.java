package com.andy.mbplus.controller;

import com.alibaba.fastjson.JSON;
import com.andy.mbplus.entity.TUser;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/user")
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    /**
     * 身份认证测试接口
     * @param request
     * @return
     */
    @RequestMapping("/admin")
    @ResponseBody
    public String admin(HttpServletRequest request) {
        Object user = request.getSession().getAttribute("user");
        return JSON.toJSONString(user);
    }

    /**
     * 角色认证测试接口
     * @param request
     * @return
     */
    @RequestMapping("/student")
    @ResponseBody
    public String student(HttpServletRequest request) {
        return "success";
    }

    /**
     * 权限认证测试接口
     * @param request
     * @return
     */
    @RequestMapping("/teacher")
    @ResponseBody
    public String teacher(HttpServletRequest request) {
        return "success";
    }

    /**
     * 用户登录接口
     * @param user user
     * @param
     * @return string
     */

    @PostMapping("/login")
    @ResponseBody
    public String login(@RequestBody  TUser user) {

        // 根据用户名和密码创建 Token
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(), user.getPassword());
        // 获取 subject 认证主体
        Subject currentUser = SecurityUtils.getSubject();
        try{
            // 开始认证，这一步会跳到我们自定义的 Realm 中
            currentUser.login(token);
            return "success";
        }catch(UnknownAccountException uae){
            logger.info("对用户[" + user.getUsername() + "]进行登录验证..验证未通过,未知账户");
            return "login";
        }catch(IncorrectCredentialsException ice){
            logger.info("对用户[" + user.getUsername() + "]进行登录验证..验证未通过,错误的凭证");
            return "login";
        }catch(LockedAccountException lae){
            logger.info("对用户[" + user.getUsername() + "]进行登录验证..验证未通过,账户已锁定");
            return "login";
        }catch(ExcessiveAttemptsException eae){
            logger.info("对用户[" + user.getUsername() + "]进行登录验证..验证未通过,错误次数过多");
            return "login";
        }catch(AuthenticationException ae){
            //通过处理Shiro的运行时AuthenticationException就可以控制用户登录失败或密码错误时的情景
            logger.info("对用户[" + user.getUsername() + "]进行登录验证..验证未通过,堆栈轨迹如下");
            ae.printStackTrace();
            return "login";
        }
    }

}
