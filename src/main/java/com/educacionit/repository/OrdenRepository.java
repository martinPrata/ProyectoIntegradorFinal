package com.educacionit.repository;

import com.educacionit.entity.Orden;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdenRepository extends JpaRepository<Orden, Long> {
}
