package com.andy.mbplus.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
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
 * @since 2019-12-27
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("USER")
@ApiModel(value = "User对象",description = "封装的用户信息")
public class User extends Model<User> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "userId",type = IdType.INPUT)
    @ApiModelProperty(value = "ID",required = true)
    private Integer userId;
    @ApiModelProperty(value = "登录用户名",required = true)
    @TableField("userName")
    private String userName;
    @ApiModelProperty(value = "登录密码",required = true)
    @TableField("passWord")
    private String passWord;
    @ApiModelProperty(value = "用户角色",required = true)
    @TableField("authRole")
    private String authRole;


    @Override
    protected Serializable pkVal() {
        return this.userId;
    }

}
