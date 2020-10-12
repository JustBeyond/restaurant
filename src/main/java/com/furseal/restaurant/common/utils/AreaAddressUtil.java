package com.furseal.restaurant.common.utils;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.net.URLDecoder;

@Slf4j
public class AreaAddressUtil {
    private static final String IP_ADDRESS_REQUEST_URL_TAOBAO = "http://ip.taobao.com/service/getIpInfo.php?ip=";
    private static final String IP_ADDRESS_REQUEST_URL_360 = "http://ip.360.cn/IPQuery/ipquery?ip=";
    private static final String IP_ADDRESS_REQUEST_URL_PCONLINE = "http://whois.pconline.com.cn/ipJson.jsp?json=true&level=3&ip=";
    private static final String DATA_SEPARATOR = "|";
    private static final String DATA_RESULT_SUCCESS = "0";
    private static final String DATA_RESULT_CODE = "code";
    private static final String DATA_RESULT_DATA = "data";
    private static final String DATA_RESULT_COUNTRY = "country";
    private static final String DATA_RESULT_REGION = "region";
    private static final String DATA_RESULT_CITY = "city";
    private static final String DATA_RESULT_PRO = "pro";

    private static final String DATA_RESULT_ERRNO = "errno";

    public static String getAreaAddress(String ip) {
        String ipAddress = "";
        try {
            //通过淘宝API获取IP地址区域
            ipAddress = getIpAddressForPconline(ip);
            if (StringUtils.isEmpty(ipAddress)) {
                ipAddress = getIpAddressFor360(ip);
            }
            if (StringUtils.isEmpty(ipAddress)) {
                ipAddress = getIpAddressTaoBao(ip);
            }
            if (StringUtils.isEmpty(ipAddress)) {
                ipAddress = "未知位置";
            }
        } catch (Exception e) {
            log.warn("get ip address error!!!!");
            ipAddress = "未知位置";
        }
        return ipAddress;
    }

    public static String getIpAddressForPconline(String ip) {
        String ipAddress = "";
        String result = HttpClientUtil.doPost(IP_ADDRESS_REQUEST_URL_PCONLINE + ip, null, null);
        System.out.println(result);
        if (StringUtils.isNotEmpty(result)) {
            JSONObject jsonObject = JSONObject.parseObject(result);
            if (jsonObject != null) {
                ipAddress = "中国" + DATA_SEPARATOR;
                String pro = jsonObject.getString(DATA_RESULT_PRO);
                if (StringUtils.isNotEmpty(pro)) {
                    ipAddress += pro + DATA_SEPARATOR;
                }
                String city = jsonObject.getString(DATA_RESULT_CITY);
                if (StringUtils.isNotEmpty(city)) {
                    ipAddress += city + DATA_SEPARATOR;
                }
            }
            if (StringUtils.isNotEmpty(ipAddress) && ipAddress.endsWith(DATA_SEPARATOR)) {
                ipAddress = ipAddress.substring(0, ipAddress.length() - 1);
            }
        }
        return ipAddress;
    }

    public static String getIpAddressFor360(String ip) {
        String ipAddress = "";
        String result = HttpClientUtil.doPost(IP_ADDRESS_REQUEST_URL_360 + ip, null, null);
        System.out.println(result);
        if (StringUtils.isNotEmpty(result)) {
            JSONObject jsonObject = JSONObject.parseObject(result);
            if (jsonObject != null && DATA_RESULT_SUCCESS.equals(jsonObject.getString(DATA_RESULT_ERRNO))) {
                String data = null;
                try {
                    data = URLDecoder.decode(jsonObject.getString(DATA_RESULT_DATA), "utf-8");
                    String[] split = data.split("\\t");
                    ipAddress = "中国|" + split[0] + DATA_SEPARATOR + split[1].replace("\\/", DATA_SEPARATOR);
                } catch (Exception e) {
                    log.warn("360 get ip address error! data = " + data);
                }
            }
        }
        return ipAddress;
    }


    public static String getIpAddressTaoBao(String ip) {
        String ipAddress = "";
        try {
            String result = HttpClientUtil.doPost(IP_ADDRESS_REQUEST_URL_TAOBAO + ip, null, null);
            log.info("taobao get ip address result = " + result);
            if (StringUtils.isNotEmpty(result)) {
                JSONObject jsonObject = JSONObject.parseObject(result);
                String code = jsonObject.getString(DATA_RESULT_CODE);
                if (DATA_RESULT_SUCCESS.equals(code)) {
                    String data = jsonObject.getString(DATA_RESULT_DATA);
                    if (StringUtils.isNotEmpty(data)) {
                        JSONObject dataJson = JSONObject.parseObject(data);
                        String country = dataJson.getString(DATA_RESULT_COUNTRY);
                        if (StringUtils.isNotEmpty(country)) {
                            ipAddress += country + DATA_SEPARATOR;
                        }
                        String region = dataJson.getString(DATA_RESULT_REGION);
                        if (StringUtils.isNotEmpty(region)) {
                            ipAddress += region + DATA_SEPARATOR;
                        }
                        String city = dataJson.getString(DATA_RESULT_CITY);
                        if (StringUtils.isNotEmpty(city)) {
                            ipAddress += city + DATA_SEPARATOR;
                        }
                    }
                }
            }
            if (StringUtils.isNotEmpty(ipAddress) && ipAddress.endsWith(DATA_SEPARATOR)) {
                ipAddress = ipAddress.substring(0, ipAddress.length() - 1);
            }
        } catch (Exception e) {
            log.warn("taobao get ip address error !!! error = " + e.getMessage());
        }
        return ipAddress;
    }

}
