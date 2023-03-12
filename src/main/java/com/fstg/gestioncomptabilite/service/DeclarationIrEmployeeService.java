package com.fstg.gestioncomptabilite.service;

import com.fstg.gestioncomptabilite.bean.DeclarationIR;
import com.fstg.gestioncomptabilite.bean.DeclarationIREmployee;
import com.fstg.gestioncomptabilite.bean.Employee;
import com.fstg.gestioncomptabilite.dao.DeclarationIrEmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class DeclarationIrEmployeeService {
    @Autowired
    private DeclarationIrEmployeeDao declarationIrEmployeeDao;
    @Autowired
    private TauxIrService tauxIrService;
    @Autowired
    private EmployeeService employeeService;

    public DeclarationIREmployee findByRefEmp(String refEmp) {
        return declarationIrEmployeeDao.findByRefEmp(refEmp);
    }

    public DeclarationIREmployee findByEmployeeCin(String cin) {
        return declarationIrEmployeeDao.findByEmployeeCin(cin);
    }

    public List<DeclarationIREmployee> findByDeclarationIRRef(String ref) {
        return declarationIrEmployeeDao.findByDeclarationIRRef(ref);
    }

    @Transactional
    public int deleteByEmployeeCin(String cin) {
        return declarationIrEmployeeDao.deleteByEmployeeCin(cin);
    }

    public List<DeclarationIREmployee> findAll() {
        return declarationIrEmployeeDao.findAll();
    }

    public List<DeclarationIREmployee> findByDeclarationIr(DeclarationIR declarationIR) {
        List<Employee> employees = employeeService.findAll();
        List<DeclarationIREmployee> declarationIREmployees = new ArrayList<>();
        for (Employee employee : employees) {
            DeclarationIREmployee declaration = new DeclarationIREmployee();
            double ir = tauxIrService.calculMontantIr(employee.getSalaire());
            declaration.setEmployee(employee);
            declaration.setSalaireBrut(employee.getSalaire());
            declaration.setMontantIR(ir);
            declaration.setSalaireNet(employee.getSalaire() - ir);
            declaration.setDeclarationIR(declarationIR);
            declarationIrEmployeeDao.save(declaration);
            declarationIREmployees.add(declaration);
        }
        return declarationIREmployees;
    }

    public double calculTotal(List<DeclarationIREmployee> declarationIREmployees) {
        double total = 0;
        for (DeclarationIREmployee declarationIREmployee : declarationIREmployees) {
            total += declarationIREmployee.getMontantIR();
        }
        return total;
    }
}
