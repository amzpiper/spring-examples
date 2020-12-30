package com.guoyuhang.alerts;

import com.google.common.base.Splitter;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AlertServiceImpl2{
    private RabbitTemplate rabbitTemplate;

    @Autowired
    public AlertServiceImpl2(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    /**
     * RabbitMQ发送消息
     * @param splitter
     */
    public void sendSpittleAlert(Splitter splitter){
        rabbitTemplate.convertAndSend("alert.exchange","alerts",splitter);
    }

    /**
     * 获取RabbitMQ消息
     */
    public void getAlert() {
        String string = (String) rabbitTemplate.receiveAndConvert("alert.queue");

    }

}
