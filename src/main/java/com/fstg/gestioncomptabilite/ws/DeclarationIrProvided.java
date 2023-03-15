package com.fstg.gestioncomptabilite.ws;

import com.fstg.gestioncomptabilite.bean.DeclarationIS;
import com.fstg.gestioncomptabilite.service.DeclarationIsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//yassine
@RestController
@RequestMapping("Gestion-comptabilite/App/IR")
public class DeclarationIrProvided {
    @GetMapping("/annee/{annee}")
    public DeclarationIS findByAnnee(@PathVariable  double annee) {
        return declarationIsService.findByAnnee(annee);
    }

   @DeleteMapping("/annee/{annee}")
   @Transactional
    public int deleteByAnnee(@PathVariable double annee) {
        return declarationIsService.deleteByAnnee(annee);
    }
@GetMapping("/")
    public List<DeclarationIS> findAll() {
        return declarationIsService.findAll();
    }
@PostMapping("/")
    public int save(@RequestBody  DeclarationIS declarationIS) {
        return declarationIsService.save(declarationIS);
    }

    @Autowired
    private DeclarationIsService declarationIsService;
}
