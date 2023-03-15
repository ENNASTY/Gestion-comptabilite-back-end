package com.fstg.gestioncomptabilite.ws;

import com.fstg.gestioncomptabilite.bean.TauxIR;
import com.fstg.gestioncomptabilite.service.TauxIrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Gestion-comptabilite/App/TAUXIR")
public class TauxIrProvided {
    @GetMapping("/ref/{ref}")
    public TauxIR findByRef(@PathVariable String ref) {
        return tauxIrService.findByRef(ref);
    }

  @DeleteMapping("/ref/{ref}")
    public int deleteByRef(@PathVariable String ref) {
        return tauxIrService.deleteByRef(ref);
    }

    public List<TauxIR> findAll() {
        return tauxIrService.findAll();
    }
@PutMapping("/salaire/{salaire}")
    public double calculMontantIr(@RequestBody  double salaire) {
        return tauxIrService.calculMontantIr(salaire);
    }

    @Autowired
    private TauxIrService tauxIrService;
}
