package com.pleshchenko.sbb.app.service.interfaces;

import com.pleshchenko.sbb.app.entity.ticket.SiteCarClass;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by РОМАН on 26.04.2017.
 */
@Service("siteCarClassService")
@Transactional
public interface SiteCarClassService {

    /**
     *
     * @return a list of all site car class
     */
    List<SiteCarClass> findAll();

    /**
     *
     * @param id
     * @return
     */
    SiteCarClass findById(int id);
}
