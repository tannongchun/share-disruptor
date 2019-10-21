package com.demo.share.disruptor;

import com.demo.share.disruptor.event.UserEvent;
import com.demo.share.disruptor.eventfactory.UserEventFactory;
import com.demo.share.disruptor.handler.*;
import com.demo.share.disruptor.translator.UserTranslator;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import com.lmax.disruptor.TimeoutException;
import com.lmax.disruptor.YieldingWaitStrategy;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.EventHandlerGroup;
import com.lmax.disruptor.dsl.ProducerType;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

public class DisruptorApp {
    public static void main(String[] args) {
        int ringBufferSize = 1024;
         Disruptor<UserEvent> disruptor ;
        ThreadFactory threadFactory = new ThreadFactoryBuilder().setNameFormat("登录过程说明 -%s").build();
         //1.初始化
          disruptor  = new Disruptor<UserEvent>(
                  new UserEventFactory(),
                  ringBufferSize,
                  threadFactory,
                  ProducerType.SINGLE,
                  new YieldingWaitStrategy());
        // 2.定义操作流程
        // ============ 登录次数
         EventHandlerGroup<UserEvent>  eventHandlerGroup= disruptor.handleEventsWith( new LogintimesHandler());
        //============ 登录时间
         eventHandlerGroup.handleEventsWith(new LoginLastTimeHandler());
        // ============ 检测异常 - 发送邮件
         eventHandlerGroup.handleEventsWith(new CheckExcetpionHandler()).then(new SendSmsHandler());
        // ============ 记录日志
         eventHandlerGroup.handleEventsWith(new LoginLogHandler());
         // 3.启动
        disruptor.start();
        // 4.提交数据
        disruptor.publishEvent(new UserTranslator(), "Mysteel");
        //  5.关闭
        try {
            disruptor.shutdown(2, TimeUnit.MINUTES);
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
    }
}
