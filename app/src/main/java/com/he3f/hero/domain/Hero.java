package com.he3f.hero.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(
                name = "hero")
@XmlAccessorType(XmlAccessType.FIELD)
public class Hero {


    private String name;
    private String email;
    private String city;
    private int id;

    public Hero() {
    }

    public java.lang.String getName() {
        return name;
    }

    public void setName(java.lang.String name) {
        this.name = name;
    }

    public java.lang.String getEmail() {
        return email;
    }

    public void setEmail(java.lang.String email) {
        this.email = email;
    }

    public java.lang.String getCity() {
        return city;
    }

    public void setCity(java.lang.String city) {
        this.city = city;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Hero(int id, String name) {
        this(name, id);
    }

    public Hero(String name, int id) {
        super();
        this.name = name;
        this.id = id;
    }

}
