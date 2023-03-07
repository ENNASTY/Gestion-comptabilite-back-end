package com.fstg.gestioncomptabilite.dao;

import com.fstg.gestioncomptabilite.bean.DeclarationIREmployee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeclarationIrEmployeeDao extends JpaRepository<DeclarationIREmployee,Long> {
    DeclarationIREmployee findByRefEmp(String refEmp);
    DeclarationIREmployee findByEmployeeCin(String cin);
    List<DeclarationIREmployee> findByDeclarationIRRef(String ref);
    int deleteByEmployeeCin(String cin);


}
