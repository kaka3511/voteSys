package com.kaka.model;

public class MessageAndUser extends Message{
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
