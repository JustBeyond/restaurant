package com.furseal.restaurant.common.utils;

import java.util.UUID;

/**
 * String工具类
 *
 * @author hejishan
 */
public class StringUtil {

    /**
     * 将字符串中的大写转为小写
     *
     * @param target 需要转换的字符串
     * @return 转换后的结果
     */
    public static String toLowerCase(String target) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < target.length(); i++) {
            //索引指定位置的字符
            char c = target.charAt(i);
            //判断是否为小写字母
            if (Character.isUpperCase(c)) {
                sb.append(Character.toLowerCase(c));
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static String getRandomUUID() {
        return UUID.randomUUID().toString().replaceAll("-", "").toLowerCase();
    }
}
