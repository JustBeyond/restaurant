package com.furseal.restaurant.common.utils;

import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class IpUtil {
    private static final String REQUEST_HEADER_X_FORWARDED_FOR = "x-forwarded-for";
    private static final String REQUEST_HEADER_PROXY_CLIENT_IP = "Proxy-Client-IP";
    private static final String REQUEST_HEADER_WL_PROXY_CLIENT_IP = "WL-Proxy-Client-IP";
    private static final String REQUEST_HEADER_HTTP_CLIENT_IP = "HTTP_CLIENT_IP";
    private static final String REQUEST_HEADER_HTTP_X_FORWARDED_FOR = "HTTP_X_FORWARDED_FOR";
    private static final String REQUEST_IP_UNKNOWN = "unknown";
    private static final String LOCAL_HOST_IP_V4 = "127.0.0.1";
    private static final String LOCAL_HOST_IP_V6 = "0:0:0:0:0:0:0:1";

    public static String getLocalIp(HttpServletRequest request) {
        String ip = request.getHeader(REQUEST_HEADER_X_FORWARDED_FOR);
        if (StringUtils.isEmpty(ip) || REQUEST_IP_UNKNOWN.equalsIgnoreCase(ip)) {
            ip = request.getHeader(REQUEST_HEADER_PROXY_CLIENT_IP);
        }
        if (StringUtils.isEmpty(ip) || REQUEST_IP_UNKNOWN.equalsIgnoreCase(ip)) {
            ip = request.getHeader(REQUEST_HEADER_WL_PROXY_CLIENT_IP);
        }
        if (StringUtils.isEmpty(ip) || REQUEST_IP_UNKNOWN.equalsIgnoreCase(ip)) {
            ip = request.getHeader(REQUEST_HEADER_HTTP_CLIENT_IP);
        }
        if (StringUtils.isEmpty(ip) || REQUEST_IP_UNKNOWN.equalsIgnoreCase(ip)) {
            ip = request.getHeader(REQUEST_HEADER_HTTP_X_FORWARDED_FOR);
        }
        if (StringUtils.isEmpty(ip) || REQUEST_IP_UNKNOWN.equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
            if (LOCAL_HOST_IP_V4.equals(ip) || LOCAL_HOST_IP_V6.equals(ip)) {
                try {
                    InetAddress inet = InetAddress.getLocalHost();
                    ip = inet.getHostAddress();
                } catch (UnknownHostException e) {
                    e.printStackTrace();
                }
            }
        }
        return ip;
    }
}
