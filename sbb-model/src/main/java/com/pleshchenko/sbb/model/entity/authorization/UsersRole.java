package com.pleshchenko.sbb.model.entity.authorization;


import javax.persistence.*;
import javax.persistence.Table;

@Entity
@Table(name = "usersRole")
public class UsersRole {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "usersId")
    private Integer usersId;

    @Column(name = "roleId")
    private Integer roleId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setUsersId(Integer usersId) {
        this.usersId = usersId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public Integer getUsersId() {
        return usersId;
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
