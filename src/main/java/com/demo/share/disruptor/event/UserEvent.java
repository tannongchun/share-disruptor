package com.demo.share.disruptor.event;

public class UserEvent {
    private String name;


    public UserEvent() {
    }

    public UserEvent(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
