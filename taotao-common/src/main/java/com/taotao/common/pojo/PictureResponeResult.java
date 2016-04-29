package com.taotao.common.pojo;

/**
 * Created by 20150610 on 2016/4/29.
 */
public class PictureResponeResult {
    private int error;
    private String url;
    private String message;
    public int getError() {
        return error;
    }
    public void setError(int error) {
        this.error = error;
    }
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
}
