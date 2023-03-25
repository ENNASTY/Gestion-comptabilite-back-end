package com.fstg.gestioncomptabilite.ws;

import com.fstg.gestioncomptabilite.bean.Employee;
import com.fstg.gestioncomptabilite.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("Gestion-comptabilite/v1/employee")
public class EmployeeProvided {

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
    public Employee save(@RequestBody Employee employee) {
        return employeeService.save(employee);
    }
}
