package com.educacionit.controller;

import com.educacionit.entity.Orden;
import com.educacionit.service.OrdenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ordenes")
public class OrdenResource {

    @Autowired
    private OrdenService ordenService;

    @GetMapping
    public List<Orden> getAllOrdenes() {
        return ordenService.getAllOrdenes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Orden> getOrdenById(@PathVariable Long id) {
        Orden orden = ordenService.getOrdenById(id);
        if (orden == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(orden);
    }

    @PostMapping
    public Orden createOrden(@RequestBody Orden orden) {
        return ordenService.createOrden(orden);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Orden> updateOrden(@PathVariable Long id, @RequestBody Orden orden) {
        Orden updatedOrden = ordenService.updateOrden(id, orden);
        if (updatedOrden == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedOrden);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrden(@PathVariable Long id) {
        ordenService.deleteOrden(id);
        return ResponseEntity.noContent().build();
    }
}
