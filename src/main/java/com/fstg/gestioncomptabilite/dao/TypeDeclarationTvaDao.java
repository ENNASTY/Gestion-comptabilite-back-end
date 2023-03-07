package com.fstg.gestioncomptabilite.dao;

import com.fstg.gestioncomptabilite.bean.TypeDeclarationTva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeDeclarationTvaDao extends JpaRepository<TypeDeclarationTva, Long> {
    TypeDeclarationTva findByRef(String ref);
    int deleteByRef(String ref);
    TypeDeclarationTva findByLibelle(String libelle);

}
