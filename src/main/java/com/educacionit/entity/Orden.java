package com.educacionit.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Orden {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate fechaCreacion;

    @ManyToOne
    @JoinColumn(name = "socio_id")
    private Socio socio;

    @ManyToOne
    @JoinColumn(name = "estado_orden_id")
    private EstadoOrden estadoOrden;

    private double montoTotal;

    @ManyToOne
    @JoinColumn(name = "cupon_id")
    private Cupon cupon;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(LocalDate fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Socio getSocio() {
		return socio;
	}

	public void setSocio(Socio socio) {
		this.socio = socio;
	}

	public EstadoOrden getEstadoOrden() {
		return estadoOrden;
	}

	public void setEstadoOrden(EstadoOrden estadoOrden) {
		this.estadoOrden = estadoOrden;
	}

	public double getMontoTotal() {
		return montoTotal;
	}

	public void setMontoTotal(double montoTotal) {
		this.montoTotal = montoTotal;
	}

	public Cupon getCupon() {
		return cupon;
	}

	public void setCupon(Cupon cupon) {
		this.cupon = cupon;
	}

    
    
}
