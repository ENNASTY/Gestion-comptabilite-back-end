package com.fstg.gestioncomptabilite.service;

import com.fstg.gestioncomptabilite.bean.TypeDeclarationTva;
import com.fstg.gestioncomptabilite.dao.TypeDeclarationTvaDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TypeDeclarationTvaService {
    @Autowired
    private TypeDeclarationTvaDao typeDeclarationTvaDao;
    @Autowired
    private DeclarationTvaService declarationTvaService;

    public TypeDeclarationTva findByRef(String ref) {
        return typeDeclarationTvaDao.findByRef(ref);
    }
    @Transactional
    public int deleteByRef(String ref) {
        declarationTvaService.findByTypeDeclarationTvaRef(ref);
        typeDeclarationTvaDao.deleteByRef(ref);
        return 1;
    }

    public TypeDeclarationTva findByLibelle(String libelle) {
        return typeDeclarationTvaDao.findByLibelle(libelle);
    }

    public List<TypeDeclarationTva> findAll() {
        return typeDeclarationTvaDao.findAll();
    }
    public int save(TypeDeclarationTva typeDeclarationTva){
        if(findByRef(typeDeclarationTva.getRef())!= null){
            return -1;
        }
        else {
            typeDeclarationTvaDao.save(typeDeclarationTva);
            return 1;
        }

    }
}
