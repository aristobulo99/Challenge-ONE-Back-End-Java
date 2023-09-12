package com.challenge.hotelAlura.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.challenge.hotelAlura.models.Huesped;
import com.challenge.hotelAlura.repository.HuespedRespository;

@Service
public class HuespedServiceImple implements IHuespedService {
	
	@Autowired
	private HuespedRespository huespedRepository;

	@Override
	public List<Huesped> obtenerHuespedes() {
		return this.huespedRepository.findAll();
	}

	@Override
	public Huesped guardar(Huesped huesped) {
		return this.huespedRepository.save(huesped);
	}

	@Override
	public Huesped obtenerPorID(Integer id) {
		return this.huespedRepository.findById(id).orElse(null);
	}

	@Override
	public void eliminar(Integer id) {
		this.huespedRepository.deleteById(id);
	}

}
