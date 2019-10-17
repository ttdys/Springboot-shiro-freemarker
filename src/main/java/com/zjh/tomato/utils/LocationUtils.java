package com.zjh.tomato.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * 根据ip地址获取大概的地区
 *
 * @author zjh
 */
public class LocationUtils {
    public static String getAddr(String host) {
        try {
            String urlString = "http://ip.taobao.com/service/getIpInfo.php?ip=" + host;
            //http://int.dpool.sina.com.cn/iplookup/iplookup.php?format=json&ip= 新浪备用
            // yavNez4coIeheKOavW49tFDNveXZc347 miyao
            String key = "yavNez4coIeheKOavW49tFDNveXZc347";
            //http://api.map.baidu.com/location/ip
            String urlBaiduString = "http://api.map.baidu.com/location/ip?ak=" + key + "&ip=" + host;


            // 1. 得到访问地址的URL
            URL url = new URL(urlBaiduString);
            // 2. 得到网络访问对象java.net.HttpURLConnection
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            /* 3. 设置请求参数（过期时间，输入、输出流、访问方式），以流的形式进行连接 */
            // 设置是否向HttpURLConnection输出
            connection.setDoOutput(false);
            // 设置是否从httpUrlConnection读入
            connection.setDoInput(true);
            // 设置请求方式
            connection.setRequestMethod("GET");
            // 设置是否使用缓存
            connection.setUseCaches(true);
            // 设置此 HttpURLConnection 实例是否应该自动执行 HTTP 重定向
            connection.setInstanceFollowRedirects(true);
            // 设置超时时间
            connection.setConnectTimeout(3000);
            // 连接
            connection.connect();
            // 4. 得到响应状态码的返回值 responseCode
            int code = connection.getResponseCode();
            // 5. 如果返回值正常，数据在网络中是以流的形式得到服务端返回的数据
            String msg = "";
            // 正常响应
            if (code == 200) {
                // 从流中读取响应信息
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(connection.getInputStream()));
                String line = null;
                // 循环从流中读取
                while ((line = reader.readLine()) != null) {
                    msg += line + "\n";
                }
                reader.close(); // 关闭流
            }
            // 6. 断开连接，释放资源
            connection.disconnect();

            if (StringUtils.isEmpty(msg)) {
                return "未知";
            }
            // 显示响应结果
            JSONObject jsonObject = JSONObject.parseObject(msg);
            JSONObject content = jsonObject.getJSONObject("content");
            String country = content.getString("address");
            System.out.println("country = " + country);
            return country;
        } catch (Exception e) {
            System.out.println("未知");
            return "未知";
        }
    }

    public static void main(String[] args) {
        LocationUtils.getAddr("115.60.93.31");
        LocationUtils.getAddr("0:0:0:0:0:0:0:1");

    }

}
