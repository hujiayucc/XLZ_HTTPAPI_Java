/*
 * @Author: hujiayucc
 * @Date: 2022-08-10 10:53:36
 * @Description: 文件描述
 */
package com.hujiayucc.xlz.Utils;

public interface Type {
    public static final boolean 真 = true;
    public static final boolean 假 = false;

    public static final String 发送消息_普通消息 = null;
    public static final String 发送消息_XML = "xml";
    public static final String 发送消息_JSON = "json";

    public static final String 事件类型_私聊消息 = "privatemsg";
    public static final String 事件类型_群聊消息 = "groupmsg";
    public static final String 事件类型_事件 = "eventmsg";
    public static final String 事件类型_频道推送数据 = "guildpush";
}
