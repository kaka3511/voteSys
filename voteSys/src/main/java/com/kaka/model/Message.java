package com.kaka.model;

import java.util.Date;

public class Message {
    private Integer id;

    private Integer userid;

    private String content;

    private Date date;

    public Message(String content) {
        this.content = content;
        this.date = new Date();
    }

    public Message(Integer id, Integer userid, String content, Date date) {
        this.id = id;
        this.userid = userid;
        this.content = content;
        this.date = date;
    }

    public Message() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}