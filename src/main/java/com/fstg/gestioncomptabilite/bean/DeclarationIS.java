package com.fstg.gestioncomptabilite.bean;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class DeclarationIS {
    @Id
    @GeneratedValue
    private Long id;
    private double annee;
    private double chiffAffaire;
    private double charge;
    private double benifice;
    private double montantIS;
    @ManyToOne
    private TauxIS tauxIS;
    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public double getAnnee() {
        return annee;
    }

    public void setAnnee(double annee) {
        this.annee = annee;
    }

    public double getChiffAffaire() {
        return chiffAffaire;
    }

    public void setChiffAffaire(double chiffAffaire) {
        this.chiffAffaire = chiffAffaire;
    }

    public double getCharge() {
        return charge;
    }

    public void setCharge(double charge) {
        this.charge = charge;
    }

    public double getBenifice() {
        return benifice;
    }

    public void setBenifice(double benifice) {
        this.benifice = benifice;
    }

    public double getMontantIS() {
        return montantIS;
    }

    public void setMontantIS(double montantIS) {
        this.montantIS = montantIS;
    }

    public TauxIS getTauxIS() {
        return tauxIS;
    }

    public void setTauxIS(TauxIS tauxIS) {
        this.tauxIS = tauxIS;
    }
}
