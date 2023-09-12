package com.challenge.hotelAlura.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.challenge.hotelAlura.models.Reservas;
import com.challenge.hotelAlura.repository.ReservasRepository;

@Service
public class ReservasServicesImple implements IReservaService{
	@Autowired
	private ReservasRepository reservasRepository; 

	@Override
	public  List<Reservas> obtenerReservas() {
		return reservasRepository.findAll();
	}

	@Override
	public Reservas guardar(Reservas reserva) {
		return reservasRepository.save(reserva);
	}

	@Override
	public Reservas obtenerPorID(Integer id) {
		return reservasRepository.findById(id).orElse(null);
	}

	@Override
	public void eliminar(Integer id) {
		reservasRepository.deleteById(id);
	}
	
}
