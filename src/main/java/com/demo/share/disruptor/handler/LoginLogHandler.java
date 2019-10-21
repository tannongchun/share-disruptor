package com.demo.share.disruptor.handler;

import com.demo.share.disruptor.event.UserEvent;
import com.lmax.disruptor.EventHandler;


public class LoginLogHandler implements EventHandler<UserEvent> {

    @Override
    public void onEvent(UserEvent event, long sequence, boolean endOfBatch) throws Exception {
        System.err.println("LoginLogHandler 登录日志 " + event.getName() );
    }
}
