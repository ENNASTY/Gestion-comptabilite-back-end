package com.fstg.gestioncomptabilite.ws;

import com.fstg.gestioncomptabilite.bean.TauxIR;
import com.fstg.gestioncomptabilite.service.TauxIrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Gestion-comptabilite/v1/tauxIr")
public class TauxIrProvided {
    @GetMapping("/ref/{ref}")
    public TauxIR findByRef(@PathVariable String ref) {
        return tauxIrService.findByRef(ref);
    }

    @DeleteMapping("/ref/{ref}")
    @Transactional
    public int deleteByRef(@PathVariable String ref) {
        return tauxIrService.deleteByRef(ref);
    }

    @GetMapping("/")
    public List<TauxIR> findAll() {
        return tauxIrService.findAll();
    }

    @PostMapping("/")
    public TauxIR save(@RequestBody TauxIR tauxIR) {
        return tauxIrService.save(tauxIR);
    }
    @Autowired
    private TauxIrService tauxIrService;
}
