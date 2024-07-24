package com.educacionit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educacionit.entity.Socio;
import com.educacionit.service.SocioService;

@RestController
@RequestMapping("/socios")
public class SocioResource {

    @Autowired
    private SocioService socioService;

    @GetMapping
    public List<Socio> getAllSocios() {
        return socioService.getAllSocios();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Socio> getSocioById(@PathVariable Long id) {
        Socio socio = socioService.getSocioById(id);
        return ResponseEntity.ok(socio);
    }

    @PostMapping
    public Socio createSocio(@RequestBody Socio socio) {
        return socioService.createSocio(socio);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Socio> updateSocio(@PathVariable Long id, @RequestBody Socio socio) {
        Socio updatedSocio = socioService.updateSocio(id, socio);
        return ResponseEntity.ok(updatedSocio);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSocio(@PathVariable Long id) {
        socioService.deleteSocio(id);
        return ResponseEntity.noContent().build();
    }
}
