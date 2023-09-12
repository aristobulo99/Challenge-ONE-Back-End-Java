package com.challenge.hotelAlura.services;

import java.util.List;

import com.challenge.hotelAlura.models.Huesped;

public interface IHuespedService {
	public List<Huesped> obtenerHuespedes();
	
	public Huesped guardar(Huesped huesped);
	
	public Huesped obtenerPorID(Integer id);
	
	public void eliminar(Integer id);
}
