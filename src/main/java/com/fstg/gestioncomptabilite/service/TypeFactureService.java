package com.fstg.gestioncomptabilite.service;

import com.fstg.gestioncomptabilite.bean.TypeFacture;
import com.fstg.gestioncomptabilite.dao.TypeFactureDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TypeFactureService {
    @Autowired
    private TypeFactureDao typeFactureDao;

    public TypeFacture findByRef(String ref) {
        return typeFactureDao.findByRef(ref);
    }
    @Transactional
    public int deleteByRef(String ref) {
        return typeFactureDao.deleteByRef(ref);
    }

    public TypeFacture findByLibelle(String libelle) {
        return typeFactureDao.findByLibelle(libelle);
    }

    public List<TypeFacture> findAll() {
        return typeFactureDao.findAll();
    }
    public int save(TypeFacture typeFacture){
        if(findByRef(typeFacture.getRef()) != null){
            return -1;
        }
        else{
            typeFactureDao.save(typeFacture);
            return 1;
        }
    }
}
