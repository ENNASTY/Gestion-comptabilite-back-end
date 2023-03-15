package com.fstg.gestioncomptabilite.ws;

import com.fstg.gestioncomptabilite.bean.TypeDeclarationTva;
import com.fstg.gestioncomptabilite.service.TypeDeclarationTvaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Gestion-comptabilite/v1/typeDeclarationTva")
public class TypeDeclarationTvaProvided {
    @GetMapping("/ref/{ref}")
    public TypeDeclarationTva findByRef(@PathVariable String ref) {
        return typeDeclarationTvaService.findByRef(ref);
    }

    @DeleteMapping("/ref/{ref}")
    public int deleteByRef(@PathVariable String ref) {
        return typeDeclarationTvaService.deleteByRef(ref);
    }

    @GetMapping("/libelle/{libelle}")
    public TypeDeclarationTva findByLibelle(@PathVariable String libelle) {
        return typeDeclarationTvaService.findByLibelle(libelle);
    }

    @PostMapping("/")
    public int save(@RequestBody TypeDeclarationTva typeDeclarationTva) {
        return typeDeclarationTvaService.save(typeDeclarationTva);
    }

    @GetMapping("/")
    public List<TypeDeclarationTva> findAll() {
        return typeDeclarationTvaService.findAll();
    }

    @Autowired
    private TypeDeclarationTvaService typeDeclarationTvaService;
}
