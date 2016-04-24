package com.thiseasy.model;

import com.thiseasy.model.Disease;
import com.thiseasy.model.User;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by andrecampos on 4/24/16.
 */
@Entity
public class DiseaseRegister {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "infectedId")
    private User infected;
    @ManyToOne
    @JoinColumn(name = "diseaseId")
    private Disease disease;
    private Double latitude;
    private Double longitude;
    private Date registerDate;
    private String color;

    public User getInfected() {
        return infected;
    }

    public void setInfected(User infected) {
        this.infected = infected;
    }

    public Disease getDisease() {
        return disease;
    }

    public void setDisease(Disease disease) {
        this.disease = disease;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    public String getColor() {
        return color;
    }

    public String setColor(String color) {
        return this.color = color;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
