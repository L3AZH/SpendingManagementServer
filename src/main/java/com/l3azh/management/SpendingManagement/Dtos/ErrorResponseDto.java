package com.l3azh.management.SpendingManagement.Dtos;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ErrorResponseDto {
    private int code;
    private boolean flag;
    private String errorMessage;
    private String timeStamp;

    public ErrorResponseDto(int code, boolean flag, String errorMessage) {
        this.code = code;
        this.flag = flag;
        this.errorMessage = errorMessage;
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        this.timeStamp = df.format(new Date());
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
