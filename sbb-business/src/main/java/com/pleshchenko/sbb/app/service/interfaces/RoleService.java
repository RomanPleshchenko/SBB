package com.pleshchenko.sbb.app.service.interfaces;

import com.pleshchenko.sbb.app.entity.authorization.Role;
import java.util.List;

public interface RoleService {

    Role findById(int id);

    Role findByType(String type);

    List<Role> findAll();

}
