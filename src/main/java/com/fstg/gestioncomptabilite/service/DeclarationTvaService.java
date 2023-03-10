package com.fstg.gestioncomptabilite.service;

import com.fstg.gestioncomptabilite.bean.DeclarationTva;
import com.fstg.gestioncomptabilite.bean.Facture;
import com.fstg.gestioncomptabilite.bean.TypeDeclarationTva;
import com.fstg.gestioncomptabilite.dao.DeclarationTvaDao;
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
        if (findByRef(declarationTva.getRef())!=null){
            return -1;
        }
        TypeDeclarationTva t = typeDeclarationTvaService.findByRef(declarationTva.getTypeDeclarationTva().getRef());
        declarationTva.setTypeDeclarationTva(t);
        if (t==null) {
            return -2;
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
                if(facture.getTypeFacture().getLibelle().equals("client")){
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
}
