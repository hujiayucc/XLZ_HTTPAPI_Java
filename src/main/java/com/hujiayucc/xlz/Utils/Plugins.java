/*
 * @Author: hujiayucc
 * @Date: 2022-08-14 00:18:42
 * @Description: 文件描述
 */
package com.hujiayucc.xlz.Utils;

public interface Plugins {
    String privateMsg(Long robot, Long qq, String msg, String type, Api api);
    String groupMsg(Long robot, Long group, Long qq, String msg, String type, Api api);
    String Event(Long robot, Long group, Long qq, String msg, String type, Api api);
}
