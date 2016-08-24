package com.wurensen.freejuhe.dribbble.model;

/**
 * Created by WuRS on 2016/8/25.
 */
public class BaseBean {
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "BaseBean{" +
                "message='" + message + '\'' +
                '}';
    }
}
