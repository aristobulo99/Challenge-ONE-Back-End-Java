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

import com.challenge.hotelAlura.models.Huesped;
import com.challenge.hotelAlura.services.HuespedServiceImple;

@RestController
@RequestMapping("/huespedes")
public class HuespedController {
	
	@Autowired
	private HuespedServiceImple huespedServiceImple;
	
	@GetMapping("/huespedes")
	public ResponseEntity<List<Huesped>> obtenerReservas(){
		List<Huesped> newHuespede = new ArrayList<>();
		this.huespedServiceImple.obtenerHuespedes().forEach(valor -> {
			newHuespede.add(new Huesped(valor.getHue_id(), 
					valor.getHue_nom(), valor.getHue_ape(), 
					valor.getHue_fec_nac(), 
					valor.getHue_nacionalidad(), 
					valor.getHue_telf(), null)
					);
		});
		return ResponseEntity.ok(newHuespede);
	}
	
	@PostMapping("/añadir/huesped")
	public ResponseEntity<Huesped> añadirHuesped(@RequestBody Huesped huesped){
		Huesped nuevo_huesped = this.huespedServiceImple.guardar(huesped);
		return new ResponseEntity<>(nuevo_huesped, HttpStatus.CREATED);
	}
	
	@GetMapping("/huesped/{id}")
	public ResponseEntity<Huesped> obtenerHuespedPorID(@PathVariable Integer id){
		Huesped huespedPorId = this.huespedServiceImple.obtenerPorID(id);
		Huesped newHuespedPorId = new Huesped(huespedPorId.getHue_id(), 
				huespedPorId.getHue_nom(), 
				huespedPorId.getHue_ape(), 
				huespedPorId.getHue_fec_nac(),
				huespedPorId.getHue_nacionalidad(), 
				huespedPorId.getHue_telf(), null
		);
		return ResponseEntity.ok(newHuespedPorId);
	}
	
	@PutMapping("/modificar/huesped/{id}")
	public ResponseEntity<Huesped> actualizarDatosDelHuesped(@PathVariable Integer id, @RequestBody Huesped huesped){
		Huesped huespedPorId = this.huespedServiceImple.obtenerPorID(id);
		huespedPorId.setHue_nom(huesped.getHue_nom());
		huespedPorId.setHue_ape(huesped.getHue_ape());
		huespedPorId.setHue_fec_nac(huesped.getHue_fec_nac());
		huespedPorId.setHue_nacionalidad(huesped.getHue_nacionalidad());
		huespedPorId.setHue_telf(huesped.getHue_telf());
		
		Huesped huesped_update = this.huespedServiceImple.guardar(huespedPorId);
		Huesped newHuesped_update = new Huesped(huesped_update.getHue_id(), 
				huesped_update.getHue_nom(), 
				huesped_update.getHue_ape(), 
				huesped_update.getHue_fec_nac(),
				huesped_update.getHue_nacionalidad(), 
				huesped_update.getHue_telf(), null
		);
		return new ResponseEntity<>(newHuesped_update, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/delete/huesped/{id}")
	public ResponseEntity<HashMap<String, Boolean>> eliminarReserva(@PathVariable Integer id) {
		this.huespedServiceImple.eliminar(id);
		HashMap<String, Boolean> estadoDeHuespedEliminado = new HashMap<>();
		estadoDeHuespedEliminado.put("Eliminado", true);
		return ResponseEntity.ok(estadoDeHuespedEliminado);
	}

}
