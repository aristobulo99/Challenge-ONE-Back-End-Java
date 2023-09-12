package com.challenge.hotelAlura.models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity(name = "reservas")
public class Reservas implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer res_id;
	@Column(nullable = false)
	private Date res_fecha_entrada;
	@Column(nullable = false)
	private Date res_fecha_salida;
	@Column(nullable = false)
	private BigDecimal res_valor;
	@Column(nullable = false)
	private String res_forma_pago;
	@ManyToOne
	@JoinColumn(name = "huesped")
	private Huesped huesped;
	
	public Reservas() {
		super();
	}
	
	public Reservas(Integer res_id, Date res_fecha_entrada, Date res_fecha_salida, BigDecimal res_valor,
			String res_forma_pago, Huesped huesped) {
		super();
		this.res_id = res_id;
		this.res_fecha_entrada = res_fecha_entrada;
		this.res_fecha_salida = res_fecha_salida;
		this.res_valor = res_valor;
		this.res_forma_pago = res_forma_pago;
		this.huesped = huesped;
	}

	public Integer getRes_id() {
		return res_id;	
	}
	public void setRes_id(Integer res_id) {
		this.res_id = res_id;
	}
	public Date getRes_fecha_entrada() {
		return res_fecha_entrada;
	}
	public void setRes_fecha_entrada(Date res_fecha_entrada) {
		this.res_fecha_entrada = res_fecha_entrada;
	}
	public Date getRes_fecha_salida() {
		return res_fecha_salida;
	}
	public void setRes_fecha_salida(Date res_fecha_salida) {
		this.res_fecha_salida = res_fecha_salida;
	}
	public BigDecimal getRes_valor() {
		return res_valor;
	}
	public void setRes_valor(BigDecimal res_valor) {
		this.res_valor = res_valor;
	}
	public String getRes_forma_pago() {
		return res_forma_pago;
	}
	public void setRes_forma_pago(String res_forma_pago) {
		this.res_forma_pago = res_forma_pago;
	}
	public Huesped getHuesped() {
		return huesped;
	}
	public void setHuesped(Huesped huesped) {
		this.huesped = huesped;
	}
	
	
}
