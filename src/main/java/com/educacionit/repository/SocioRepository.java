package com.educacionit.repository;

import com.educacionit.entity.Socio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SocioRepository extends JpaRepository<Socio, Long> {
}
