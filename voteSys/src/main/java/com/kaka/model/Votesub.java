package com.kaka.model;

public class Votesub {
    private Integer id;

    private Integer voteid;

    private String content;

    private Integer quantity;

    public Votesub(Integer voteid, String content) {
        this.voteid = voteid;
        this.content = content;
        this.quantity = 0;
    }

    public Votesub(Integer id, Integer voteid, String content, Integer quantity) {
        this.id = id;
        this.voteid = voteid;
        this.content = content;
        this.quantity = quantity;
    }

    public Votesub() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getVoteid() {
        return voteid;
    }

    public void setVoteid(Integer voteid) {
        this.voteid = voteid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}