package com.challenge.hotelAlura.services;

import java.util.List;

import com.challenge.hotelAlura.models.Reservas;

public interface IReservaService {
	
	public List<Reservas> obtenerReservas();
	
	public Reservas guardar(Reservas reserva);
	
	public Reservas obtenerPorID(Integer id);
	
	public void eliminar(Integer id);

}
