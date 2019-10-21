package com.demo.share.disruptor.handler;

import com.demo.share.disruptor.event.UserEvent;
import com.lmax.disruptor.EventHandler;


public class LogintimesHandler implements EventHandler<UserEvent> {

    @Override
    public void onEvent(UserEvent event, long sequence, boolean endOfBatch) throws Exception {
        System.err.println("LogintimesHandler 计算登录次数 " + event.getName() );
    }
}
