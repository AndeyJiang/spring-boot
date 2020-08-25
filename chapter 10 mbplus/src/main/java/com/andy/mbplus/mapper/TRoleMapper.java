package com.andy.mbplus.mapper;

import com.andy.mbplus.entity.TRole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

import java.util.Set;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Andy
 * @since 2020-04-26
 */
public interface TRoleMapper extends BaseMapper<TRole> {

 @Select("select roleName from t_role where id in (select  role_id  from t_user where userName=#{userName}) ")
 Set<String> getRole(String userName);

}
