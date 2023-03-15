package com.fstg.gestioncomptabilite.ws;

import com.fstg.gestioncomptabilite.bean.DeclarationIR;
import com.fstg.gestioncomptabilite.bean.DeclarationIREmployee;
import com.fstg.gestioncomptabilite.service.DeclarationIrEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Gestion-comptabilite/v1/declarationIrEmployee")
public class DeclarationIrEmployeeProvided {
    @GetMapping("/refEmp/{refEmp}")
    public DeclarationIREmployee findByRefEmp(@PathVariable String refEmp) {
        return declarationIrEmployeeService.findByRefEmp(refEmp);
    }

    @GetMapping("/emplyee/cin/{cin}")
    public DeclarationIREmployee findByEmployeeCin(@PathVariable String cin) {
        return declarationIrEmployeeService.findByEmployeeCin(cin);
    }

    @GetMapping("/declarationIr/ref/{ref}")
    public List<DeclarationIREmployee> findByDeclarationIRRef(@PathVariable String ref) {
        return declarationIrEmployeeService.findByDeclarationIRRef(ref);
    }

    @DeleteMapping("/emplyee/cin/{cin}")
    @Transactional
    public int deleteByEmployeeCin(@PathVariable String cin) {
        return declarationIrEmployeeService.deleteByEmployeeCin(cin);
    }

    @GetMapping("/")
    public List<DeclarationIREmployee> findAll() {
        return declarationIrEmployeeService.findAll();
    }


    @Autowired
    private DeclarationIrEmployeeService declarationIrEmployeeService;
}
