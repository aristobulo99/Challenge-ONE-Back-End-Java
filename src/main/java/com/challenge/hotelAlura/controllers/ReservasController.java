package com.challenge.hotelAlura.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.hotelAlura.models.Reservas;
import com.challenge.hotelAlura.services.ReservasServicesImple;

@RestController
@RequestMapping("/reservas/hotel/alura")
public class ReservasController {
	
	@Autowired
	private ReservasServicesImple reservasServicesImple;
	
	@GetMapping("/reservas")
	public ResponseEntity<?> obtenerReservas(){
		System.out.println("controlador reservas");
		try {
			List<Reservas> newReservas = new ArrayList<>();
	        reservasServicesImple.obtenerReservas().forEach(reserva -> {
	        	newReservas.add(
	        			new Reservas(reserva.getRes_id(), 
	        					reserva.getRes_fecha_entrada(), 
	        					reserva.getRes_fecha_salida(), 
	        					reserva.getRes_valor(), 
	        					reserva.getRes_forma_pago(), null)
	        	);
	        });
	        return ResponseEntity.ok(newReservas);
	    } catch (RuntimeException e) {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
	    }
	}
	
	@PostMapping("/guardarReserva")
	public ResponseEntity<Reservas> guardarReserva(@RequestBody Reservas reserva){
		
		System.out.println(reserva.getRes_valor()+ " " + reserva.getRes_forma_pago() + " " + reserva.getHuesped());
		Reservas nueva_reserva = reservasServicesImple.guardar(reserva);
		return new ResponseEntity<>(nueva_reserva, HttpStatus.CREATED);
	}
	
	@GetMapping("/reserva/{id}")
	public ResponseEntity<Reservas> obtenerReservaPorID(@PathVariable Integer id){
		Reservas reservaPorId = reservasServicesImple.obtenerPorID(id);
		Reservas newreservaPorId = new Reservas(reservaPorId.getRes_id(), 
				reservaPorId.getRes_fecha_entrada(), 
				reservaPorId.getRes_fecha_salida(), 
				reservaPorId.getRes_valor(), 
				reservaPorId.getRes_forma_pago(), null);
		return ResponseEntity.ok(newreservaPorId);
	}
	
	@PutMapping("/modificar/reserva/{id}")
	public ResponseEntity<Reservas> actualizarReserva(@PathVariable Integer id, @RequestBody Reservas reserva){
		Reservas reservaPorId = reservasServicesImple.obtenerPorID(id);
		reservaPorId.setRes_fecha_entrada(reserva.getRes_fecha_entrada());
		reservaPorId.setRes_fecha_salida(reserva.getRes_fecha_salida());
		reservaPorId.setRes_valor(reserva.getRes_valor());
		reservaPorId.setRes_forma_pago(reserva.getRes_forma_pago());
		
		Reservas reserva_update = reservasServicesImple.guardar(reservaPorId);
		Reservas newReserva_update = new Reservas(reserva_update.getRes_id(), 
				reserva_update.getRes_fecha_entrada(), 
				reserva_update.getRes_fecha_salida(), 
				reserva_update.getRes_valor(), 
				reserva_update.getRes_forma_pago(), null);
		return new ResponseEntity<>(newReserva_update, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/delete/reserva/{id}")
	public ResponseEntity<HashMap<String, Boolean>> eliminarReserva(@PathVariable Integer id) {
		this.reservasServicesImple.eliminar(id);
		HashMap<String, Boolean> estadoDeReservaEliminada = new HashMap<>();
		estadoDeReservaEliminada.put("Eliminado", true);
		return ResponseEntity.ok(estadoDeReservaEliminada);
	}
}
