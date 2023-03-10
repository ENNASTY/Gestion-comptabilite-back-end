package com.fstg.gestioncomptabilite.dao;

import com.fstg.gestioncomptabilite.bean.Facture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FactureDao extends JpaRepository<Facture,Long> {
    Facture findByRef(String ref);
    int deleteByRef(String ref);
    List<Facture> findByAnnee(double annee);
    List<Facture> findByAnneeAndMois(double annee, double mois );
    List<Facture> findByAnneeAndTrim(double annee, double trim );
    List<Facture> findByAnneeAndTrimAndTypeFactureRef(double annee, double trim ,String ref);
    List<Facture> findByAnneeAndMoisAndTypeFactureRef(double annee, double mois ,String ref);
    List<Facture> findByAnneeAndTypeFactureRef(double annee ,String ref);
    List<Facture> findByTypeFactureRef(String ref);
    List<Facture> findByAnneeTypeFactureLibelle(double annee,String libelle);

}
