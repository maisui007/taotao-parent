package com.taotao.common.pojo;

/**
 * Created by 20150610 on 2016/4/27.
 */
public class EasyUITreeNode {
    private long id;
    private String text;
    private String state;//open;closed

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
