/*
 * @Author: hujiayucc
 * @Date: 2022-08-14 04:45:32
 * @Description: 文件描述
 */
package com.hujiayucc.xlz.Utils;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Apis implements Api, Type, Color, Url {
    @Autowired
    private Lib lib;

    private static String ret = "null";

    @Override
    public String 输出日志(String log, int textColor, int bgColor) {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("log", log);
        param.put("textclr", textColor);
        param.put("bgclr", bgColor);
        ret = lib.POST(输出日志, param);
        return ret;
    }

    @Override
    public String 发送好友消息(Long robot, Long qq, String msg, String type) {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("logonqq", robot);
        param.put("toqq", qq);
        param.put("msg", msg);
        param.put("type", type);
        ret = lib.POST(发送好友消息, param);
        return ret;
    }

    @Override
    public String 发送群消息(Long robot, Long group, String msg, String type, boolean anonymous) {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("logonqq", robot);
        param.put("group", group);
        param.put("msg", msg);
        param.put("type", type);
        param.put("anonymous", String.valueOf(anonymous));
        ret = lib.POST(发送群消息, param);
        return ret;
    }

    @Override
    public String 发送群临时消息(Long robot, Long group, Long qq, String msg) {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("logonqq", robot);
        param.put("group", group);
        param.put("toqq", qq);
        param.put("msg", msg);
        ret = lib.POST(发送群临时消息, param);
        return ret;
    }

    @Override
    public String 发送讨论组消息(Long robot, Long discussionid, String msg, String type) {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("logonqq", robot);
        param.put("discussionid", discussionid);
        param.put("msg", msg);
        param.put("type", type);
        ret = lib.POST(发送讨论组消息, param);
        return ret;
    }

    @Override
    public String 发送讨论组临时消息(Long robot, Long discussionid, Long qq, String msg) {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("logonqq", robot);
        param.put("discussionid", discussionid);
        param.put("toqq", qq);
        param.put("msg", msg);
        ret = lib.POST(发送讨论组临时消息, param);
        return ret;
    }

    @Override
    public String 添加好友(Long robot, Long qq, String msg, String remark) {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("logonqq", robot);
        param.put("toqq", qq);
        param.put("msg", msg);
        param.put("remark", remark);
        ret = lib.POST(添加好友, param);
        return ret;
    }

    @Override
    public String 添加群(Long robot, Long group, String msg) {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("logonqq", robot);
        param.put("group", group);
        param.put("msg", msg);
        lib.POST(添加群, param);
        return ret;
    }

    @Override
    public String 删除好友(Long robot, Long qq) {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("logonqq", robot);
        param.put("toqq", qq);
        ret = lib.POST(删除好友, param);
        return ret;
    }

    @Override
    public String 置屏蔽好友(Long robot, Long qq, boolean isblock) {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("logonqq", robot);
        param.put("toqq", qq);
        param.put("isblock", String.valueOf(isblock));
        ret = lib.POST(置屏蔽好友, param);
        return ret;
    }

    @Override
    public String 置特别关心好友(Long robot, Long qq, boolean iscare) {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("logonqq", robot);
        param.put("toqq", qq);
        param.put("iscare", String.valueOf(iscare));
        ret = lib.POST(置特别关心好友, param);
        return ret;
    }

    @Override
    public String 上传好友图片(Long robot, Long qq, String pic, boolean isflash, String type, boolean isgif) {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("logonqq", robot);
        param.put("toqq", qq);
        param.put("pic", pic);
        param.put("isflash", String.valueOf(isflash));
        param.put("type", type);
        param.put("isgif", String.valueOf(isgif));
        ret = lib.POST(上传好友图片, param);
        return ret;
    }

    @Override
    public String 上传群图片(Long robot, Long group, String pic, boolean isflash, String type, boolean isgif) {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("logonqq", robot);
        param.put("group", group);
        param.put("pic", pic);
        param.put("isflash", String.valueOf(isflash));
        param.put("type", type);
        param.put("isgif", isgif);
        ret = lib.POST(上传群图片, param);
        return ret;
    }

    @Override
    public String 上传好友语音(Long robot, Long qq, int audiotype, String text, String type, String audio, int time) {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("logonqq", robot);
        param.put("toqq", qq);
        param.put("audiotype", audiotype);
        param.put("text", text);
        param.put("type", type);
        param.put("audio", audio);
        param.put("time", time);
        ret = lib.POST(上传好友语音, param);
        return ret;
    }

    @Override
    public String 上传群语音(Long robot, Long group, int audiotype, String text, String type, String audio, int time) {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("logonqq", robot);
        param.put("group", group);
        param.put("audiotype", audiotype);
        param.put("text", text);
        param.put("type", type);
        param.put("audio", audio);
        param.put("time", time);
        ret = lib.POST(上传群语音, param);
        return ret;
    }

    @Override
    public String 上传头像(Long robot, String type, String pic) {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("logonqq", robot);
        param.put("type", type);
        param.put("pic", pic);
        ret = lib.POST(上传头像, param);
        return ret;
    }

    @Override
    public String 设置群名片(Long robot, Long group, Long qq, String newcard) {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("logonqq", robot);
        param.put("group", group);
        param.put("toqq", qq);
        param.put("newcard", newcard);
        ret = lib.POST(设置群名片, param);
        return ret;
    }

    @Override
    public String 取昵称(Long robot, Long qq, boolean fromcache) {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("logonqq", robot);
        param.put("toqq", qq);
        param.put("fromcache", fromcache);
        ret = lib.POST(取昵称, param);
        return ret;
    }

    @Override
    public String 获取skey(Long robot) {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("logonqq", robot);
        ret = lib.POST(获取skey, param);
        return ret;
    }

    @Override
    public String 获取pskey(Long robot, String domain) {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("logonqq", robot);
        param.put("domain", domain);
        ret = lib.POST(获取pskey, param);
        return ret;
    }

    @Override
    public String 获取clientkey(Long robot) {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("logonqq", robot);
        ret = lib.POST(获取clientkey, param);
        return ret;
    }

    @Override
    public String 取框架QQ() {
        Map<String, Object> param = new HashMap<String, Object>();
        ret = lib.POST(取框架QQ, param);
        return ret;
    }

    @Override
    public String 取好友列表(Long robot) {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("logonqq", robot);
        ret = lib.POST(取好友列表, param);
        return ret;
    }

    @Override
    public String 取群列表(Long robot) {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("logonqq", robot);
        ret = lib.POST(取群列表, param);
        return ret;
    }

    @Override
    public String 取群成员列表(Long robot, Long group) {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("logonqq", robot);
        param.put("group", group);
        ret = lib.POST(取群成员列表, param);
        return ret;
    }

    @Override
    public String 设置管理员(Long robot, Long group, Long qq, boolean unadmin) {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("logonqq", robot);
        param.put("group", group);
        param.put("toqq", qq);
        param.put("unadmin", String.valueOf(unadmin));
        ret = lib.POST(设置管理员, param);
        return ret;
    }

    @Override
    public String 取群管理层列表(Long robot, Long group) {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("logonqq", robot);
        param.put("group", group);
        ret = lib.POST(取群管理层列表, param);
        return ret;
    }

    @Override
    public String 取群名片(Long robot, Long group, Long qq) {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("logonqq", robot);
        param.put("group", group);
        param.put("toqq", qq);
        ret = lib.POST(取群名片, param);
        return ret;
    }

    @Override
    public String 取个性签名(Long robot, Long qq) {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("logonqq", robot);
        param.put("toqq", qq);
        ret = lib.POST(取个性签名, param);
        return ret;
    }

    @Override
    public String 修改昵称(Long robot, String nickname) {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("logonqq", robot);
        param.put("nickname", nickname);
        ret = lib.POST(修改昵称, param);
        return ret;
    }

    @Override
    public String 修改个性签名(Long robot, String signat, String pos) {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("logonqq", robot);
        param.put("signat", signat);
        param.put("pos", pos);
        ret = lib.POST(修改个性签名, param);
        return ret;
    }

    @Override
    public String 删除群成员(Long robot, Long group, Long qq, boolean ignoreaddgrequest) {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("logonqq", robot);
        param.put("group", group);
        param.put("toqq", qq);
        param.put("ignoreaddgrequest", String.valueOf(ignoreaddgrequest));
        ret = lib.POST(删除群成员, param);
        return ret;
    }

    @Override
    public String 禁言群成员(Long robot, Long group, Long qq, int time) {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("logonqq", robot);
        param.put("group", group);
        param.put("toqq", qq);
        param.put("time", time);
        ret = lib.POST(禁言群成员, param);
        return ret;
    }

    @Override
    public String 退群(Long robot, Long group, boolean dismiss) {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("logonqq", robot);
        param.put("group", group);
        param.put("dismiss", String.valueOf(dismiss));
        ret = lib.POST(退群, param);
        return ret;
    }

    @Override
    public String 上传群头像(Long robot, Long group, String type, String pic) {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("logonqq", robot);
        param.put("group", group);
        param.put("type", type);
        param.put("pic", pic);
        ret = lib.POST(上传群头像, param);
        return ret;
    }

    @Override
    public String 全员禁言(Long robot, Long group, boolean ismute) {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("logonqq", robot);
        param.put("group", group);
        param.put("ismute", String.valueOf(ismute));
        ret = lib.POST(全员禁言, param);
        return ret;
    }

    @Override
    public String 设置群权限(Long robot, Long group, String type, boolean isallow) {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("logonqq", robot);
        param.put("group", group);
        param.put("type", type);
        param.put("isallow", String.valueOf(isallow));
        ret = lib.POST(设置群权限, param);
        return ret;
    }

    @Override
    public String 设置群权限2(Long robot, Long group, String type, int value) {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("logonqq", robot);
        param.put("group", group);
        param.put("type", type);
        param.put("value", value);
        ret = lib.POST(设置群权限, param);
        return ret;
    }

    @Override
    public String 撤回消息(Long robot, Long qq, String type, Long random, Long req, Long time) {
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
                return "type参数错误";
        }
        param.put("random", random);
        param.put("req", req);
        ret = lib.POST(撤回消息, param);
        return ret;
    }

    @Override
    public String 设置位置共享(Long robot, Long group, String longs, String lat, boolean enable) {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("logonqq", robot);
        param.put("group", group);
        param.put("long", longs);
        param.put("lat", lat);
        param.put("enable", String.valueOf(enable));
        ret = lib.POST(设置位置共享, param);
        return ret;
    }

    @Override
    public String 上报当前位置(Long robot, Long group, String longs, String lat) {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("logonqq", robot);
        param.put("group", group);
        param.put("long", longs);
        param.put("lat", lat);
        ret = lib.POST(上报当前位置, param);
        return ret;
    }

    @Override
    public String 取禁言时长(Long robot, Long group) {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("logonqq", robot);
        param.put("group", group);
        ret = lib.POST(取禁言时长, param);
        return ret;
    }

    @Override
    public String 处理群验证事件(Long robot, Long group, Long qq, Long seq, int optype, int eventtype, String reason,
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
        ret = lib.POST(处理群验证事件, param);
        return ret;
    }
}
