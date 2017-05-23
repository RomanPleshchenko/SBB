package com.pleshchenko.sbb.app.repositories.interfaces;

import com.pleshchenko.sbb.app.entity.ticket.SiteCarClass;

import java.util.List;

/**
 * Created by РОМАН on 26.04.2017.
 */
public interface SiteCarClassDao {

    List<SiteCarClass> findAll();

    SiteCarClass findById(int id);
}
