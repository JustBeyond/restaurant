package com.furseal.restaurant.common.enums;

public enum AcctStatusEnum {
    NARMAL("0"),
    LOCK("1"),
    EXPIRE("2");
    private String status;

    AcctStatusEnum(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
