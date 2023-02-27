package com.fstg.gestioncomptabilite.bean;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.Date;

@Entity
public class TauxIS {
    @Id
    @GeneratedValue
    private Long id;
    private String ref;
    private Date dateMax;
    private Date dateMin;
    private double resultatMin;
    private double resultatMax;
    private double pourcentage;
    private double cotisationMin;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public Date getDateMax() {
        return dateMax;
    }

    public void setDateMax(Date dateMax) {
        this.dateMax = dateMax;
    }

    public Date getDateMin() {
        return dateMin;
    }

    public void setDateMin(Date dateMin) {
        this.dateMin = dateMin;
    }

    public double getResultatMin() {
        return resultatMin;
    }

    public void setResultatMin(double resultatMin) {
        this.resultatMin = resultatMin;
    }

    public double getResultatMax() {
        return resultatMax;
    }

    public void setResultatMax(double resultatMax) {
        this.resultatMax = resultatMax;
    }

    public double getPourcentage() {
        return pourcentage;
    }

    public void setPourcentage(double pourcentage) {
        this.pourcentage = pourcentage;
    }

    public double getCotisationMin() {
        return cotisationMin;
    }

    public void setCotisationMin(double cotisationMin) {
        this.cotisationMin = cotisationMin;
    }
}
