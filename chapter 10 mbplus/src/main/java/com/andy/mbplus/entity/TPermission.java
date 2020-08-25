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
 * @since 2020-04-27
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "权限表", description = "与用户角色关联")
public class TPermission extends Model<TPermission> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(value = "随机生成流水号",required = true)
    private Integer id;

    /**
     * 权限名
     */
    @ApiModelProperty(value = "权限的名字",required = true)
    private String permissionname;

    /**
     * 外键关联role
     */
    @ApiModelProperty(value = "角色ID",required = true)
    private Integer roleId;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
