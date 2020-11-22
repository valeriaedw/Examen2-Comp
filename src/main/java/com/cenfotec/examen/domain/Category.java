package com.cenfotec.examen.domain;


import javax.persistence.*;
import java.util.Set;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "category")
    private Set<WorkShop> workshop;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<WorkShop> getWorkshop() {
        return workshop;
    }

    public void setWorkshop(Set<WorkShop> workshop) {
        this.workshop = workshop;
    }
}
