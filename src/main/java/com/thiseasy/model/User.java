package com.thiseasy.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by andrecampos on 4/23/16.
 */
@Entity
@Table(name = "User")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private Date birthdate;
    private Character gender;

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public Character getGender() {
        return gender;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public void setGender(Character gender) {
        this.gender = gender;
    }
}
