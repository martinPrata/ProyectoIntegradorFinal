package com.educacionit.service;

import com.educacionit.entity.Orden;
import com.educacionit.repository.OrdenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrdenService {

    @Autowired
    private OrdenRepository ordenRepository;

    public List<Orden> getAllOrdenes() {
        return ordenRepository.findAll();
    }

    public Orden getOrdenById(Long id) {
        Optional<Orden> orden = ordenRepository.findById(id);
        return orden.orElse(null);
    }

    public Orden createOrden(Orden orden) {
        return ordenRepository.save(orden);
    }

    public Orden updateOrden(Long id, Orden orden) {
        if (ordenRepository.existsById(id)) {
            orden.setId(id);
            return ordenRepository.save(orden);
        }
        return null;
    }

    public void deleteOrden(Long id) {
        if (ordenRepository.existsById(id)) {
            ordenRepository.deleteById(id);
        }
    }
}
