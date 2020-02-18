package com.dh.jc.Primero.JC1.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="genres")
public class Genre {

    private String name;
    @Id
    private Integer id;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
