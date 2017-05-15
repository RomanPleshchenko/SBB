package com.pleshchenko.sbb.app.service.interfaces;

import com.pleshchenko.sbb.app.entity.authorization.Role;
import java.util.List;

public interface RoleService {

    /**
     *
     * @param id
     * @return role by id
     */
    Role findById(int id);

    /**
     *
     * @param type
     * @return role by type
     */
    Role findByType(String type);

    /**
     *
     * @return a list of all user
     */
    List<Role> findAll();

}
