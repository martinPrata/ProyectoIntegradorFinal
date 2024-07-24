package com.educacionit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.educacionit.entity.Socio;
import com.educacionit.exception.ResourceNotFoundException;
import com.educacionit.repository.SocioRepository;

@Service
public class SocioService {

    @Autowired
    private SocioRepository socioRepository;

    public List<Socio> getAllSocios() {
        return socioRepository.findAll();
    }

    public Page<Socio> getAllSocios(Pageable pageable) {
        return socioRepository.findAll(pageable);
    }

    public Socio getSocioById(Long id) {
        return socioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Socio no encontrado con id: " + id));
    }

    public Socio createSocio(Socio socio) {
        return socioRepository.save(socio);
    }
    
    public Socio updateSocio(Long id, Socio socio) {
        if (!socioRepository.existsById(id)) {
            throw new ResourceNotFoundException("Socio no encontrado con id: " + id);
        }
        socio.setId(id);
        return socioRepository.save(socio);
    }

    public void deleteSocio(Long id) {
        if (!socioRepository.existsById(id)) {
            throw new ResourceNotFoundException("Socio no encontrado con id: " + id);
        }
        socioRepository.deleteById(id);
    }
}
