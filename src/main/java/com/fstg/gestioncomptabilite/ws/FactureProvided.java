package com.fstg.gestioncomptabilite.ws;

import com.fstg.gestioncomptabilite.bean.Facture;
import com.fstg.gestioncomptabilite.service.FactureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("Gestion-comptabilite/App/FACTURE")
public class FactureProvided {
    @GetMapping("/ref/{ref}")
    public Facture findByRef(@PathVariable String ref) {
        return factureService.findByRef(ref);
    }

    @DeleteMapping("/ref/{ref}")
    @Transactional
    public int deleteByRef(@PathVariable String ref) {
        return factureService.deleteByRef(ref);
    }
@GetMapping("/annee/{annee}")
    public List<Facture> findByAnnee(@PathVariable double annee) {
        return factureService.findByAnnee(annee);
    }
@GetMapping("/annee/{annee}/mois/{mois}")
    public List<Facture> findByAnneeAndMois(@PathVariable double annee, @PathVariable double mois) {
        return factureService.findByAnneeAndMois(annee, mois);
    }
@GetMapping("/annee/{annee}/mois/{trim}")
    public List<Facture> findByAnneeAndTrim(@PathVariable double annee,@PathVariable  double trim) {
        return factureService.findByAnneeAndTrim(annee, trim);
    }
@GetMapping("/annee/{annee}/trim/{trim}/TypeFacture/ref/{ref}")
    public List<Facture> findByAnneeAndTrimAndTypeFactureRef(@PathVariable double annee, @PathVariable double trim, @PathVariable String ref) {
        return factureService.findByAnneeAndTrimAndTypeFactureRef(annee, trim, ref);
    }
@GetMapping("/annee/{annee}/mois/{mois}/TypeFacture/ref/{ref}")
    public List<Facture> findByAnneeAndMoisAndTypeFactureRef(@PathVariable double annee,@PathVariable  double mois,@PathVariable String ref) {
        return factureService.findByAnneeAndMoisAndTypeFactureRef(annee, mois, ref);
    }
@GetMapping("/annee/{annee}/TypeFacture/ref/{ref}")
    public List<Facture> findByAnneeAndTypeFactureRef(@PathVariable double annee,@PathVariable String ref) {
        return factureService.findByAnneeAndTypeFactureRef(annee, ref);
    }
@GetMapping("TypeFacture/{ref}/{ref}")
    public List<Facture> findByTypeFactureRef(@PathVariable String ref) {
        return factureService.findByTypeFactureRef(ref);
    }
@GetMapping("annee/{annee}/TypeFacture/libelle/{libelle}")
    public List<Facture> findByAnneeTypeFactureLibelle(@PathVariable double annee, @PathVariable String libelle) {
        return factureService.findByAnneeTypeFactureLibelle(annee, libelle);
    }
@GetMapping("/")
    public List<Facture> findAll() {
        return factureService.findAll();
    }


    @Autowired
    private FactureService factureService;
}
