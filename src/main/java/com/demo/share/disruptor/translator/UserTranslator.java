package com.demo.share.disruptor.translator;

import com.demo.share.disruptor.event.UserEvent;
import com.lmax.disruptor.EventTranslatorOneArg;

public class UserTranslator implements EventTranslatorOneArg<UserEvent, String > {
    @Override
    public void translateTo(UserEvent event, long sequence, String name) {
        event.setName(name);
    }
}
