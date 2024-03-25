package com.fstg.gestioncomptabilite.service;

import com.fstg.gestioncomptabilite.bean.TauxIS;
import com.fstg.gestioncomptabilite.dao.TauxIsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TauxIsService {
    @Autowired
    private TauxIsDao tauxIsDao;

    public TauxIS findByRef(String ref) {
        return tauxIsDao.findByRef(ref);
    }

    @Transactional
    public int deleteByRef(String ref) {
        return tauxIsDao.deleteByRef(ref);
    }

    public List<TauxIS> findAll() {
        return tauxIsDao.findAll();
    }

    public double calculMontantIs(double resultat) {
        List<TauxIS> tauxISList = findAll();
        double montantIs = 0;
        for (TauxIS taux : tauxISList) {
            if (resultat >= taux.getResultatMin() && resultat <= taux.getResultatMax()) {
                montantIs = resultat * (taux.getPourcentage() / 100);
            }
            if (montantIs < taux.getCotisationMin()) {
                montantIs = taux.getCotisationMin();
            }
        }
        return montantIs;
    }

    public TauxIS save(TauxIS tauxIS) {
        TauxIS res = null;

        if (tauxIS.getRef() == null || tauxIS.getResultatMax()<tauxIS.getResultatMin()){
            res= null;
        }

        else if (findByRef(tauxIS.getRef()) == null) {
            res =  tauxIsDao.save(tauxIS);
        }
        return res;

    }


}
