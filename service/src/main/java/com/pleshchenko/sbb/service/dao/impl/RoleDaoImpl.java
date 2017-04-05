package com.pleshchenko.sbb.service.dao.impl;

import com.pleshchenko.sbb.model.model.entity.authorization.Role;
import com.pleshchenko.sbb.service.dao.interfaces.AbstractDao;
import com.pleshchenko.sbb.service.dao.interfaces.RoleDao;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;
import java.util.List;

@Repository("RoleDao")
public class RoleDaoImpl extends AbstractDao<Integer,Role>implements RoleDao {

    @Override
    public Role findById(int id) {
        return getByKey(id);
    }

    @Override
    public Role findByName(String name) {
        try{
            Role role = (Role) getEntityManager()
                    .createQuery("SELECT p FROM Role p WHERE p.name LIKE :name")
                    .setParameter("name", name)
                    .getSingleResult();
            return role;
        }catch(NoResultException ex){
            return null;
        }
    }

    @Override
    public List<Role> findAll() {
        List<Role> role = getEntityManager()
                .createQuery("SELECT p FROM Role p  ORDER BY p.name ASC")
                .getResultList();
        return role;
    }
}