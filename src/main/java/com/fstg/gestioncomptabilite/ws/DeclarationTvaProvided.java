package com.fstg.gestioncomptabilite.ws;

import com.fstg.gestioncomptabilite.bean.DeclarationTva;
import com.fstg.gestioncomptabilite.service.DeclarationIsService;
import com.fstg.gestioncomptabilite.service.DeclarationTvaService;
import com.fstg.gestioncomptabilite.vo.DeclarationTvaVo1;
import com.fstg.gestioncomptabilite.vo.DeclarationTvaVo2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Gestion-comptabilite/v1/declarationTva")
public class DeclarationTvaProvided {
    @GetMapping("/ref/{ref}")
    public DeclarationTva findByRef(@PathVariable String ref) {
        return declarationTvaService.findByRef(ref);
    }

    @DeleteMapping("/ref/{ref}")
    @Transactional
    public int deleteByRef(@PathVariable String ref) {
        return declarationTvaService.deleteByRef(ref);
    }

    @GetMapping("/annee/{annee}/mois/{mois}")
    public DeclarationTva findByAnneeAndMois(@PathVariable double annee, @PathVariable double mois) {
        return declarationTvaService.findByAnneeAndMois(annee, mois);
    }

    @GetMapping("/annee/{annee}/trim/{trim}")
    public DeclarationTva findByAnneeAndTrim(@PathVariable double annee, @PathVariable double trim) {
        return declarationTvaService.findByAnneeAndTrim(annee, trim);
    }

    @GetMapping("typeDeclarationTva/ref/{ref}")
    public List<DeclarationTva> findByTypeDeclarationTvaRef(@PathVariable String ref) {
        return declarationTvaService.findByTypeDeclarationTvaRef(ref);
    }

    @GetMapping("/")
    public List<DeclarationTva> findAll() {
        return declarationTvaService.findAll();
    }

    @PostMapping("/")
    public int save(@RequestBody DeclarationTva declarationTva) {
        return declarationTvaService.save(declarationTva);
    }
    @PostMapping("/calcultva")
    public DeclarationTvaVo2 calcultva(@RequestBody DeclarationTvaVo1 declarationTvaVo1) {
        return declarationTvaService.calcultva(declarationTvaVo1);
    }

    @Autowired
    private DeclarationTvaService declarationTvaService;
}
