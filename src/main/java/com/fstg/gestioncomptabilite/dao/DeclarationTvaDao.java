package com.fstg.gestioncomptabilite.dao;

import com.fstg.gestioncomptabilite.bean.DeclarationTva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeclarationTvaDao extends JpaRepository<DeclarationTva,Long> {
    DeclarationTva findByRef(String ref);
    int deleteByRef(String ref);
    DeclarationTva findByAnneeAndMois(double annee,double mois);
    DeclarationTva findByAnneeAndTrim(double annee,double trim);
    List<DeclarationTva> findByTypeDeclarationTvaRef(String ref);

}
