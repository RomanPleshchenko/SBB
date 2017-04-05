package com.pleshchenko.sbb.service.dao.interfaces;

import com.pleshchenko.sbb.model.model.entity.authorization.Role;

import java.util.List;

public interface RoleDao {

	Role findById(int id);

	Role findByName(String name);

	List<Role> findAll();

}
