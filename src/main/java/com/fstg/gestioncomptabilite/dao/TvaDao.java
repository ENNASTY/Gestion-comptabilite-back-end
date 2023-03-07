package com.fstg.gestioncomptabilite.dao;

import com.fstg.gestioncomptabilite.bean.Tva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TvaDao extends JpaRepository<Tva, Long> {
    Tva findByRef(String ref);
    int deleteByRef(String ref);
}
