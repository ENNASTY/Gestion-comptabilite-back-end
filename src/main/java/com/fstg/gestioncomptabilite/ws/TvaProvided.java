package com.fstg.gestioncomptabilite.ws;

import com.fstg.gestioncomptabilite.bean.Tva;
import com.fstg.gestioncomptabilite.service.TvaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Gestion-comptabilite/App/TVA")
public class TvaProvided {
    @GetMapping("/ref/{ref}")
    public Tva findByRef(@PathVariable String ref) {
        return tvaService.findByRef(ref);
    }

    @DeleteMapping("/ref/{ref}")
    public int deleteByRef(@PathVariable String ref) {
        return tvaService.deleteByRef(ref);
    }
@GetMapping("/")
    public List<Tva> findAll() {
        return tvaService.findAll();
    }
@PostMapping("/")
    public int save(@RequestBody Tva tva) {
        return tvaService.save(tva);
    }

    @Autowired
    private TvaService tvaService;
}
