package com.andy.mbplus.common.shiro;
import com.andy.mbplus.entity.TUser;
import com.andy.mbplus.mapper.TPermissionMapper;
import com.andy.mbplus.mapper.TRoleMapper;
import com.andy.mbplus.mapper.TUserMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 自定义realm
 * @author  Jiang Bin
 */
public class MyRealm extends AuthorizingRealm {
    @Autowired
    private TUserMapper tUserMapper;
    @Autowired
    private TPermissionMapper tPermissionMapper;
    @Autowired
    private TRoleMapper tRoleMapper;

    /**
     * 用户授权和分配角色
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        String userName= (String) principals.getPrimaryPrincipal();
        SimpleAuthorizationInfo authorizationInfo=new SimpleAuthorizationInfo();
        authorizationInfo.setRoles(tRoleMapper.getRole(userName));
        authorizationInfo.setStringPermissions(tPermissionMapper.getPermission(userName));

        return authorizationInfo;
    }

    /**
     * 用户信息认证
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        String username = (String) authenticationToken.getPrincipal();
        TUser tUser=tUserMapper.selectOne(new QueryWrapper<TUser>().lambda().eq(TUser::getUsername,username));
        if(tUser !=null){
            //把当前用户放到session中
            SecurityUtils.getSubject().getSession().setAttribute("user",tUser);
            AuthenticationInfo authenticationInfo=new SimpleAuthenticationInfo(tUser.getUsername(),tUser.getPassword(),"myRealm");
            return  authenticationInfo;
        }else{
            return null;
        }

    }
}
