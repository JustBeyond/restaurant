package com.furseal.restaurant.common.enums;

/**
 * @author hejishan
 */

public enum AcctOnlineStatusEnum {
    ON_LINE("1"),
    OFF_LINE("2");
    private String status;

    AcctOnlineStatusEnum(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
