package com.guoyuhang.alerts;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsOperations;
import org.springframework.jms.core.MessageCreator;
import org.springframework.jms.support.JmsUtils;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.ObjectMessage;
import javax.jms.Session;

@Component
public class AlertServiceImpl implements AlertService{
    private JmsOperations jmsOperations;

    @Autowired
    public AlertServiceImpl(JmsOperations jmsOperations) {
        this.jmsOperations = jmsOperations;
    }

    /**
     * 发送消息
     * @param s
     */
    public void sendSpittleAlert(String s) {
        //指定目的地(发送给谁)与发送消息
        jmsOperations.send("alert.queue", new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                //创建消息
                return session.createObjectMessage(s);
            }
        });
        //指定发送消息，使用默认目的地
        jmsOperations.send(new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                //创建消息
                return session.createObjectMessage(s);
            }
        });
        //使用内置消息转换器，不需要MessageCreator
        jmsOperations.convertAndSend(s);
    }

    /**
     * 接收消息
     */
    public String receive() {
        ObjectMessage receivedMessage = (ObjectMessage) jmsOperations.receive();
        try {
            return (String) receivedMessage.getObject();
//            return (String) jmsOperations.receiveAndConvert();
        } catch (JMSException e) {
            throw JmsUtils.convertJmsAccessException(e);
        }
    }
}
