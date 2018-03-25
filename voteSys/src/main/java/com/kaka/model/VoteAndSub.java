package com.kaka.model;

import java.util.List;

public class VoteAndSub extends Vote{
    private List<Votesub> subs;

    public List<Votesub> getSubs() {
        return subs;
    }

    public void setSubs(List<Votesub> subs) {
        this.subs = subs;
    }
}
