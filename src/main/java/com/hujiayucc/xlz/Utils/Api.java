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
     * @param log 日志文本
     * @param textColor 字体颜色
     * @param bgColor 背景颜色
     * @return 处理结果
     */
    String 输出日志(String log, int textColor, int bgColor);
    /**
     * 
     * @param robot 框架QQ
     * @param toqq 对方QQ
     * @param msg 消息内容
     * @param type 发送消息_XXX
     * @return 处理结果
     */
    String 发送好友消息(Long robot, Long qq, String msg, String type);
    /**
     * 发送群消息
     * 
     * @param robot 框架QQ
     * @param group 消息群号
     * @param msg 消息内容
     * @param type 发送消息_XXX
     * @param anonymous 是否匿名
     * @return 处理结果
     */
    String 发送群消息(Long robot, Long group, String msg, String type, boolean anonymous);
}