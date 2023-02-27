package com.fstg.gestioncomptabilite.bean;

import jakarta.persistence.*;

@Entity
public class DeclarationTva {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String ref;
    private double tvaCollecte;
    private double tvaPerdue;
    private double diffTva;
    private double annee;
    private double mois;
    private double trim;
    @ManyToOne
    private TypeDeclarationTva typeDeclarationTva;

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

    public double getTvaCollecte() {
        return tvaCollecte;
    }

    public void setTvaCollecte(double tvaCollecte) {
        this.tvaCollecte = tvaCollecte;
    }

    public double getTvaPerdue() {
        return tvaPerdue;
    }

    public void setTvaPerdue(double tvaPerdue) {
        this.tvaPerdue = tvaPerdue;
    }

    public double getDiffTva() {
        return diffTva;
    }

    public void setDiffTva(double diffTva) {
        this.diffTva = diffTva;
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

    public TypeDeclarationTva getTypeDeclarationTva() {
        return typeDeclarationTva;
    }

    public void setTypeDeclarationTva(TypeDeclarationTva typeDeclarationTva) {
        this.typeDeclarationTva = typeDeclarationTva;
    }
}
