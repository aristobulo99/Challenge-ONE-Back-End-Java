package com.challenge.hotelAlura.models;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity(name = "huesped")
public class Huesped implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer hue_id;
	@Column(nullable = false)
	private String hue_nom;
	@Column(nullable = false)
	private String hue_ape;
	@Column(nullable = false)
	private Date hue_fec_nac;
	@Column(nullable = false)
	private String hue_nacionalidad;
	@Column(nullable = false)
	private String hue_telf;
	@OneToMany(mappedBy = "huesped", cascade = CascadeType.ALL)
	private List<Reservas> reservas;
	
	public Huesped() {
		super();
	}

	public Huesped(Integer hue_id, String hue_nom, String hue_ape, Date hue_fec_nac, String hue_nacionalidad,
			String hue_telf, List<Reservas> reservas) {
		super();
		this.hue_id = hue_id;
		this.hue_nom = hue_nom;
		this.hue_ape = hue_ape;
		this.hue_fec_nac = hue_fec_nac;
		this.hue_nacionalidad = hue_nacionalidad;
		this.hue_telf = hue_telf;
		this.reservas = reservas;
	}

	public Integer getHue_id() {
		return hue_id;
	}
	public void setHue_id(Integer hue_id) {
		this.hue_id = hue_id;
	}
	public String getHue_nom() {
		return hue_nom;
	}
	public void setHue_nom(String hue_nom) {
		this.hue_nom = hue_nom;
	}
	public String getHue_ape() {
		return hue_ape;
	}
	public void setHue_ape(String hue_ape) {
		this.hue_ape = hue_ape;
	}
	public Date getHue_fec_nac() {
		return hue_fec_nac;
	}
	public void setHue_fec_nac(Date hue_fec_nac) {
		this.hue_fec_nac = hue_fec_nac;
	}
	public String getHue_nacionalidad() {
		return hue_nacionalidad;
	}
	public void setHue_nacionalidad(String hue_nacionalidad) {
		this.hue_nacionalidad = hue_nacionalidad;
	}
	public String getHue_telf() {
		return hue_telf;
	}
	public void setHue_telf(String hue_telf) {
		this.hue_telf = hue_telf;
	}
	public List<Reservas> getReservas() {
		return reservas;
	}
	public void setReservas(List<Reservas> reservas) {
		this.reservas = reservas;
	}
	
	
}
