package com.furseal.restaurant.common.constant;

/**
 * 常量类
 *
 * @author hejishan
 */
public class Constants {
    /**
     * http请求常量类
     */
    public static class Http {
        public static final String HTTP_METHOD_POST = "POST";
        public static final String HTTP_METHOD_GET = "GET";
    }

    /**
     * session常量类
     */
    public static class Session {
        public static final String AREA_ADDRESS = "areaAddress";
        public static final String ADMIN_ACCT_INFO = "adminAcct";
        public static final String ACCT_PERMISSION = "permission";
        public static final String IMG_CODE = "imgCode";
        public static final String IMG_CODE_EFFFFECT_TIME = "codeEffectTime";
        public static final String IMG_CODE_DATA = "data";
        public static final String ONLINE_INFO_ID = "onlineInfoId";
    }

    /**
     * 配置项常量类
     */
    public static class Properties {
        public static final String VERIFICATION_CODE_EXPIRE_TIME = "VERIFICATION_CODE_EXPIRE_TIME";
        public static final String FILE_UPLOAD_URL = "FILE_UPLOAD_URL";
    }

    public static final String USER_AGENT = "User-Agent";
    public static final String FILE_UPLOAD_DEFAULT_URL = "/upload";
}
