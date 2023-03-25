package com.fstg.gestioncomptabilite.service;

import com.fstg.gestioncomptabilite.bean.DeclarationTva;
import com.fstg.gestioncomptabilite.bean.Facture;
import com.fstg.gestioncomptabilite.bean.TypeDeclarationTva;
import com.fstg.gestioncomptabilite.dao.DeclarationTvaDao;
import com.fstg.gestioncomptabilite.vo.DeclarationTvaVo1;
import com.fstg.gestioncomptabilite.vo.DeclarationTvaVo2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class DeclarationTvaService {
    @Autowired
    DeclarationTvaDao declarationTvaDao;
    @Autowired
    private FactureService factureService;
    @Autowired
    private TypeDeclarationTvaService typeDeclarationTvaService;

    public DeclarationTva findByRef(String ref) {
        return declarationTvaDao.findByRef(ref);
    }
    @Transactional
    public int deleteByRef(String ref) {
        return declarationTvaDao.deleteByRef(ref);
    }

    public DeclarationTva findByAnneeAndMois(double annee, double mois) {
        return declarationTvaDao.findByAnneeAndMois(annee, mois);
    }

    public DeclarationTva findByAnneeAndTrim(double annee, double trim) {
        return declarationTvaDao.findByAnneeAndTrim(annee, trim);
    }

    public List<DeclarationTva> findByTypeDeclarationTvaRef(String ref) {
        return declarationTvaDao.findByTypeDeclarationTvaRef(ref);
    }

    public List<DeclarationTva> findAll() {
        return declarationTvaDao.findAll();
    }
    public int save(DeclarationTva declarationTva){
        declarationTva.setRef(System.currentTimeMillis()+"");
        if (findByAnneeAndMois(declarationTva.getAnnee(),declarationTva.getMois())!=null){
            return -1;
        }
        if (findByAnneeAndTrim(declarationTva.getAnnee(),declarationTva.getTrim())!=null){
            return -2;
        }
        TypeDeclarationTva t = typeDeclarationTvaService.findByRef(declarationTva.getTypeDeclarationTva().getRef());
        declarationTva.setTypeDeclarationTva(t);
        if (t==null) {
            return -3;
        }
        else{
            declarationTvaDao.save(declarationTva);
            List<Facture> factures = new ArrayList<Facture>();
            double tvaC=0,tvaP=0,dTva=0;
            if (declarationTva.getTypeDeclarationTva().getLibelle().equals("trimestrielle")){
                factures=factureService.findByAnneeAndTrim(declarationTva.getAnnee(),declarationTva.getTrim());
            }
            else {
                factures=factureService.findByAnneeAndMois(declarationTva.getAnnee(),declarationTva.getMois());
            }
            DeclarationTva myDeclarationTva = findByRef(declarationTva.getRef());
            for (Facture facture:factures){
                if(facture.getTypeFacture().getlibelle().equals("client")){
                    tvaC+=facture.getmontantTva();
                    facture.setDeclarationTva(myDeclarationTva);
                    factureService.update(facture);
                }
                else{
                    tvaP+=facture.getmontantTva();
                    facture.setDeclarationTva(myDeclarationTva);
                    factureService.update(facture);
                }
            }
            myDeclarationTva.setTvaCollecte(tvaC);
            myDeclarationTva.setTvaPerdue(tvaP);
            dTva = tvaC - tvaP;
            myDeclarationTva.setDiffTva(dTva);
            declarationTvaDao.save(myDeclarationTva);
            return 1;
        }
    }
    public DeclarationTvaVo2 calcultva(DeclarationTvaVo1 declarationTvaVo1){
        DeclarationTvaVo2 declarationTvaVo2 = new DeclarationTvaVo2();
        List<Facture> facturesvente = new ArrayList<Facture>();
        List<Facture> facturesachat = new ArrayList<Facture>();
        double tvacollecter = 0,tvadeductible = 0,differencetva = 0;
        if (declarationTvaVo1.getTypedeclarationtva().equals("TDTV1")){
            facturesvente = factureService.findByAnneeAndTrimAndTypeFactureRef(declarationTvaVo1.getAnnee(),declarationTvaVo1.getTrim(),"ty-cl");
            facturesachat = factureService.findByAnneeAndTrimAndTypeFactureRef(declarationTvaVo1.getAnnee(),declarationTvaVo1.getTrim(),"ty-fo");
        }else {
            facturesvente = factureService.findByAnneeAndMoisAndTypeFactureRef(declarationTvaVo1.getAnnee(),declarationTvaVo1.getMois(),"ty-cl");
            facturesachat = factureService.findByAnneeAndMoisAndTypeFactureRef(declarationTvaVo1.getAnnee(),declarationTvaVo1.getMois(),"ty-fo");
        }
        for (Facture facture:facturesvente) {
            tvacollecter += facture.getmontantTva();
        }
        for (Facture facture:facturesachat) {
            tvadeductible += facture.getmontantTva();
        }
        declarationTvaVo2.setTvacollecter(tvacollecter);
        declarationTvaVo2.setTvadeductible(tvadeductible);
        differencetva = tvacollecter - tvadeductible;
        declarationTvaVo2.setDifferencetva(differencetva);
        return declarationTvaVo2;
    }


}
