package com.educacionit.dto;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

public class OrdenDTO {

    private Long id;

    @NotNull(message = "La fecha de creación es obligatoria")
    private LocalDateTime fechaCreacion;

    @NotNull(message = "El monto total es obligatorio")
    private Double montoTotal;

    @NotNull(message = "El socio es obligatorio")
    private Long socioId;

    @NotNull(message = "El estado de la orden es obligatorio")
    private Long estadoOrdenId;

    @NotNull(message = "El cupón es obligatorio")
    private Long cuponId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(LocalDateTime fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Double getMontoTotal() {
		return montoTotal;
	}

	public void setMontoTotal(Double montoTotal) {
		this.montoTotal = montoTotal;
	}

	public Long getSocioId() {
		return socioId;
	}

	public void setSocioId(Long socioId) {
		this.socioId = socioId;
	}

	public Long getEstadoOrdenId() {
		return estadoOrdenId;
	}

	public void setEstadoOrdenId(Long estadoOrdenId) {
		this.estadoOrdenId = estadoOrdenId;
	}

	public Long getCuponId() {
		return cuponId;
	}

	public void setCuponId(Long cuponId) {
		this.cuponId = cuponId;
	}
    
    
    
}
