/*
 * @Author: hujiayucc
 * @Date: 2022-08-10 10:51:37
 * @Description: 文件描述
 */
package com.hujiayucc.xlz.Utils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;
import java.util.Map.Entry;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import com.alibaba.fastjson.JSONObject;
import com.hujiayucc.xlz.Data.Config;

@Service("lib")
@Async("xlz")
public class Lib {

    private static String host = Config.getHost();
    private static String username = Config.getUsername();
    private static String password = Config.getPassword();
    private static String ua = Config.getUa();
    private static Logger logger = LoggerFactory.getLogger(host);

    /**
     * 获取Cookie
     * 
     * @param url  请求路径
     * @param time 时间截
     * @return Cookie信息
     */
    @Async("xlz")
    public String getCookie(String url, String time) {
        String cookie = "user=" + username + ";timestamp=" + time + ";signature=" + getSignature(url, time);
        logger.debug("\u001b[38;5;10mCookie:\u001b[38;5;14m" + cookie);
        return cookie;
    }

    /**
     * 获取Signature
     * 
     * @param url  访问路径
     * @param time 时间截
     * @return Signature
     */
    @Async("xlz")
    private String getSignature(String url, String time) {
        // md5(用户名+请求路径+md5(密码)+timestamp)
        String signature = md5(username + url + md5(password) + time);
        logger.debug("\u001b[38;5;10mSignature:\u001b[38;5;14m" + signature);
        return signature;
    }

    /**
     * md5加密
     * 
     * @param text 需要加密的文本
     * @return md5加密文本
     */
    @Async("xlz")
    private String md5(String text) {
        return DigestUtils.md5DigestAsHex(text.getBytes());
    }

    /**
     * POST方法
     * 
     * @param url  访问路径
     * @param post POST参数
     * @return POST返回数据
     */
    @Async("xlz")
    public void POST(String url, Map<String, Object> param) {
        String time = Long.toString(System.currentTimeMillis() / 1000L);
        CloseableHttpClient httpClient = HttpClients.createDefault();
        String entityStr = null;
        CloseableHttpResponse response = null;
        try {
            HttpPost post = new HttpPost(host + url);
            // 添加头部信息
            post.addHeader("H-Auth-User", username);
            post.addHeader("H-Auth-Signature", getSignature(url, time));
            post.addHeader("H-Auth-Timestamp", time);
            post.addHeader(HttpHeaders.USER_AGENT, ua);
            post.addHeader("Cookie", getCookie(url, time));
            HttpEntity entity = new StringEntity(toQueryString(param), "UTF-8");
            post.setEntity(entity);
            response = httpClient.execute(post);
            // 获得响应的实体对象
            HttpEntity httpEntity = response.getEntity();
            // 使用Apache提供的工具类进行转换成字符串
            entityStr = EntityUtils.toString(httpEntity, "UTF-8");
        } catch (ClientProtocolException e) {
            logger.error("\u001b[38;5;8mHttp协议出现问题");
            e.printStackTrace();
        } catch (ParseException e) {
            logger.error("\u001b[38;5;8m解析错误");
            e.printStackTrace();
        } catch (IOException e) {
            logger.error("\u001b[38;5;8mIO异常");
            e.printStackTrace();
        }
        JSONObject jsonObject = JSONObject.parseObject(entityStr);
        logger.info("\u001b[38;5;51m" + jsonObject.getString("ret"));
    }

    /**
     * POST参数数组转化
     * 
     * @param param POST参数数组
     * @return POST参数
     */
    @Async("xlz")
    private String toQueryString(Map<String, Object> param) {
        StringBuffer queryString = new StringBuffer();
        for (Entry<?, ?> pair : param.entrySet()) {
            try {
                queryString.append(URLEncoder.encode(pair.getKey().toString(), "UTF-8") + "=");
            } catch (UnsupportedEncodingException e1) {
                e1.printStackTrace();
            }
            try {
                queryString.append(
                        URLEncoder.encode((pair.getValue() == null) ? "null" : pair.getValue().toString(), "UTF-8") + "&");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        if (queryString.length() > 0) {
            queryString.deleteCharAt(queryString.length() - 1);
        }
        logger.debug("\u001b[38;5;10mPOST:\u001b[38;5;14m" + queryString);
        return queryString.toString();
    }

    /**
     * 取右边文本
     * 
     * @param str     原文本
     * @param leftStr 左边文本
     * @return 右边文本
     */
    @Async("xlz")
    public static String getRightstr(String str, String leftStr) {
        String rightStr = str.substring(str.indexOf(leftStr) + leftStr.length());
        logger.debug("\u001b[38;5;10mRightStr:\u001b[38;5;14m" + rightStr);
        return rightStr;
    }

    /**
     * 取左边文本
     * 
     * @param str      原文本
     * @param rightStr 右边文本
     * @return 左边文本
     */
    @Async("xlz")
    public static String getLeftstr(String str, String rightStr) {
        String leftStr = str.substring(0, str.indexOf(rightStr));
        logger.debug("\u001b[38;5;10mLeftStr:\u001b[38;5;14m" + leftStr);
        return leftStr;
    }

    /**
     * 取中间文本
     * 
     * @param str      原文本
     * @param leftStr  左边文本
     * @param rightStr 右边文本
     * @return 中间文本
     */
    @Async("xlz")
    public static String getSubstr(String str, String leftStr, String rightStr) {
        String temp = getLeftstr(str, rightStr);
        temp = getRightstr(temp, leftStr);
        logger.debug("\u001b[38;5;10mSubStr:\u001b[38;5;14m" + temp);
        return temp;
    }
}
