package com.pleshchenko.sbb.dao;

import com.pleshchenko.sbb.model.Role;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;
import java.util.List;

@Repository("RoleDao")
public class RoleDaoImpl extends AbstractDao<Integer,Role>implements RoleDao{

    @Override
    public Role findById(int id) {
        return getByKey(id);
    }

    @Override
    public Role findByName(String name) {
        try{
            Role userProfile = (Role) getEntityManager()
                    .createQuery("SELECT p FROM Role p WHERE p.name LIKE :name")
                    .setParameter("name", name)
                    .getSingleResult();
            return userProfile;
        }catch(NoResultException ex){
            return null;
        }
    }

    @Override
    public List<Role> findAll() {
        List<Role> userProfiles = getEntityManager()
                .createQuery("SELECT p FROM Role p  ORDER BY p.name ASC")
                .getResultList();
        return userProfiles;
    }


}
