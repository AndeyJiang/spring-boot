package com.andy.mbplus.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author Andy
 * @since 2020-04-26
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "用户表",description = "关联用户的角色")
public class TUser extends Model<TUser> {

    private static final long serialVersionUID = 1L;

    /**
     * 用户主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(value = "随机生成流水号",required = true)
    private Integer id;

    /**
     * 用户名
     */
    @ApiModelProperty(value = "用户姓名-登录用户名",required = true)
    private String username;

    /**
     * 密码
     */
    @ApiModelProperty(value = "用户登录密码-显示密码",required = true)
    private String password;

    /**
     * 外键关联role表
     */
    @ApiModelProperty(value = "角色ID-> 1-admin; 2-teacher; 3-student",required = true)
    private Integer roleId;

    public TUser(Integer id, String username, String password, Integer roleId) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.roleId = roleId;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
