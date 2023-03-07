package com.fstg.gestioncomptabilite.dao;

import com.fstg.gestioncomptabilite.bean.DeclarationIS;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeclarationIsDao extends JpaRepository<DeclarationIS,Long> {
    DeclarationIS findByAnnee(double annee);
    int deleteByAnnee(double annee);
}
