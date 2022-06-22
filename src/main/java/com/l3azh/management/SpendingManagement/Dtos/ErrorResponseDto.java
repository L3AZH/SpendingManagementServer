package com.l3azh.management.SpendingManagement.Dtos;

import com.l3azh.management.SpendingManagement.Utils.AppUtils;



public class ErrorResponseDto {
    private int code;
    private boolean flag;
    private String errorMessage;
    private String timeStamp;

    public ErrorResponseDto(int code, boolean flag, String errorMessage) {
        this.code = code;
        this.flag = flag;
        this.errorMessage = errorMessage;
        this.timeStamp = AppUtils.getCurrentDateString();
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }
}
