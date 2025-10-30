package com.product.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.product.config.jwt.JwtAuthFilter;

/**
 * Clase de configuración de seguridad para la aplicación.
 * Define las reglas de seguridad, los filtros y los manejadores de autenticación.
 * 
 * @author Martínez Marcelo Ingrid Aylen
 *         Pérez Evaristo Eris
 *         Ramírez Venegas Alexa Paola
 */
@Configuration
public class SecurityConfig {

    @Autowired
	private JwtAuthFilter jwtFilter;
	
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http, CorsConfig corsConfig) throws Exception {
	
		http.csrf(AbstractHttpConfigurer::disable)
		.authorizeHttpRequests(
				auth -> auth
				.requestMatchers("/error", "/swagger-ui/**", "/v3/api-docs/**", "/actuator/info", "/actuator/health")
				.permitAll()
                // Category
				.requestMatchers(HttpMethod.GET, "/category/active").hasAnyAuthority("ADMIN", "CUSTOMER")
                .requestMatchers("/category/**").hasAuthority("ADMIN")
				// Implementación en la proxima práctica
                // Product
                .requestMatchers(HttpMethod.GET, "/product/*").hasAnyAuthority("ADMIN", "CUSTOMER")
				.requestMatchers("/product/**").hasAuthority("ADMIN")
                // Product-images
                .requestMatchers("/product-image/**")
				.hasAnyAuthority("ADMIN", "CUSTOMER")
				)
		.cors(cors -> cors.configurationSource(corsConfig))
		.httpBasic(Customizer.withDefaults())
		.formLogin(form -> form.disable())
		.sessionManagement(httpSecuritySessionManagementConfigurer -> httpSecuritySessionManagementConfigurer.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
		.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
			
		return http.build();
	}
}
