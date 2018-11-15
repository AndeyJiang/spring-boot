package com.andey.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.annotation.sql.DataSourceDefinition;

/**
 * Created by jiangbin on 2018/11/15.
 */
@Data
@ApiModel(value = "User对象",description = "封装的用户信息")
public class User {

    @ApiModelProperty(value = "年龄")
    private  Integer age;

    @ApiModelProperty(value = "姓名")
    private  String name;

    @ApiModelProperty(value =  "用户ID")
    private  String  id;

}
