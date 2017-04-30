package com.pleshchenko.sbb.app.entity.schedule;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Set;

/**
 * Created by РОМАН on 26.04.2017.
 */
@Entity
@Table(name = "Route")
public class Route {

    @Id
    @Column(name = "id")
    private Integer id;

    @NotNull
    @Column(name = "number")
    private String number;

    @NotNull
    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "route",cascade = CascadeType.PERSIST,fetch = FetchType.EAGER)
    private Set<RouteComposition> routeCompositions;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<RouteComposition> getRouteCompositions() {
        return routeCompositions;
    }

    public void setRouteCompositions(Set<RouteComposition> routeCompositions) {
        this.routeCompositions = routeCompositions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Route route = (Route) o;

        return id.equals(route.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
