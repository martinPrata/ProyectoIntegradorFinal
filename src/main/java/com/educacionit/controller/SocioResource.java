package com.educacionit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.educacionit.service.SocioService;
import com.educacionit.dto.SocioDTO;

import java.util.List;

@RestController
@RequestMapping("/socios")
public class SocioResource {

    @Autowired
    private SocioService socioService;

    @GetMapping
    public List<SocioDTO> getAllSocios() {
        return socioService.getAllSocios();
    }

    @GetMapping("/{id}")
    public SocioDTO getSocioById(@PathVariable Long id) {
        return socioService.getSocioById(id);
    }

    @PostMapping
    public SocioDTO createSocio(@RequestBody SocioDTO socioDTO) {
        return socioService.createSocio(socioDTO);
    }

    @PutMapping("/{id}")
    public SocioDTO updateSocio(@PathVariable Long id, @RequestBody SocioDTO socioDTO) {
        return socioService.updateSocio(id, socioDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteSocio(@PathVariable Long id) {
        socioService.deleteSocio(id);
    }
}
