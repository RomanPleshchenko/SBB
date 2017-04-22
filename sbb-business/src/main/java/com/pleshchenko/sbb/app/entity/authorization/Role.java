package com.pleshchenko.sbb.app.entity.authorization;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by РОМАН on 19.04.2017.
 */
@Entity
@Table(name="Role")
public class Role implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @Column(name="type", length=15, unique=true, nullable=false)
    private String type = RoleType.USER.getRoleType();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Role role = (Role) o;

        return id.equals(role.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return "Role [id=" + id + ", type=" + type + "]";
    }




}
