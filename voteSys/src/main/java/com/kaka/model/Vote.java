package com.kaka.model;

import java.util.Date;

public class Vote {
    private Integer id;

    private String title;

    private Date date;

    public Vote(String title) {
        this.title = title;
        this.date = new Date();
    }

    public Vote(Integer id, String title, Date date) {
        this.id = id;
        this.title = title;
        this.date = date;
    }

    public Vote() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}