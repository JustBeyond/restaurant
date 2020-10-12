package com.furseal.restaurant.common.config;

import com.furseal.restaurant.common.utils.AesEncryptUtil;
import com.ulisesbocchio.jasyptspringboot.EncryptablePropertyResolver;
import org.springframework.context.annotation.Configuration;

/**
 * @author hejishan
 */
@Configuration
public class CustomEncryptablePropertyResolver implements EncryptablePropertyResolver {
    @Override
    public String resolvePropertyValue(String s) {
        if (null != s && s.startsWith(CustomEncryptablePropertyDetector.ENCODED_PASSWORD_START) && s.endsWith(CustomEncryptablePropertyDetector.ENCODED_PASSWORD_END)) {
            return AesEncryptUtil.decryptWithHEX(s.substring(CustomEncryptablePropertyDetector.ENCODED_PASSWORD_START.length(), s.length() - CustomEncryptablePropertyDetector.ENCODED_PASSWORD_END.length()));
        }
        return s;
    }
}
