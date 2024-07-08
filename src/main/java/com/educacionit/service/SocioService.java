package com.educacionit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educacionit.dto.SocioDTO;
import com.educacionit.entity.Socio;
import com.educacionit.repository.SocioRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SocioService {

    @Autowired
    private SocioRepository socioRepository;

    public List<SocioDTO> getAllSocios() {
        List<Socio> socios = socioRepository.findAll();
        return socios.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    public SocioDTO getSocioById(Long id) {
        Socio socio = socioRepository.findById(id).orElseThrow(() -> new RuntimeException("Socio not found"));
        return convertToDto(socio);
    }

    public SocioDTO createSocio(SocioDTO socioDTO) {
        Socio socio = convertToEntity(socioDTO);
        Socio savedSocio = socioRepository.save(socio);
        return convertToDto(savedSocio);
    }

    public SocioDTO updateSocio(Long id, SocioDTO socioDTO) {
        Socio socio = socioRepository.findById(id).orElseThrow(() -> new RuntimeException("Socio not found"));
        socio.setField1(socioDTO.getField1()); // Example field
        socio.setField2(socioDTO.getField2()); // Example field
        Socio updatedSocio = socioRepository.save(socio);
        return convertToDto(updatedSocio);
    }

    public void deleteSocio(Long id) {
        socioRepository.deleteById(id);
    }

    private SocioDTO convertToDto(Socio socio) {
        SocioDTO socioDTO = new SocioDTO();
        socioDTO.setId(socio.getId());
        socioDTO.setField1(socio.getField1());
        socioDTO.setField2(socio.getField2());
        return socioDTO;
    }

    private Socio convertToEntity(SocioDTO socioDTO) {
        Socio socio = new Socio();
        socio.setField1(socioDTO.getField1());
        socio.setField2(socioDTO.getField2());
        return socio;
    }
}
