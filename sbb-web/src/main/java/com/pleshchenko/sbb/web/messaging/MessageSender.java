package com.pleshchenko.sbb.web.messaging;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.ObjectMessage;
import javax.jms.Session;

import javax.annotation.Resource;
import javax.jms.*;

import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.jms.support.destination.JndiDestinationResolver;
import org.springframework.stereotype.Component;

@Component
public class MessageSender {
    @Autowired
    JmsTemplate jmsTemplate;

//    public void sendMessage(final String msg) {
//
//        jmsTemplate.send(new MessageCreator(){
//            @Override
//            public Message createMessage(Session session) throws JMSException{
//                ObjectMessage objectMessage = session.createObjectMessage(msg);
//                return objectMessage;
//            }
//        });
//    }

    @Resource(mappedName = "java:/ConnectionFactory")
    ConnectionFactory jmsConnectionFactory;

    public void sendMessage(String msg) {
        jmsTemplate.setConnectionFactory(jmsConnectionFactory);
        this.jmsTemplate.send( new MessageCreator() {
            public Message createMessage(Session session) throws JMSException {
                return session.createTextMessage(msg);
            }
        });

    }
}