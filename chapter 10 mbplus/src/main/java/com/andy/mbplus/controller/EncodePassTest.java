package com.andy.mbplus.controller;


import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

public class EncodePassTest {

    public static void main(String[] args) throws Exception {
        ByteSource salt = ByteSource.Util.bytes("csdn1");
        String inPassword = new SimpleHash("sha-1", //加密方式
                "12345",//密码原值
                salt,//盐值
                916//加密次数
        ).toString();
        System.out.println(inPassword);
    }

}
