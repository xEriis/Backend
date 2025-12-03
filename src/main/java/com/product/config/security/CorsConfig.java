package com.product.config.security;

import java.util.Arrays;

import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

import jakarta.servlet.http.HttpServletRequest;

/**
 * Configuración de CORS (Cross-Origin Resource Sharing) para la aplicación.
 * Permite controlar las solicitudes de recursos entre diferentes orígenes.
 * 
 * @author Martínez Marcelo Ingrid Aylen
 *         Pérez Evaristo Eris
 *         Ramírez Venegas Alexa Paola
 */
@Component
public class CorsConfig  implements CorsConfigurationSource{
    @Override
	public CorsConfiguration getCorsConfiguration(HttpServletRequest request) {
		CorsConfiguration corsConfiguration = new CorsConfiguration();
		
		// Permitir solicitudes desde cualquier lugar
		corsConfiguration.setAllowedOriginPatterns(Arrays.asList("*"));
		// Permitir get, delete, post, put, patch
		corsConfiguration.setAllowedMethods(Arrays.asList(HttpMethod.GET.name(), HttpMethod.DELETE.name(), HttpMethod.POST.name(), HttpMethod.PUT.name(), HttpMethod.PATCH.name()));
		corsConfiguration.addAllowedHeader("*");
		
		return corsConfiguration;
	}
}
