package com.pleshchenko.sbb.model.model.entity.authorization;


import javax.persistence.*;
import javax.persistence.Table;

@Entity
@Table(name = "usersRole")
public class UsersRole {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @Basic
    @Column(name = "usersId")
    private int usersId;

    @Basic
    @Column(name = "rolesId")
    private int rolesId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getUsersId() {
        return usersId;
    }

    public void setUsersId(int usersId) {
        this.usersId = usersId;
    }

    public int getRolesId() {
        return rolesId;
    }

    public void setRolesId(int rolesId) {
        this.rolesId = rolesId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UsersRole usersRole = (UsersRole) o;

        return id.equals(usersRole.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
