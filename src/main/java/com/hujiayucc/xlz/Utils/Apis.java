/*
 * @Author: hujiayucc
 * @Date: 2022-08-14 04:45:32
 * @Description: 文件描述
 */
package com.hujiayucc.xlz.Utils;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Apis implements Api, Type, Color, Url {
    @Autowired
    private Lib lib;

    private static Map<String, Object> param = new HashMap<String, Object>();
    private static String ret;
    private static String Log = "log";
    private static String Textclr = "textclr";
    private static String Bgclr = "bgclr";
    private static String Robot = "logonqq";
    private static String Group = "group";
    private static String QQ = "toqq";
    private static String Msg = "msg";
    private static String Type = "type";
    private static String Anonymous = "anonymous";

    @Override
    public String 输出日志(String log, int textColor, int bgColor) {
        param.put(Log, log);
        param.put(Textclr, textColor);
        param.put(Bgclr, bgColor);
        ret = lib.POST(输出日志, param);
        param.clear();
        return ret;
    }

    @Override
    public String 发送好友消息(Long robot, Long qq, String msg, String type) {
        param.put(Robot, robot);
        param.put(QQ, qq);
        param.put(Msg, msg);
        param.put(Type, type);
        ret = lib.POST(发送好友消息, param);
        param.clear();
        return ret;
    }

    @Override
    public String 发送群消息(Long robot, Long group, String msg, String type, boolean anonymous) {
        param.put(Robot, robot);
        param.put(Group, group);
        param.put(Msg, msg);
        param.put(Type, type);
        param.put(Anonymous, String.valueOf(anonymous));
        ret = lib.POST(发送群消息, param);
        param.clear();
        return ret;
    }
}
