/*
 * @Author: hujiayucc
 * @Date: 2022-08-13 09:30:19
 * @Description: 文件描述
 */
package com.hujiayucc.xlz.Utils;

import org.springframework.stereotype.Service;

@Service
public interface Api {
    /**
     * 输出日志
     * 
     * @param log       日志文本
     * @param textColor 字体颜色
     * @param bgColor   背景颜色
     */
    void 输出日志(String log, int textColor, int bgColor);

    /**
     * 
     * @param robot 框架QQ
     * @param toqq  对方QQ
     * @param msg   消息文本
     * @param type  发送消息_XXX
     */
    void 发送好友消息(Long robot, Long qq, String msg, String type);

    /**
     * 发送群消息
     * 
     * @param robot     框架QQ
     * @param group     消息群号
     * @param msg       消息文本
     * @param type      发送消息_XXX
     * @param anonymous 是否匿名
     */
    void 发送群消息(Long robot, Long group, String msg, String type, boolean anonymous);

    /**
     * 发送群临时消息
     * 
     * @param robot 框架QQ
     * @param group 群号
     * @param qq    对方QQ
     * @param msg   消息文本
     */
    void 发送群临时消息(Long robot, Long group, Long qq, String msg);

    /**
     * 发送讨论组消息
     * 
     * @param robot        框架QQ
     * @param discussionid 讨论组ID
     * @param msg          消息文本
     * @param type         发送消息_XXX
     * 
     */
    void 发送讨论组消息(Long robot, Long discussionid, String msg, String type);

    /**
     * 发送讨论组临时消息
     * 
     * @param robot        框架QQ
     * @param discussionid 讨论组ID
     * @param qq           对方QQ
     * @param msg          消息文本
     * 
     */
    void 发送讨论组临时消息(Long robot, Long discussionid, Long qq, String msg);

    /**
     * 添加好友
     * 
     * @param robot  框架QQ
     * @param qq     对方QQ
     * @param msg    验证消息文本
     * @param remark 备注
     * 
     */
    void 添加好友(Long robot, Long qq, String msg, String remark);

    void 添加群(Long robot, Long group, String msg);

    void 删除好友(Long robot, Long qq);

    void 置屏蔽好友(Long robot, Long qq, boolean isblock);

    void 置特别关心好友(Long robot, Long qq, boolean iscare);

    void 上传好友图片(Long robot, Long qq, String pic, boolean isflash, String type, boolean isgif);

    void 上传群图片(Long robot, Long group, String pic, boolean isflash, String type, boolean isgif);

    void 上传好友语音(Long robot, Long qq, int audiotype, String text, String type, String audio, int time);

    void 上传群语音(Long robot, Long group, int audiotype, String text, String type, String audio, int time);

    void 上传头像(Long robot, String type, String pic);

    void 设置群名片(Long robot, Long group, Long qq, String newcard);

    void 取昵称(Long robot, Long qq, boolean fromcache);

    void 获取skey(Long robot);

    void 获取pskey(Long robot, String domain);

    void 获取clientkey(Long robot);

    void 取框架QQ();

    void 取好友列表(Long robot);

    void 取群列表(Long robot);

    void 取群成员列表(Long robot, Long group);

    void 设置管理员(Long robot, Long group, Long qq, boolean unadmin);

    void 取群管理层列表(Long robot, Long group);

    void 取群名片(Long robot, Long group, Long qq);

    void 取个性签名(Long robot, Long qq);

    void 修改昵称(Long robot, String nickname);

    void 修改个性签名(Long robot, String signat, String pos);

    void 删除群成员(Long robot, Long group, Long qq, boolean ignoreaddgrequest);

    void 禁言群成员(Long robot, Long group, Long qq, int time);

    void 退群(Long robot, Long group, boolean dismiss);

    void 上传群头像(Long robot, Long group, String type, String pic);

    void 全员禁言(Long robot, Long group, boolean ismute);

    void 设置群权限(Long robot, Long group, String type, boolean isallow);

    void 设置群权限2(Long robot, Long group, String type, int value);

    void 撤回消息(Long robot, Long qqorgroup, String type, Long random, Long req, Long time);

    void 设置位置共享(Long robot, Long group, String longs, String lat, boolean enable);

    void 上报当前位置(Long robot, Long group, String longs, String lat);

    void 取禁言时长(Long robot, Long group);

    void 处理群验证事件(Long robot, Long group, Long qq, Long seq, int optype, int eventtype, String reason, boolean isrisk);

}