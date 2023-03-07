
package com.fstg.gestioncomptabilite.dao;

import com.fstg.gestioncomptabilite.bean.TypeDeclarationTva;
import com.fstg.gestioncomptabilite.bean.TypeFacture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeFactureDao extends JpaRepository<TypeFacture, Long> {
    TypeFacture findByRef(String ref);
    int deleteByRef(String ref);
    TypeFacture findByLibelle(String libelle);
}
