package com.pleshchenko.sbb.app.service.impl;


import com.pleshchenko.sbb.app.entity.authorization.Role;
import com.pleshchenko.sbb.app.repositories.interfaces.RoleDao;
import com.pleshchenko.sbb.app.service.interfaces.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service("userProfileService")
@Transactional
public class RoleServiceImpl implements RoleService{
	
	@Autowired
	RoleDao dao;
	
	public Role findById(int id) {
		return dao.findById(id);
	}

	public Role findByType(String type){
		return dao.findByType(type);
	}

	public List<Role> findAll() {
		return dao.findAll();
	}
}
