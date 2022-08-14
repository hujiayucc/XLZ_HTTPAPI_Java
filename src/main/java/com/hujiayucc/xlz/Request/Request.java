/*
 * @Author: hujiayucc
 * @Date: 2022-08-10 01:13:55
 * @Description: 文件描述
 */
package com.hujiayucc.xlz.Request;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseBody;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.hujiayucc.xlz.Data.Config;
import com.hujiayucc.xlz.Plugins.插件模板;
import com.hujiayucc.xlz.Utils.Apis;
import com.hujiayucc.xlz.Utils.Color;
import com.hujiayucc.xlz.Utils.Plugins;
import com.hujiayucc.xlz.Utils.Type;

@Controller
public class Request implements Type, Color {
    private static String type;
    private static Long robot;
    private static Long qq;
    private static Long group;
    private static String privatemsg;
    private static String groupmsg;
    private static String event;
    private String ret;

    @Autowired
    private Apis api;

    @GetMapping(value = "/getconfig", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    private ResponseEntity<String> index(@RequestHeader("Host") String host) {
        HashMap<String, Object> data = new HashMap<>();
        if (host.equals("127.0.0.1:" + Config.getPort())) {
            data.put("host", Config.getHost());
            data.put("username", Config.getUsername());
            data.put("password", Config.getPassword());
            data.put("ua", Config.getUa());
            String json = JSON.toJSONString(data);
            return new ResponseEntity<String>(json, HttpStatus.OK);
        } else {
            data.put("code", 502);
            return new ResponseEntity<String>(Config.getHost(), HttpStatus.OK);
        }
    }

    @PostMapping(value = "/msg", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    private ResponseEntity<String> msg(@RequestHeader("Password") String CT, @RequestBody String param) {
        HashMap<String, Object> data = new HashMap<>();
        if (CT.equals(Config.getPassword())) {
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
            runPlugins(type, new 插件模板());
            return new ResponseEntity<String>("", HttpStatus.OK);
        } else {
            data.put("code", 502);
            data.put("text", "password error");
            return new ResponseEntity<String>(JSON.toJSONString(data), HttpStatus.BAD_GATEWAY);
        }
    }
    /**
     * 运行插件
     * 
     * @param mod 事件类型
     * @param plugins @Resource的Api
     */
    private void runPlugins(String mod, Plugins plugins) {
        switch (mod) {
            case 事件类型_私聊消息:
                System.out.println("robot:" + robot.toString() + "  qq:" + qq.toString() + "  message:" + privatemsg);
                ret = plugins.privateMsg(robot, qq, privatemsg, type, api);
                if(!ret.equals("null"))
                    System.out.println(ret);
                break;
            case 事件类型_群聊消息:
                System.out.println("robot:" + robot.toString() + "  group:" + group.toString() + "  qq:" + qq.toString() + "  message:" + groupmsg);
                ret = plugins.groupMsg(robot, group, qq, groupmsg, type, api);
                if(!ret.equals("null"))
                    System.out.println(ret);
                break;
            case 事件类型_事件:
                ret = plugins.Event(robot, group, qq, event, type, api);
                if(!ret.equals("null"))
                    System.out.println(ret);
                break;
            default:
                break;
        }
    }
}