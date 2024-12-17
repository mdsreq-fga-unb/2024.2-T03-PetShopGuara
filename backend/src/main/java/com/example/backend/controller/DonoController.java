package com.example.backend.controller;

import com.example.backend.models.Dono;
import com.example.backend.service.DonoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/donos")
public class DonoController {

    @Autowired
    private DonoService donoService;

    @PostMapping("/cadastrar")
    public Dono cadastrarDono(@RequestBody Dono dono) {
        return donoService.cadastrarDono(dono);
    }

    @DeleteMapping("/cancelar/{id}")
    public void cancelarDono(@PathVariable Long id) {
        donoService.cancelarDono(id);
    }
}
