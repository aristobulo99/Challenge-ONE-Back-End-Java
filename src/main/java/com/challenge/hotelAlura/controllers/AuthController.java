package com.challenge.hotelAlura.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.hotelAlura.models.Auth;

@RestController
@RequestMapping("/auth")
public class AuthController {
	
	@GetMapping
	public void pruebaGet() {
		
	}
	
	@PostMapping
	public Boolean inisiarSesion(@RequestBody Auth auth) {
		if((auth.getUsuario().equals("admin")) && (auth.getContraseña().equals("admin"))) {
			return true;
		}
		return false;
	}

}
