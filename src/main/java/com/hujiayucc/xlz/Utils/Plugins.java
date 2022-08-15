/*
 * @Author: hujiayucc
 * @Date: 2022-08-14 00:18:42
 * @Description: 文件描述
 */
package com.hujiayucc.xlz.Utils;

import org.springframework.scheduling.annotation.Async;

@Async
public interface Plugins {
    @Async
    void privateMsg(Long robot, Long qq, String msg, String type, Api api);
    @Async
    void groupMsg(Long robot, Long group, Long qq, String msg, String type, Api api);
    @Async
    void Event(Long robot, Long group, Long qq, String msg, String type, Api api);
}