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
import com.hujiayucc.xlz.Data.Config;
import com.hujiayucc.xlz.Utils.Color;
import com.hujiayucc.xlz.Utils.Plugin;
import com.hujiayucc.xlz.Utils.Type;

@Controller
public class Request implements Type, Color {

    @Autowired
    private Plugin plugins;

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
            return new ResponseEntity<String>(JSON.toJSONString(data), HttpStatus.BAD_GATEWAY);
        }
    }

    @PostMapping(value = "/msg", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    private ResponseEntity<String> msg(@RequestHeader("Password") String CT, @RequestBody String param) {
        if (CT.equals(Config.getPassword())) {
            plugins.run(param);
            return new ResponseEntity<String>("Success", HttpStatus.OK);
        } else {
            HashMap<String, Object> data = new HashMap<>();
            data.put("code", 502);
            data.put("text", "password error");
            return new ResponseEntity<String>(JSON.toJSONString(data), HttpStatus.BAD_GATEWAY);
        }
    }
}
