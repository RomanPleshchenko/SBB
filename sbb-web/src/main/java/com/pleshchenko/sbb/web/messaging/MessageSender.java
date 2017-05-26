package com.pleshchenko.sbb.web.messaging;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pleshchenko.sbb.app.dto.MessageDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

@Component
public class MessageSender {
    @Autowired
    JmsTemplate jmsTemplate;

    public void sendMessage(String message) {
        try {
            String jsonMessage = new ObjectMapper().writeValueAsString(message);
            jmsTemplate.send(new MessageCreator() {
                @Override
                public Message createMessage(Session session) throws JMSException {
                    return session.createTextMessage(jsonMessage);
                }
            });
        } catch (Exception e) {
        }
    }

    public void sendMessage(String action,String stationsName,int id) {

        MessageDTO messageDTO = new MessageDTO(action,id,stationsName);

        try {
            String jsonMessage = new ObjectMapper().writeValueAsString(messageDTO);
            jmsTemplate.send(new MessageCreator() {
                @Override
                public Message createMessage(Session session) throws JMSException {
                    return session.createTextMessage(jsonMessage);
                }
            });
        } catch (Exception e) {
        }
    }

}
