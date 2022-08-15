/*
 * @Author: hujiayucc
 * @Date: 2022-08-14 00:18:42
 * @Description: 文件描述
 */
package com.hujiayucc.xlz.Utils;

import org.springframework.scheduling.annotation.Async;

@Async("xlz")
public interface Plugins {
    @Async("xlz")
    void privateMsg(Long robot, Long qq, String msg, String type, Api api);
    @Async("xlz")
    void groupMsg(Long robot, Long group, Long qq, String msg, String type, Api api);
    @Async("xlz")
    void Event(Long robot, Long group, Long qq, String msg, String type, Api api);
}