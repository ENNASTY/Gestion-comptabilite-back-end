package com.fstg.gestioncomptabilite.service;

import com.fstg.gestioncomptabilite.bean.TauxIR;
import com.fstg.gestioncomptabilite.dao.TauxIrDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TauxIrService {
    @Autowired
    private TauxIrDao tauxIrDao;

    public TauxIR findByRef(String ref) {
        return tauxIrDao.findByRef(ref);
    }

    @Transactional
    public int deleteByRef(String ref) {
        return tauxIrDao.deleteByRef(ref);
    }

    public List<TauxIR> findAll() {
        return tauxIrDao.findAll();
    }

    public double calculMontantIr(double salaire) {
        List<TauxIR> tauxIRList = findAll();
        double montantIr = 0;
        for (TauxIR taux : tauxIRList) {
            if (salaire >= taux.getSalaireMin() && salaire <= taux.getSalaireMax()) {
                montantIr = salaire * (taux.getPourcentage() / 100);
            }
        }
        return montantIr;

    }
    public TauxIR save(TauxIR tauxIR) {
        TauxIR res = null;

        if (tauxIR.getRef() == null || tauxIR.getSalaireMax()<tauxIR.getSalaireMin()){
            res= null;
        }

        else if (findByRef(tauxIR.getRef()) == null) {
            res =  tauxIrDao.save(tauxIR);
        }
        return res;

    }
}
