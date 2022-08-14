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
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import com.hujiayucc.xlz.Data.Config;

@Service
public class Lib {

    private static String host = Config.getHost();
    private static String username = Config.getUsername();
    private static String password = Config.getPassword();
    private static String ua = Config.getUa();

    /**
     * 获取Cookie
     * 
     * @param url  请求路径
     * @param time 时间截
     * @return Cookie信息
     */
    public static String getCookie(String url, String time) {
        String cookie = "user=" + username + ";timestamp=" + time + ";signature=" + getSignature(url, time);
        return cookie;
    }

    /**
     * 获取Signature
     * 
     * @param url  访问路径
     * @param time 时间截
     * @return Signature
     */
    private static String getSignature(String url, String time) {
        // md5(用户名+请求路径+md5(密码)+timestamp)
        String signature = md5(username + url + md5(password) + time);
        return signature;
    }

    /**
     * md5加密
     * 
     * @param text 需要加密的文本
     * @return md5加密文本
     */
    private static String md5(String text) {
        return DigestUtils.md5DigestAsHex(text.getBytes());
    }

    /**
     * POST方法
     * 
     * @param url  访问路径
     * @param post POST参数
     * @return POST返回数据
     */

    public String POST(String url, Map<String, Object> param) {
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
            HttpEntity entity = new StringEntity(toQueryString(param), "UTF-8");
            post.setEntity(entity);
            response = httpClient.execute(post);
            // 获得响应的实体对象
            HttpEntity httpEntity = response.getEntity();
            // 使用Apache提供的工具类进行转换成字符串
            entityStr = EntityUtils.toString(httpEntity, "UTF-8");
        } catch (ClientProtocolException e) {
            System.err.println("Http协议出现问题");
            e.printStackTrace();
        } catch (ParseException e) {
            System.err.println("解析错误");
            e.printStackTrace();
        } catch (IOException e) {
            System.err.println("IO异常");
            e.printStackTrace();
        }
        return entityStr;
    }

    /**
     * POST参数数组转化
     * 
     * @param param POST参数数组
     * @return POST参数
     */
    private static String toQueryString(Map<String, Object> param) {
        StringBuffer queryString = new StringBuffer();
        for (Entry<?, ?> pair : param.entrySet()) {
            try {
                queryString.append(URLEncoder.encode(pair.getKey().toString(), "UTF-8") + "=");
            } catch (UnsupportedEncodingException e1) {
                e1.printStackTrace();
            }
            try {
                queryString.append(
                        URLEncoder.encode((pair.getValue() == null) ? "null" : pair.getValue().toString(), "UTF-8")
                                + "&");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        if (queryString.length() > 0) {
            queryString.deleteCharAt(queryString.length() - 1);
        }
        return queryString.toString();
    }

    /**
     * 取右边文本
     * 
     * @param str     原文本
     * @param leftStr 左边文本
     * @return 右边文本
     */
    public static String getRightstr(String str, String leftStr) {
        String rightStr = str.substring(str.indexOf(leftStr) + leftStr.length());
        return rightStr;
    }

    /**
     * 取左边文本
     * 
     * @param str      原文本
     * @param rightStr 右边文本
     * @return 左边文本
     */
    public static String getLeftstr(String str, String rightStr) {
        String leftStr = str.substring(0, str.indexOf(rightStr));
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
    public static String getSubstr(String str, String leftStr, String rightStr) {
        String temp = getLeftstr(str, rightStr);
        temp = getRightstr(temp, leftStr);
        return temp;
    }
}
