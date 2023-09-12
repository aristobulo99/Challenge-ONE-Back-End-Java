package com.challenge.hotelAlura.models;

import org.apache.catalina.filters.CorsFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class CorsConfig implements WebMvcConfigurer {

	 @Override
	    public void addCorsMappings(CorsRegistry registry) {
	        registry.addMapping("/**") // Permite todas las rutas
	                .allowedOrigins("*") // Permite todas las solicitudes desde cualquier origen (ajusta esto según tus necesidades)
	                .allowedMethods("GET", "POST", "PUT", "DELETE") // Permite los métodos HTTP que necesites
	                .allowedHeaders("*"); // Permite todos los encabezados
	    }
}