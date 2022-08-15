/*
 * @Author: hujiayucc
 * @Date: 2022-08-12 04:42:56
 * @Description: 文件描述
 */
package com.hujiayucc.xlz.Plugins;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.hujiayucc.xlz.Utils.Api;
import com.hujiayucc.xlz.Utils.Color;
import com.hujiayucc.xlz.Utils.Lib;
import com.hujiayucc.xlz.Utils.Type;

@Service
@Async("xlz")
public class Plugins implements Type, Color {

    @Autowired
    private Api api;

    /**
     * 私聊
     * 
     * @param robot 框架QQ
     * @param qq    发送人QQ
     * @param msg   消息内容
     * @param type  消息类型
     * @param api   调用API
     */
    @Async("xlz")
    public void privateMsg(Long robot, Long qq, String msg, String type) {
        if (qq.equals(2792607647L)) {
            api.发送好友消息(robot, qq, msg, 发送消息_普通消息);
        }
    }

    /**
     * 群聊
     * 
     * @param robot 框架QQ
     * @param group 消息群号
     * @param qq    发送人QQ
     * @param msg   消息内容
     * @param type  消息类型
     * @param api   调用API
     */
    @Async("xlz")
    public void groupMsg(Long robot, Long group, Long qq, String msg, String type) {
        if (qq != 1908187655L) {
            if (msg.indexOf("咕咕咕") != -1 && !qq.equals(911782632L)) {
                api.发送群消息(robot, group, msg, 发送消息_普通消息, false);
            } else if (qq.equals(2792607647L) && msg.equals("测试Java")) {
                api.发送群消息(robot, group, msg, type, false);
            } else if (msg.indexOf("复读") != -1) {
                api.发送群消息(robot, group, Lib.getRightstr(msg, "复读"), 发送消息_普通消息, false);
            } else if (msg.indexOf("php") != -1 | msg.indexOf("PHP") != -1) {
                msg = "小栗子:https://f.xiaolz.cn/thread-308-1-1.html\n\nGitee:https://gitee.com/hujiayucc/XLZ_HTTPAPI_PHP\n\nGitHub:https://github.com/hujiayucc/XLZ_HTTPAPI_PHP";
                api.发送群消息(robot, group, msg, 发送消息_普通消息, false);
            } else if (msg.indexOf("java") != -1 | msg.indexOf("Java") != -1) {
                msg = "小栗子:https://f.xiaolz.cn/thread-487-1-1.html\n\nGitHub:https://github.com/hujiayucc/XLZ_HTTPAPI_Java\n\nGitee:https://gitee.com/hujiayucc/XLZ_HTTPAPI_Java";
                api.发送群消息(robot, group, msg, 发送消息_普通消息, false);
            }
        }
    }

    /**
     * @param robot 框架QQ
     * @param group 事件群号
     * @param qq    事件QQ
     * @param msg   消息内容
     * @param api   调用API
     */
    @Async("xlz")
    public void Event(Long robot, Long group, Long qq, String msg, String type) {

    }
}
