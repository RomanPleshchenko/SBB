package com.pleshchenko.sbb.service.dto.impl;

import com.pleshchenko.sbb.service.dao.interfaces.RoleDao;
import com.pleshchenko.sbb.service.dto.interfaces.RoleService;
import com.pleshchenko.sbb.model.entity.authorization.Role;
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
