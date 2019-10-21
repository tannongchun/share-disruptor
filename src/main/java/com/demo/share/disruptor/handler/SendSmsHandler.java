package com.demo.share.disruptor.handler;

import com.demo.share.disruptor.event.UserEvent;
import com.lmax.disruptor.EventHandler;

public class SendSmsHandler implements EventHandler<UserEvent> {

    @Override
    public void onEvent(UserEvent event, long sequence, boolean endOfBatch) throws Exception {
        System.err.println("SendSmsHandler 检测异常发送短信 " + event.getName() );
    }
}