package com.pleshchenko.sbb.service.impl;

import com.pleshchenko.sbb.model.dao.RoleDao;
import com.pleshchenko.sbb.service.interfaces.RoleService;
import com.pleshchenko.sbb.model.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service("RoleService")
@Transactional
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleDao dao;

    @Override
    public Role findById(int id) {
        return dao.findById(id);
    }

    @Override
    public Role findByName(String name) {
        return dao.findByName(name);
    }

    @Override
    public List<Role> findAll() {
        return dao.findAll();
    }
}
