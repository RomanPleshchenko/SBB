package com.pleshchenko.sbb.app.repositories.interfaces;

import com.pleshchenko.sbb.app.entity.ticket.SitePrototype;

import java.util.List;

/**
 * Created by РОМАН on 26.04.2017.
 */
public interface SitePrototypeDao {

    List<SitePrototype> findAll();
}
