package com.fstg.gestioncomptabilite.ws;

import com.fstg.gestioncomptabilite.bean.Employee;
import com.fstg.gestioncomptabilite.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Gestion-comptabilite/v1/employee")
public class EmloyeeProvided {
    @GetMapping("/cin/{cin}")
    public Employee findByCin(@PathVariable String cin) {
        return employeeService.findByCin(cin);
    }

    @DeleteMapping("/cin/{cin}")
    public int deleteByCin(@PathVariable String cin) {
        return employeeService.deleteByCin(cin);
    }

    @GetMapping("/")
    public List<Employee> findAll() {
        return employeeService.findAll();
    }

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/")
    public int save(@RequestBody Employee employee) {
        return employeeService.save(employee);
    }
}
