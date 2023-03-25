package com.fstg.gestioncomptabilite.dao;

import com.fstg.gestioncomptabilite.bean.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeDao  extends JpaRepository<Employee,Long> {
    Employee findByCin(String cin);
    int deleteByCin(String cin);


}
