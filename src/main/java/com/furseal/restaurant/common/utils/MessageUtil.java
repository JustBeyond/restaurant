package com.furseal.restaurant.common.utils;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;

public class MessageUtil {
    public static String message(String code, Object... args) {
        MessageSource messageSource = SpringUtil.getBean(MessageSource.class);
        return messageSource.getMessage(code, args, LocaleContextHolder.getLocale());
    }
}
