package com.fstg.gestioncomptabilite.ws;

import com.fstg.gestioncomptabilite.bean.TypeFacture;
import com.fstg.gestioncomptabilite.service.TypeFactureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Gestion-comptabilite/v1/typeFacture")
public class TypeFactureProvided {
    @GetMapping("/ref/{ref}")
    public TypeFacture findByRef(@PathVariable String ref) {
        return typeFactureService.findByRef(ref);
    }

    @DeleteMapping("/ref/{ref}")
    @Transactional
    public int deleteByRef(@PathVariable String ref) {
        return typeFactureService.deleteByRef(ref);
    }

    @GetMapping("/libelle/{libelle}")
    public TypeFacture findByLibelle(@PathVariable String libelle) {
        return typeFactureService.findByLibelle(libelle);
    }

    @GetMapping("/")
    public List<TypeFacture> findAll() {
        return typeFactureService.findAll();
    }

    @PostMapping("/")
    public int save(@RequestBody TypeFacture typeFacture) {
        return typeFactureService.save(typeFacture);
    }

    @Autowired
    private TypeFactureService typeFactureService;
}
