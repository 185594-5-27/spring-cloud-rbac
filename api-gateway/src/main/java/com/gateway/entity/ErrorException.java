package com.gateway.entity;

/*
* 类描述：错误信息实体
* @auther linzf
* @create 2018/1/2 0002 
*/
public class ErrorException {

    // 报错的类
    private String exceptionClass;
    // 错误的原因
    private String exceptionMessage;

    public String getExceptionClass() {
        return exceptionClass;
    }

    public void setExceptionClass(String exceptionClass) {
        this.exceptionClass = exceptionClass;
    }

    public String getExceptionMessage() {
        return exceptionMessage;
    }

    public void setExceptionMessage(String exceptionMessage) {
        this.exceptionMessage = exceptionMessage;
    }
}
