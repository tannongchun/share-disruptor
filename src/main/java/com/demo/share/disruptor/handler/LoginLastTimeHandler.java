package com.demo.share.disruptor.handler;

import com.demo.share.disruptor.event.UserEvent;
import com.lmax.disruptor.EventHandler;
import com.lmax.disruptor.WorkHandler;

public class LoginLastTimeHandler implements EventHandler<UserEvent> {
    @Override
    public void onEvent(UserEvent event, long sequence, boolean endOfBatch) throws Exception {
        System.err.println("LoginLastTimeHandler 记录登录最后的时间 " + event.getName() );
    }
}
