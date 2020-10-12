package com.furseal.restaurant.common.config;

import com.ulisesbocchio.jasyptspringboot.EncryptablePropertyDetector;
import org.springframework.context.annotation.Configuration;

/**
 * @author hejishan
 */
@Configuration
public class CustomEncryptablePropertyDetector implements EncryptablePropertyDetector {
    public static final String ENCODED_PASSWORD_START = "RBZ(";
    public static final String ENCODED_PASSWORD_END = ")";

    @Override
    public boolean isEncrypted(String s) {
        if (null != s) {
            return s.startsWith(ENCODED_PASSWORD_START) && s.endsWith(ENCODED_PASSWORD_END);
        }
        return false;
    }

    @Override
    public String unwrapEncryptedValue(String s) {
        return s.substring(ENCODED_PASSWORD_START.length(), s.length() - ENCODED_PASSWORD_END.length());
    }
}
