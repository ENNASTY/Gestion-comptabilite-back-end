package com.fstg.gestioncomptabilite.ws;

import com.fstg.gestioncomptabilite.bean.TauxIS;
import com.fstg.gestioncomptabilite.service.TauxIrService;
import com.fstg.gestioncomptabilite.service.TauxIsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Gestion-comptabilite/v1/tauxIs")
public class TauxIsProvided {
    @GetMapping("/ref/{ref}")
    public TauxIS findByRef(@PathVariable String ref) {
        return tauxIsService.findByRef(ref);
    }

    @DeleteMapping("/ref/{ref}")
    @Transactional
    public int deleteByRef(@PathVariable String ref) {
        return tauxIsService.deleteByRef(ref);
    }

    @GetMapping("/")
    public List<TauxIS> findAll() {
        return tauxIsService.findAll();
    }

    @PostMapping("/")
    public TauxIS save(@RequestBody TauxIS tauxIS) {
        return tauxIsService.save(tauxIS);
    }


    @Autowired
    private TauxIsService tauxIsService;
}
