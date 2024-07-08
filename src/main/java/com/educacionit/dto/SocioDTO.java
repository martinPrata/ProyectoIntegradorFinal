package com.educacionit.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

public class SocioDTO {

    private Long id;

    @NotNull(message = "El nombre es obligatorio")
    @Size(min = 1, max = 50, message = "El nombre debe tener entre 1 y 50 caracteres")
    private String nombre;

    @NotNull(message = "El apellido es obligatorio")
    @Size(min = 1, max = 50, message = "El apellido debe tener entre 1 y 50 caracteres")
    private String apellido;

    @NotNull(message = "La fecha de alta es obligatoria")
    private LocalDateTime fechaAlta;

    private boolean activo;

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

	public LocalDateTime getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(LocalDateTime fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

    
}
