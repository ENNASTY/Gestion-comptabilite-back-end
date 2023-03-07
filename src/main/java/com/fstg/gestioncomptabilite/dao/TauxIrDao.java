package com.fstg.gestioncomptabilite.dao;

import com.fstg.gestioncomptabilite.bean.TauxIR;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TauxIrDao extends JpaRepository<TauxIR,Long> {
    TauxIR findByRef(String ref);
    int deleteByRef(String ref);

}
