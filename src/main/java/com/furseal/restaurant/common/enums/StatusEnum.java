package com.furseal.restaurant.common.enums;

/**
 * @author hejishan
 */

public enum StatusEnum {
    /**
     * 启用
     */
    ENABLE("0"),
    /**
     * 停用
     */
    DISABLE("1");
    private String status;

    StatusEnum(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
