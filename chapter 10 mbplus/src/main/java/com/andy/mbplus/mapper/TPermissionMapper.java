package com.andy.mbplus.mapper;

import com.andy.mbplus.entity.TPermission;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

import java.util.Set;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Andy
 * @since 2020-04-27
 */
public interface TPermissionMapper extends BaseMapper<TPermission> {
    @Select("select permissionName from t_permission where role_id in (select role_id from t_user where userName=#{usrName})")
    Set<String> getPermission(String usrName);

}
