package com.fstg.gestioncomptabilite.ws;

import com.fstg.gestioncomptabilite.bean.DeclarationIR;
import com.fstg.gestioncomptabilite.bean.DeclarationIS;
import com.fstg.gestioncomptabilite.service.DeclarationIrService;
import com.fstg.gestioncomptabilite.service.DeclarationIsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//yassine
@RestController
@RequestMapping("Gestion-comptabilite/v1/declarationIr")
public class DeclarationIrProvided {
    @Autowired
    private DeclarationIrService declarationIrService;

    @GetMapping("/ref/{ref}")
    public DeclarationIR findByRef(@PathVariable String ref) {
        return declarationIrService.findByRef(ref);
    }

    @DeleteMapping("/ref/{ref}")
    @Transactional
    public int deleteByRef(@PathVariable String ref) {
        return declarationIrService.deleteByRef(ref);
    }

    @GetMapping("/mois/{mois}/annee/{annee}")

    public DeclarationIR findByMoisAndAnnee(@PathVariable double mois, @PathVariable double annee) {
        return declarationIrService.findByMoisAndAnnee(mois, annee);
    }

    @DeleteMapping("/mois/{mois}/annee/{annee}")
    @Transactional
    public int deleteByMoisAndAnnee(@PathVariable double mois, @PathVariable double annee) {
        return declarationIrService.deleteByMoisAndAnnee(mois, annee);
    }

    @GetMapping("/annee/{annee}")

    public List<DeclarationIR> findByAnnee(@PathVariable double annee) {
        return declarationIrService.findByAnnee(annee);
    }

    @GetMapping("/")
    public List<DeclarationIR> findAll() {
        return declarationIrService.findAll();
    }

    @PostMapping("/")
    public int save(@RequestBody DeclarationIR declarationIR) {
        return declarationIrService.save(declarationIR);
    }
}
