package com.fstg.gestioncomptabilite.service;

import com.fstg.gestioncomptabilite.bean.DeclarationIS;
import com.fstg.gestioncomptabilite.bean.Facture;
import com.fstg.gestioncomptabilite.bean.TauxIS;
import com.fstg.gestioncomptabilite.dao.DeclarationIsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DeclarationIsService {
    @Autowired
    private DeclarationIsDao declarationIsDao;
    @Autowired
    private TauxIsService tauxIsService;
    @Autowired
    private FactureService factureService;

    public DeclarationIS findByAnnee(double annee) {
        return declarationIsDao.findByAnnee(annee);
    }
    @Transactional
    public int deleteByAnnee(double annee) {
        return declarationIsDao.deleteByAnnee(annee);
    }

    public List<DeclarationIS> findAll() {
        return declarationIsDao.findAll();
    }
    public int save(DeclarationIS declarationIS){
        if(findByAnnee(declarationIS.getAnnee()) != null){
            return -1;
        }
        else{
            double gain = 0;
            double charge = 0;
            List<Facture> facturesC=factureService.findByAnneeTypeFactureLibelle(declarationIS.getAnnee(),"client");
            for (Facture f: facturesC){
                gain+= f.getMontantHorsTaxe();
            }
            List<Facture> facturesF=factureService.findByAnneeTypeFactureLibelle(declarationIS.getAnnee(),"fournisseur");
            for (Facture f: facturesF){
                charge+= f.getMontantHorsTaxe();
            }
            declarationIS.setChiffAffaire(gain);
            declarationIS.setCharge(charge);
            declarationIS.setBenifice(declarationIS.getChiffAffaire() - declarationIS.getCharge());
            declarationIS.setMontantIS(tauxIsService.calculMontantIs(declarationIS.getBenifice()));
            declarationIsDao.save(declarationIS);
            List<Facture> factures = factureService.findByAnnee(declarationIS.getAnnee());
            for (Facture f: factures){
                f.setDeclarationIS(declarationIS);
                factureService.update(f);
            }
            return 1;

        }

    }


}
