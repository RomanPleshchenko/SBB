package com.pleshchenko.sbb.app.repositories.impl;

import com.pleshchenko.sbb.app.entity.authorization.User;
import com.pleshchenko.sbb.app.entity.ticket.TripsSite;
import com.pleshchenko.sbb.app.repositories.interfaces.TicketDao;
import com.pleshchenko.sbb.app.entity.ticket.Ticket;
import com.pleshchenko.sbb.app.repositories.interfaces.AbstractDao;
import com.pleshchenko.sbb.app.service.interfaces.TripsSiteService;
import com.pleshchenko.sbb.app.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.List;

/**
 * Created by РОМАН on 08.04.2017.
 */
@Repository("ticketDao")
public class TicketDaoImpl extends AbstractDao<Integer,Ticket> implements TicketDao {

    @Autowired
    TripsSiteService tripsSiteService;

    @Autowired
    UserService userService;

    @Override
    public List<Ticket> findAll() {
        List<Ticket> tickets = getEntityManager()
                .createQuery("SELECT t FROM Ticket t")
                .getResultList();
        return tickets;
    }

    @Override
    public void save(Ticket ticket) {
        persist(ticket);
    }

    @Override
    public Ticket findById(Integer id) {
        List<Ticket> tickets = getEntityManager()
                .createQuery("SELECT t FROM Ticket t WHERE t.id = "
                        + id)
                .getResultList();
        if (tickets.size()==0)
            return null;
        else
            return tickets.get(0);
    }

    @Override
    public Ticket buyTicket(int st1,int st2,int dirId,int carId,int siteId,String userName){

        String nativeQuery = "SELECT \n" +
                "    ts.id,\n" +
                "    `scheduleId`,\n" +
                "    `carId`,\n" +
                "    `segmentId`,\n" +
                "    `sitePrototypeId`,\n" +
                "    `sold`\n" +
                "FROM \n" +
                "   `tripsSite` ts\n" +
                "LEFT JOIN sitePrototype sp ON sp.id = ts.sitePrototypeId " +
                "WHERE \n" +
                "    ts.scheduleId = :dirId AND\n" +
                "    ts.carId = :carId AND\n" +
                "    sp.number = :siteId AND segmentiD IN (SELECT \n" +
                " rc.segmentId\n" +
                "      FROM \n" +
                "                                         `routeComposition` rc\n" +
                " " +
                "      LEFT JOIN segment s on rc.segmentId = s.id\n" +
                " " +
                "      WHERE \n" +
                " rc.routeId = (SELECT \n" +
                "     s.routeId \n" +
                "       FROM schedule s\n" +
                "                               WHERE s.id = :dirId)\n" +
                "      AND s.departureStationId >= :st1 AND s.destinationStationId <= :st2)\n";

        List<TripsSite> tripsSites = getEntityManager()
                .createNativeQuery(nativeQuery,TripsSite.class)
                .setParameter("st1",st1)
                .setParameter("st2",st2)
                .setParameter("dirId",dirId)
                .setParameter("carId",carId)
                .setParameter("siteId",siteId)
                .getResultList();

        for (TripsSite tripsSite:tripsSites){
            tripsSite.setSold(true);
            tripsSiteService.save(tripsSite);
            System.out.println(tripsSite.getId());
        }


        Ticket ticket = new Ticket();
        User user = userService.findBySSO(userName);
        ticket.setUser(user);

        ticket.setTripsSites(new HashSet<>(tripsSites));

        persist(ticket);

        return ticket;
    }
}
