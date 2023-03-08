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
    public int save(TauxIS tauxIS) {
        if (findByRef(tauxIS.getRef()) != null){
            return -1;
        }else {
            tauxIsDao.save(tauxIS);
            return 1;
        }
    }

}
