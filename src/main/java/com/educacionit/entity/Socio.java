package com.educacionit.entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "SOCIOS")
public class Socio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String apellido;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaAlta;

    @Column(nullable = false)
    private Boolean activo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Date getFechaAlta() {
        return fechaAlta != null ? new Date(fechaAlta.getTime()) : null;
    }

    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta != null ? new Date(fechaAlta.getTime()) : null;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }
}
