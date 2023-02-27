package com.fstg.gestioncomptabilite.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Facture {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String ref;
    private double montantHorsTaxe;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date dateFacture;
    private double annee;
    private double mois;
    private double trim;
    private double montantTtc;
    private double montantTva;
    @ManyToOne
    private TypeFacture typeFacture;
    @ManyToOne
    private Tva tva;
    @ManyToOne
    private DeclarationIS declarationIS;
    @ManyToOne
    private DeclarationTva declarationTva;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public double getMontantHorsTaxe() {
        return montantHorsTaxe;
    }

    public void setMontantHorsTaxe(double montantHorsTaxe) {
        this.montantHorsTaxe = montantHorsTaxe;
    }

    public Date getDateFacture() {
        return dateFacture;
    }

    public void setDateFacture(Date dateFacture) {
        this.dateFacture = dateFacture;
    }

    public double getAnnee() {
        return annee;
    }

    public void setAnnee(double annee) {
        this.annee = annee;
    }

    public double getMois() {
        return mois;
    }

    public void setMois(double mois) {
        this.mois = mois;
    }

    public double getTrim() {
        return trim;
    }

    public void setTrim(double trim) {
        this.trim = trim;
    }

    public double getmontantTtc() {
        return montantTtc;
    }

    public void setmontantTtc(double montantTtc) {
        this.montantTtc = montantTtc;
    }

    public double getmontantTva() {
        return montantTva;
    }

    public void setmontantTva(double montantTva) {
        this.montantTva = montantTva;
    }

    public TypeFacture getTypeFacture() {
        return typeFacture;
    }

    public void setTypeFacture(TypeFacture typeFacture) {
        this.typeFacture = typeFacture;
    }

    public Tva getTva() {
        return tva;
    }

    public void setTva(Tva tva) {
        this.tva = tva;
    }

    public DeclarationIS getDeclarationIS() {
        return declarationIS;
    }

    public void setDeclarationIS(DeclarationIS declarationIS) {
        this.declarationIS = declarationIS;
    }

    public DeclarationTva getDeclarationTva() {
        return declarationTva;
    }

    public void setDeclarationTva(DeclarationTva declarationTva) {
        this.declarationTva = declarationTva;
    }
}
