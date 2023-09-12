package com.challenge.hotelAlura.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.challenge.hotelAlura.models.Huesped;

@Repository
public interface HuespedRespository extends JpaRepository<Huesped, Integer>{

}
