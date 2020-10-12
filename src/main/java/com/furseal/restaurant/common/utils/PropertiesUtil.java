package com.furseal.restaurant.common.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author hejishan
 */
@Component
@Slf4j
public class PropertiesUtil {
    //@Autowired
    //private RbzSystemConfigurationService rs;
    //private static RbzSystemConfigurationService rbzSystemConfigurationService;

    //@PostConstruct
    //public void init() {
        //rbzSystemConfigurationService = this.rs;
    //}

    public static String getValue(String key) {
        try {
            //return rbzSystemConfigurationService.getValue(key);
            return null;
        } catch (Exception e) {
            log.error("############properties [" + key + "]获取失败！！");
        }
        return null;
    }
}
