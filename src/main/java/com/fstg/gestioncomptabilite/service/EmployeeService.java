package com.fstg.gestioncomptabilite.service;

import com.fstg.gestioncomptabilite.bean.Employee;
import com.fstg.gestioncomptabilite.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeDao employeeDao;

    public Employee findByCin(String cin) {
        return employeeDao.findByCin(cin);
    }
    @Transactional
    public int deleteByCin(String cin) {
        return employeeDao.deleteByCin(cin);
    }

    public List<Employee> findAll() {
        return employeeDao.findAll();
    }

    public Employee save(Employee employee){
        Employee res = null;
        if (employeeDao.findByCin(employee.getCin())!= null){
            return res;
        }
        else{
           res = employeeDao.save(employee);
            return res;
        }

    }
}
