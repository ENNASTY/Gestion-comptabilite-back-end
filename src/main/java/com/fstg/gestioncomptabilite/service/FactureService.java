package com.fstg.gestioncomptabilite.service;

import com.fstg.gestioncomptabilite.bean.Facture;
import com.fstg.gestioncomptabilite.bean.Tva;
import com.fstg.gestioncomptabilite.dao.FactureDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class FactureService {
    @Autowired
    private FactureDao factureDao;
    @Autowired
    private TvaService tvaService;

    public Facture findByRef(String ref) {
        return factureDao.findByRef(ref);
    }
    @Transactional
    public int deleteByRef(String ref) {
        return factureDao.deleteByRef(ref);
    }

    public List<Facture> findByAnnee(double annee) {
        return factureDao.findByAnnee(annee);
    }

    public List<Facture> findByAnneeAndMois(double annee, double mois) {
        return factureDao.findByAnneeAndMois(annee, mois);
    }

    public List<Facture> findByAnneeAndTrim(double annee, double trim) {
        return factureDao.findByAnneeAndTrim(annee, trim);
    }

    public List<Facture> findByAnneeAndTrimAndTypeFactureRef(double annee, double trim, String ref) {
        return factureDao.findByAnneeAndTrimAndTypeFactureRef(annee, trim, ref);
    }

    public List<Facture> findByAnneeAndMoisAndTypeFactureRef(double annee, double mois, String ref) {
        return factureDao.findByAnneeAndMoisAndTypeFactureRef(annee, mois, ref);
    }

    public List<Facture> findByAnneeAndTypeFactureRef(double annee, String ref) {
        return factureDao.findByAnneeAndTypeFactureRef(annee, ref);
    }

    public List<Facture> findByTypeFactureRef(String ref) {
        return factureDao.findByTypeFactureRef(ref);
    }

    public List<Facture> findByAnneeAndTypeFactureLibelle(double annee, String libelle) {
        return factureDao.findByAnneeAndTypeFactureLibelle(annee, libelle);
    }

    public List<Facture> findAll() {
        return factureDao.findAll();
    }
    public Facture save(Facture facture) {
        Tva tv = tvaService.findByRef(facture.getTva().getRef());
        facture.setTva(tv);
        Facture f=findByRef(facture.getRef());
        if(f != null){
            return null;
        }
        else if(tv == null){
            return null;
        }
        else{
            facture.setDeclarationIS(null);
            facture.setDeclarationTva(null);
            facture.setTypeFacture(facture.getTypeFacture());
            facture.setmontantTva((facture.getMontantHorsTaxe() * facture.getTva().getValeur()) /100);
            facture.setmontantTtc(facture.getMontantHorsTaxe() + facture.getmontantTva());
            facture.setTrim(TrouverTrim(facture.getDateFacture()));
            facture.setMois(facture.getDateFacture().getMonth() + 1);
            facture.setAnnee(facture.getDateFacture().getYear() + 1900);
            factureDao.save(facture);
            return facture;
        }
    }
    public double TrouverTrim(Date date){
        if((date.getMonth() +1) <= 3){
            return 1;
        }
        else if((date.getMonth() +1) > 3 && (date.getMonth() +1) <= 6){
            return 2;
        }
        else if((date.getMonth() +1) > 6 && (date.getMonth() +1) <= 9){
            return 3;
        }
        else {
            return 4;
        }
    }
    public int update(Facture facture){
        Tva tv = tvaService.findByRef(facture.getTva().getRef());
        facture.setTva(tv);
        if(tv == null){
            return -1;
        }
        else{
            facture.setmontantTva((facture.getMontantHorsTaxe() * facture.getTva().getValeur()) /100);
            facture.setmontantTtc(facture.getMontantHorsTaxe() + facture.getmontantTva());
            facture.setTrim(TrouverTrim(facture.getDateFacture()));
            facture.setMois(facture.getDateFacture().getMonth() + 1);
            facture.setAnnee(facture.getDateFacture().getYear() + 1900);
            factureDao.save(facture);
            return 1;
        }

    }
}
