package com.pleshchenko.sbb.web.messaging;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pleshchenko.sbb.app.dto.MessageDTO;
import com.pleshchenko.sbb.app.entity.schedule.RouteComposition;
import com.pleshchenko.sbb.app.entity.schedule.Schedule;
import com.pleshchenko.sbb.app.service.interfaces.ScheduleService;
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

    @Autowired
    ScheduleService scheduleService;

    /**
     *
     * @param message
     */
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

    /**
     *
     * @param action
     * @param stationsName
     * @param id - schedule id
     */
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

    /**
     *
     * @param action
     * @param id - schedule id
     */
    public void sendMessage(String action, int id) {

        Schedule schedule = scheduleService.findById(id);
        String lastDepartureStation= null;
        for (RouteComposition routeComposition:schedule.getRoute().getRouteCompositions()) {
            String stationsName = routeComposition.getSegment().getDestinationStation().getName();
            lastDepartureStation = routeComposition.getSegment().getDepartureStation().getName();
            sendMessage(action,stationsName,id);
        }

        if (lastDepartureStation!=null){
            sendMessage(action,lastDepartureStation,id);
        }


    }
}
