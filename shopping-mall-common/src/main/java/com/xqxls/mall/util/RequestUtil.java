package com.xqxls.mall.util;

import com.xqxls.mall.constant.Constant;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author xqxls
 * @create 2023-06-15 10:17
 * @Description 请求工具类
 */
public class RequestUtil {

    /**
     * 获取请求真实IP地址
     */
    public static String getRequestIp(HttpServletRequest request) {
        //通过HTTP代理服务器转发时添加
        String ipAddress = request.getHeader("x-forwarded-for");
        if (ipAddress == null || ipAddress.length() == 0 || Constant.UNKNOWN.equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getHeader("Proxy-Client-IP");
        }
        if (ipAddress == null || ipAddress.length() == 0 || Constant.UNKNOWN.equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ipAddress == null || ipAddress.length() == 0 || Constant.UNKNOWN.equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getRemoteAddr();
            // 从本地访问时根据网卡取本机配置的IP
            if (Constant.LOCALHOST.equals(ipAddress) || Constant.NETWORK.equals(ipAddress)) {
                InetAddress inetAddress = null;
                try {
                    inetAddress = InetAddress.getLocalHost();
                } catch (UnknownHostException e) {
                    e.printStackTrace();
                }
                if(inetAddress!=null){
                    ipAddress = inetAddress.getHostAddress();
                }
            }
        }
        // 通过多个代理转发的情况，第一个IP为客户端真实IP，多个IP会按照','分割
        if (ipAddress != null && ipAddress.length() > Constant.IP_LENGTH) {
            if (ipAddress.indexOf(Constant.COMMA) > 0) {
                ipAddress = ipAddress.substring(0, ipAddress.indexOf(Constant.COMMA));
            }
        }
        return ipAddress;
    }

}
