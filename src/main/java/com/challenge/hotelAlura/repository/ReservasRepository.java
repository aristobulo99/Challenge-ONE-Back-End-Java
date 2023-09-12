package com.challenge.hotelAlura.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.challenge.hotelAlura.models.Reservas;

@Repository
public interface ReservasRepository extends JpaRepository<Reservas, Integer>{
	
}
