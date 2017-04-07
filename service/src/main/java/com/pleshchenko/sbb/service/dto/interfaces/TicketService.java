package com.pleshchenko.sbb.service.dto.interfaces;

import com.pleshchenko.sbb.model.entity.Ticket;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by РОМАН on 08.04.2017.
 */
@Service("ticketService")
@Transactional
public interface TicketService {
    List<Ticket> findAll() ;
}
