package com.demo.share.disruptor.eventfactory;

import com.demo.share.disruptor.event.UserEvent;
import com.lmax.disruptor.EventFactory;

public class UserEventFactory implements EventFactory {
    @Override
    public Object newInstance() {
        return new UserEvent();
    }
}
