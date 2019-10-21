package com.demo.share.disruptor.handler;

import com.demo.share.disruptor.event.UserEvent;
import com.lmax.disruptor.EventHandler;

public class CheckExcetpionHandler implements EventHandler<UserEvent> {

    @Override
    public void onEvent(UserEvent event, long sequence, boolean endOfBatch) throws Exception {
        System.err.println("CheckExcetpionHandler 检测登录是否有异常 " + event.getName() );
    }
}