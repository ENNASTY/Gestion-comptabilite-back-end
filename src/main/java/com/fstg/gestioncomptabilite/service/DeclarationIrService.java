package com.fstg.gestioncomptabilite.service;

import com.fstg.gestioncomptabilite.bean.DeclarationIR;
import com.fstg.gestioncomptabilite.bean.DeclarationIREmployee;
import com.fstg.gestioncomptabilite.dao.DeclarationIrDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class DeclarationIrService {
    @Autowired
    private DeclarationIrDao declarationIrDao;
    @Autowired
    private DeclarationIrEmployeeService declarationIrEmployeeService;

    public DeclarationIR findByRef(String ref) {
        return declarationIrDao.findByRef(ref);
    }
    @Transactional
    public int deleteByRef(String ref) {
        return declarationIrDao.deleteByRef(ref);
    }

    public DeclarationIR findByMoisAndAnnee(double mois, double annee) {
        return declarationIrDao.findByMoisAndAnnee(mois, annee);
    }
    @Transactional
    public int deletByMoisAndAnnee(double mois, double annee) {
        return declarationIrDao.deletByMoisAndAnnee(mois, annee);
    }

    public List<DeclarationIR> findByAnnee(double annee) {
        return declarationIrDao.findByAnnee(annee);
    }

    public List<DeclarationIR> findAll() {
        return declarationIrDao.findAll();
    }
    public int save(DeclarationIR declarationIR){
        if(findByMoisAndAnnee(declarationIR.getMois(),declarationIR.getAnnee()) != null){
            return -1;
        }
        else {
            List<DeclarationIREmployee> declarationIREmployees = declarationIrEmployeeService.findByDeclarationIr(declarationIR);
            double total = declarationIrEmployeeService.calculTotal(declarationIREmployees);
            declarationIR.setTotal(total);
            declarationIrDao.save(declarationIR);
            return 1;
        }
    }
}
