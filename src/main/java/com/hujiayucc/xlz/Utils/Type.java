/*
 * @Author: hujiayucc
 * @Date: 2022-08-10 10:53:36
 * @Description: 文件描述
 */
package com.hujiayucc.xlz.Utils;

public interface Type {
    public static final boolean 真 = true;
    public static final boolean 假 = false;

    public static final String 文件类型_本地 = "path";
    public static final String 文件类型_网络 = "url";

    public static final String 发送消息_普通消息 = null;
    public static final String 发送消息_XML = "xml";
    public static final String 发送消息_JSON = "json";

    public static final String 事件类型_私聊消息 = "privatemsg";
    public static final String 事件类型_群聊消息 = "groupmsg";
    public static final String 事件类型_事件 = "eventmsg";
    public static final String 事件类型_频道推送数据 = "guildpush";

    public static final String 群权限_发起新的群聊 = "newgroup";
    public static final String 群权限_发起临时会话 = "newtempsession";
    public static final String 群权限_上传文件 = "uploadfile";
    public static final String 群权限_上传图片 = "uploadimage";
    public static final String 群权限_邀请好友加群 = "invitefriend";
    public static final String 群权限_匿名聊天 = "anonymouschat";
    public static final String 群权限_坦白说 = "tanbaishuo";
    public static final String 群权限_新成员查看历史消息 = "viewhistmsg";
    public static final String 群权限2_邀请方式设置 = "setinviteway";
    public static final String 群权限2_限制发言频率 = "limitmsgspd";
    public static final String 群权限2_设置群昵称规则 = "setnicknamerule";
    public static final String 群权限2_设置群查找方式 = "setsearchway";
    public static final int 群权限2_无需审核 = 1;
    public static final int 群权限2_需要审核 = 3;
    public static final int 群权限2_100人以内无要审核 = 3;
    public static final int 群权限2_发言无限制 = 0;
    public static final int 群权限2_不允许查找 = 0;
    public static final int 群权限2_通过群号和关键词 = 1;
    public static final int 群权限2_仅可通过群号 = 2;

    public static final String 撤回类型_私聊 = "private";
    public static final String 撤回类型_群聊 = "group";
    public static final String 撤回类型_讨论组 = "discussion";

    public static final int 文件转发_群文件转发至群 = 1;
    public static final int 文件转发_群文件转发至好友 = 2;
    public static final int 文件转发_好友文件转发至好友 = 3;
    public static final int 文件转发_讨论组文件转发至群 = 4;
    public static final int 文件转发_讨论组文件转发至好友 = 5;
    
    public static final int 群消息接收_接收并提醒 = 1;
    public static final int 群消息接收_收进群助手 = 2;
    public static final int 群消息接收_屏蔽群消息 = 3;
    public static final int 群消息接收_接收不提醒 = 4;

    public static final int 语音类型_普通语音 = 0;
    public static final int 语音类型_变声语音 = 1;
    public static final int 语音类型_文字语音 = 2;
    public static final int 语音类型_红包语音 = 3;
}
