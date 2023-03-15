package com.fstg.gestioncomptabilite.dao;

import com.fstg.gestioncomptabilite.bean.DeclarationIR;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface DeclarationIrDao extends JpaRepository<DeclarationIR,Long> {
    DeclarationIR findByRef(String ref);
    int deleteByRef(String ref);
    DeclarationIR findByMoisAndAnnee(double mois, double annee);
    int deleteByMoisAndAnnee(double mois, double annee);
    List<DeclarationIR> findByAnnee(double annee);
}
