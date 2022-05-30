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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public void setCity(String city) {
        this.city = city;
    }
    public String getCity() {
        return city;
    }

    public void setEmail(String email) {
        this.email = email;
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
