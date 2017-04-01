package com.pleshchenko.sbb.service;

import com.pleshchenko.sbb.dao.RoleDao;
import com.pleshchenko.sbb.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("userProfileService")
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
