package com.fstg.gestioncomptabilite.dao;

import com.fstg.gestioncomptabilite.bean.TauxIS;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TauxIsDao extends JpaRepository<TauxIS, Long> {
    TauxIS findByRef(String ref);
    int deleteByRef(String ref);
}
