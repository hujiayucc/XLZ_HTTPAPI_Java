/*
 * @Author: hujiayucc
 * @Date: 2022-08-14 04:45:32
 * @Description: 文件描述
 */
package com.hujiayucc.xlz.Utils;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@Async("xlz")
public class Api implements Type, Color, Url {
    @Autowired
    private Lib lib;

    @Async("xlz")
    public void 输出日志(String log, int textColor, int bgColor) {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("log", log);
        param.put("textclr", textColor);
        param.put("bgclr", bgColor);
        lib.POST(输出日志, param);
    }

    @Async("xlz")
    public void 发送好友消息(Long robot, Long qq, String msg, String type) {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("logonqq", robot);
        param.put("toqq", qq);
        param.put("msg", msg);
        param.put("type", type);
        lib.POST(发送好友消息, param);
    }

    @Async("xlz")
    public void 发送群消息(Long robot, Long group, String msg, String type, boolean anonymous) {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("logonqq", robot);
        param.put("group", group);
        param.put("msg", msg);
        param.put("type", type);
        param.put("anonymous", String.valueOf(anonymous));
        lib.POST(发送群消息, param);
    }

    @Async("xlz")
    public void 发送群临时消息(Long robot, Long group, Long qq, String msg) {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("logonqq", robot);
        param.put("group", group);
        param.put("toqq", qq);
        param.put("msg", msg);
        lib.POST(发送群临时消息, param);
    }

    @Async("xlz")
    public void 发送讨论组消息(Long robot, Long discussionid, String msg, String type) {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("logonqq", robot);
        param.put("discussionid", discussionid);
        param.put("msg", msg);
        param.put("type", type);
        lib.POST(发送讨论组消息, param);
    }

    @Async("xlz")
    public void 发送讨论组临时消息(Long robot, Long discussionid, Long qq, String msg) {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("logonqq", robot);
        param.put("discussionid", discussionid);
        param.put("toqq", qq);
        param.put("msg", msg);
        lib.POST(发送讨论组临时消息, param);
    }

    @Async("xlz")
    public void 添加好友(Long robot, Long qq, String msg, String remark) {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("logonqq", robot);
        param.put("toqq", qq);
        param.put("msg", msg);
        param.put("remark", remark);
        lib.POST(添加好友, param);
    }

    @Async("xlz")
    public void 添加群(Long robot, Long group, String msg) {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("logonqq", robot);
        param.put("group", group);
        param.put("msg", msg);
        lib.POST(添加群, param);
    }

    @Async("xlz")
    public void 删除好友(Long robot, Long qq) {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("logonqq", robot);
        param.put("toqq", qq);
        lib.POST(删除好友, param);
    }

    @Async("xlz")
    public void 置屏蔽好友(Long robot, Long qq, boolean isblock) {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("logonqq", robot);
        param.put("toqq", qq);
        param.put("isblock", String.valueOf(isblock));
        lib.POST(置屏蔽好友, param);
    }

    @Async("xlz")
    public void 置特别关心好友(Long robot, Long qq, boolean iscare) {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("logonqq", robot);
        param.put("toqq", qq);
        param.put("iscare", String.valueOf(iscare));
        lib.POST(置特别关心好友, param);
    }

    @Async("xlz")
    public void 上传好友图片(Long robot, Long qq, String pic, boolean isflash, String type, boolean isgif) {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("logonqq", robot);
        param.put("toqq", qq);
        param.put("pic", pic);
        param.put("isflash", String.valueOf(isflash));
        param.put("type", type);
        param.put("isgif", String.valueOf(isgif));
        lib.POST(上传好友图片, param);
    }

    @Async("xlz")
    public void 上传群图片(Long robot, Long group, String pic, boolean isflash, String type, boolean isgif) {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("logonqq", robot);
        param.put("group", group);
        param.put("pic", pic);
        param.put("isflash", String.valueOf(isflash));
        param.put("type", type);
        param.put("isgif", isgif);
        lib.POST(上传群图片, param);
    }

    @Async("xlz")
    public void 上传好友语音(Long robot, Long qq, int audiotype, String text, String type, String audio, int time) {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("logonqq", robot);
        param.put("toqq", qq);
        param.put("audiotype", audiotype);
        param.put("text", text);
        param.put("type", type);
        param.put("audio", audio);
        param.put("time", time);
        lib.POST(上传好友语音, param);
    }

    @Async("xlz")
    public void 上传群语音(Long robot, Long group, int audiotype, String text, String type, String audio, int time) {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("logonqq", robot);
        param.put("group", group);
        param.put("audiotype", audiotype);
        param.put("text", text);
        param.put("type", type);
        param.put("audio", audio);
        param.put("time", time);
        lib.POST(上传群语音, param);
    }

    @Async("xlz")
    public void 上传头像(Long robot, String type, String pic) {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("logonqq", robot);
        param.put("type", type);
        param.put("pic", pic);
        lib.POST(上传头像, param);
    }

    @Async("xlz")
    public void 设置群名片(Long robot, Long group, Long qq, String newcard) {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("logonqq", robot);
        param.put("group", group);
        param.put("toqq", qq);
        param.put("newcard", newcard);
        lib.POST(设置群名片, param);
    }

    @Async("xlz")
    public void 取昵称(Long robot, Long qq, boolean fromcache) {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("logonqq", robot);
        param.put("toqq", qq);
        param.put("fromcache", fromcache);
        lib.POST(取昵称, param);
    }

    @Async("xlz")
    public void 获取skey(Long robot) {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("logonqq", robot);
        lib.POST(获取skey, param);
    }

    @Async("xlz")
    public void 获取pskey(Long robot, String domain) {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("logonqq", robot);
        param.put("domain", domain);
        lib.POST(获取pskey, param);
    }

    @Async("xlz")
    public void 获取clientkey(Long robot) {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("logonqq", robot);
        lib.POST(获取clientkey, param);
    }

    @Async("xlz")
    public void 取框架QQ() {
        Map<String, Object> param = new HashMap<String, Object>();
        lib.POST(取框架QQ, param);
    }

    @Async("xlz")
    public void 取好友列表(Long robot) {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("logonqq", robot);
        lib.POST(取好友列表, param);
    }

    @Async("xlz")
    public void 取群列表(Long robot) {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("logonqq", robot);
        lib.POST(取群列表, param);
    }

    @Async("xlz")
    public void 取群成员列表(Long robot, Long group) {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("logonqq", robot);
        param.put("group", group);
        lib.POST(取群成员列表, param);
    }

    @Async("xlz")
    public void 设置管理员(Long robot, Long group, Long qq, boolean unadmin) {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("logonqq", robot);
        param.put("group", group);
        param.put("toqq", qq);
        param.put("unadmin", String.valueOf(unadmin));
        lib.POST(设置管理员, param);
    }

    @Async("xlz")
    public void 取群管理层列表(Long robot, Long group) {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("logonqq", robot);
        param.put("group", group);
        lib.POST(取群管理层列表, param);
    }

    @Async("xlz")
    public void 取群名片(Long robot, Long group, Long qq) {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("logonqq", robot);
        param.put("group", group);
        param.put("toqq", qq);
        lib.POST(取群名片, param);
    }

    @Async("xlz")
    public void 取个性签名(Long robot, Long qq) {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("logonqq", robot);
        param.put("toqq", qq);
        lib.POST(取个性签名, param);
    }

    @Async("xlz")
    public void 修改昵称(Long robot, String nickname) {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("logonqq", robot);
        param.put("nickname", nickname);
        lib.POST(修改昵称, param);
    }

    @Async("xlz")
    public void 修改个性签名(Long robot, String signat, String pos) {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("logonqq", robot);
        param.put("signat", signat);
        param.put("pos", pos);
        lib.POST(修改个性签名, param);
    }

    @Async("xlz")
    public void 删除群成员(Long robot, Long group, Long qq, boolean ignoreaddgrequest) {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("logonqq", robot);
        param.put("group", group);
        param.put("toqq", qq);
        param.put("ignoreaddgrequest", String.valueOf(ignoreaddgrequest));
        lib.POST(删除群成员, param);
    }

    @Async("xlz")
    public void 禁言群成员(Long robot, Long group, Long qq, int time) {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("logonqq", robot);
        param.put("group", group);
        param.put("toqq", qq);
        param.put("time", time);
        lib.POST(禁言群成员, param);
    }

    @Async("xlz")
    public void 退群(Long robot, Long group, boolean dismiss) {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("logonqq", robot);
        param.put("group", group);
        param.put("dismiss", String.valueOf(dismiss));
        lib.POST(退群, param);
    }

    @Async("xlz")
    public void 上传群头像(Long robot, Long group, String type, String pic) {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("logonqq", robot);
        param.put("group", group);
        param.put("type", type);
        param.put("pic", pic);
        lib.POST(上传群头像, param);
    }

    @Async("xlz")
    public void 全员禁言(Long robot, Long group, boolean ismute) {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("logonqq", robot);
        param.put("group", group);
        param.put("ismute", String.valueOf(ismute));
        lib.POST(全员禁言, param);
    }

    @Async("xlz")
    public void 设置群权限(Long robot, Long group, String type, boolean isallow) {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("logonqq", robot);
        param.put("group", group);
        param.put("type", type);
        param.put("isallow", String.valueOf(isallow));
        lib.POST(设置群权限, param);
    }

    @Async("xlz")
    public void 设置群权限2(Long robot, Long group, String type, int value) {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("logonqq", robot);
        param.put("group", group);
        param.put("type", type);
        param.put("value", value);
        lib.POST(设置群权限, param);
    }

    @Async("xlz")
    public void 撤回消息(Long robot, Long qq, String type, Long random, Long req, Long time) {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("logonqq", robot);
        param.put("type", type);
        switch (type) {
            case 撤回类型_私聊:
                param.put("toqq", qq);
                param.put("time", time);
                break;
            case 撤回类型_群聊:
                param.put("group", qq);
                break;
            case 撤回类型_讨论组:
                param.put("discussionid", qq);
                break;
            default:
                System.out.println("type参数错误");
                ;
                return;
        }
        param.put("random", random);
        param.put("req", req);
        lib.POST(撤回消息, param);
    }

    @Async("xlz")
    public void 设置位置共享(Long robot, Long group, String longs, String lat, boolean enable) {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("logonqq", robot);
        param.put("group", group);
        param.put("long", longs);
        param.put("lat", lat);
        param.put("enable", String.valueOf(enable));
        lib.POST(设置位置共享, param);
    }

    @Async("xlz")
    public void 上报当前位置(Long robot, Long group, String longs, String lat) {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("logonqq", robot);
        param.put("group", group);
        param.put("long", longs);
        param.put("lat", lat);
        lib.POST(上报当前位置, param);
    }

    @Async("xlz")
    public void 取禁言时长(Long robot, Long group) {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("logonqq", robot);
        param.put("group", group);
        lib.POST(取禁言时长, param);
    }

    @Async("xlz")
    public void 处理群验证事件(Long robot, Long group, Long qq, Long seq, int optype, int eventtype, String reason,
            boolean isrisk) {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("logonqq", robot);
        param.put("group", group);
        param.put("fromqq", qq);
        param.put("seq", seq);
        param.put("optype", optype);
        param.put("eventtype", eventtype);
        param.put("reason", reason);
        param.put("isrisk", String.valueOf(isrisk));
        lib.POST(处理群验证事件, param);
    }
}
