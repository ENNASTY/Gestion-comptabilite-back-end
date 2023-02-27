package com.fstg.gestioncomptabilite.bean;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class DeclarationIREmployee {
    @Id
    @GeneratedValue
    private Long id;
    private String refEmp;
    private double salaireNet;
    private double salaireBrut;
    private double montantIR;
    @ManyToOne
    private Employee employee;
    @ManyToOne
    private DeclarationIR declarationIR;
    @ManyToOne
    private TauxIR tauxIR;

<<<<<<< HEAD
    public TauxIR getTauxIR() {
        return tauxIR;
    }

    public void setTauxIR(TauxIR tauxIR) {
        this.tauxIR = tauxIR;
    }
=======
>>>>>>> 7411f171fc0a261d144a1ba66f7bfac23aed70cd

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getRefEmp() {
        return refEmp;
    }

    public void setRefEmp(String refEmp) {
        this.refEmp = refEmp;
    }

    public double getSalaireNet() {
        return salaireNet;
    }

    public void setSalaireNet(double salaireNet) {
        this.salaireNet = salaireNet;
    }

    public double getSalaireBrut() {
        return salaireBrut;
    }

    public void setSalaireBrut(double salaireBrut) {
        this.salaireBrut = salaireBrut;
    }

    public double getMontantIR() {
        return montantIR;
    }

    public void setMontantIR(double montantIR) {
        this.montantIR = montantIR;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public DeclarationIR getDeclarationIR() {
        return declarationIR;
    }

    public void setDeclarationIR(DeclarationIR declarationIR) {
        this.declarationIR = declarationIR;
    }
}
