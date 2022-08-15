/*
 * @Author: hujiayucc
 * @Date: 2022-08-16 06:14:04
 * @Description: 文件描述
 */
package com.hujiayucc.xlz.Utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.hujiayucc.xlz.Plugins.Plugins;

@Service
@Async("xlz")
public class Plugin implements Type {
    private String type;
    private Long robot;
    private Long qq;
    private Long group;
    private String privatemsg;
    private String groupmsg;
    private String event;

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private Plugins plugins;

    @Async("xlz")
    public void run(String param) {
        JSONObject jsonObject = JSONObject.parseObject(param);
        JSONObject msgJsonObject = jsonObject.getJSONObject("msg");
        JSONObject qqJsonObject = jsonObject.getJSONObject("fromqq");
        JSONObject groupJsonObject = jsonObject.getJSONObject("fromgroup");
        type = (jsonObject.getString("type") == null) ? "null" : jsonObject.getString("type");
        robot = (jsonObject.getLong("logonqq") == null) ? 0L : jsonObject.getLong("logonqq");
        qq = (qqJsonObject.getLong("qq") == null) ? 0L : qqJsonObject.getLong("qq");
        group = (groupJsonObject.getLong("group") == null) ? 0L : groupJsonObject.getLong("group");
        privatemsg = (msgJsonObject.getString("text") == null) ? "null" : msgJsonObject.getString("text");
        groupmsg = (msgJsonObject.getString("msg") == null) ? "null" : msgJsonObject.getString("msg");
        runPlugins(type);
    }

    /**
     * 运行插件
     * 
     * @param mod     事件类型
     * @param plugins @Resource的Api
     */
    @Async("xlz")
    private void runPlugins(String mod) {
        switch (mod) {
            case 事件类型_私聊消息:
                logger.info("robot:" + robot.toString() + "  qq:" + qq.toString() + "  message:" + privatemsg);
                plugins.privateMsg(robot, qq, privatemsg, type);
                break;
            case 事件类型_群聊消息:
                logger.info("robot:" + robot.toString() + "  group:" + group.toString() + "  qq:" + qq.toString()
                        + "  message:" + groupmsg);
                plugins.groupMsg(robot, group, qq, groupmsg, type);
                break;
            case 事件类型_事件:
                plugins.Event(robot, group, qq, event, type);
                break;
            default:
                break;
        }
    }
}
