package com.l3azh.management.SpendingManagement.Dtos;

public class BaseResponseDto<T> {

    private int code;
    private boolean flag;
    private T data;

    public BaseResponseDto() {
    }

    public BaseResponseDto(int code, boolean flag, T data) {
        this.code = code;
        this.flag = flag;
        this.data = data;
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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
