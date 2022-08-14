/*
 * @Author: hujiayucc
 * @Date: 2022-08-09 22:48:14
 * @Description: 文件描述
 */
package com.hujiayucc.xlz.Data;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.hujiayucc.xlz.Utils.Color;
import com.hujiayucc.xlz.Utils.Type;
import com.hujiayucc.xlz.Utils.Url;

/**
 * @Author: hujiayucc
 * @Date: 2022-08-09 22:48:14
 * @Description: 配置读取
 */

@Service
public class Config implements Color, Type, Url {
    @Value("${server.port}")
    private String port;
    @Value("${config.host}")
    private String host;
    @Value("${config.username}")
    private String username;
    @Value("${config.password}")
    private String password;
    @Value("${config.ua}")
    private String ua;

    // 静态化配置参数
    private static String Port;
    private static String Host;
    private static String UserName;
    private static String PassWord;
    private static String UA;

    @PostConstruct
    public void setDate() {
        Port = this.port;
        Host = this.host;
        UserName = this.username;
        PassWord = this.password;
        UA = this.ua;
    }

    // 获取静态化配置
    public static String getPort() {
        return Port;
    }

    public static String getHost() {
        return Host;
    }

    public static String getUsername() {
        return UserName;
    }

    public static String getPassword() {
        return PassWord;
    }

    public static String getUa() {
        return UA;
    }

    
}