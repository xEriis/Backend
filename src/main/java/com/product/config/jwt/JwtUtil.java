package com.product.config.jwt;

import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.function.Function;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

//import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureAlgorithm;

/**
 * Clase para generar y validar JSON Web Tokens (JWT) en la aplicación.
 * 
 * @author Carlos López Rodríguez
 */
@Component
public class JwtUtil {
    private static final String SECRET_KEY = "8J+YjvCfpJPwn5ic8J+YmvCfmI3wn6Ww8J+ZgvCfpKM="; 
    private static final SecretKey secretKey = new SecretKeySpec(Base64.getDecoder().decode(SECRET_KEY), "HmacSHA256");
    

    // public String generateToken(Usuario usuario) {
    	
    //     return Jwts.builder()
    //     		.claim("id", usuario.getId())
    //     		.claim("email", usuario.getCorreo())
    //     		.claim("roles", usuario.getAuthorities())
    //     		.setIssuer("http://localhost:8080")
    //     		.setSubject(usuario.getUsername())
    //             .setAudience("http://localhost:8080")
    //             .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60))
    //             .setIssuedAt(new Date())
    //             .signWith(secretKey, SignatureAlgorithm.HS256)
    //             .compact();
    // }

    /**
     * Método que extrae todos los claims de un token JWT.
     * 
     * @param token El JWT a procesar.
     * @return Los claims contenidos en el token.
     */
    public Claims extractClaims(String token) {
    	
    	JwtParser jwtParser = Jwts.parserBuilder()
    			.setSigningKey(secretKey)
    			.build();
    	
    	return jwtParser.parseClaimsJws(token).getBody();
    	
    }

    /**
     * Método que extrae el nombre de usuario (subject) de un token JWT.
     * 
     * @param token El JWT a procesar.
     * @return El nombre de usuario contenido en el token.
     */
    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    /**
     * Método que extrae los roles/permisos del token JWT.
     * 
     * @param token El JWT a procesar.
     * @return Una lista de roles representados como HashMaps.
     */
	@SuppressWarnings("unchecked")
	public List<HashMap<String, String>> extractPermisos(String token) {
         return extractClaims(token).get("roles", List.class);
    }

    /**
     * Método que valida si un token JWT es válido para un nombre de usuario dado
     * y si no ha expirado.
     * 
     * @param token    El JWT a validar.
     * @param username El nombre de usuario esperado.
     * @return true si el token es válido y pertenece al usuario, false en caso
     *         contrario.
     */
    public boolean isTokenValid(String token, String username) {
        return extractUsername(token).equals(username) && !isTokenExpired(token);
    }

    /**
     * Método que comprueba si un token JWT ha expirado.
     * 
     * @param token El JWT a evaluar.
     * @return true si el token ha expirado, false en caso contrario.
     */
    private boolean isTokenExpired(String token) {
        return extractClaim(token, Claims::getExpiration).before(new Date());
    }

    /**
     * Método que extrae un claim específico de un token JWT usando un resolver.
     * 
     * @param <T>            El tipo del claim.
     * @param token          El JWT a procesar.
     * @param claimsResolver Función que obtiene el claim deseado.
     * @return El claim extraído.
     */
    private <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        return claimsResolver.apply(extractClaims(token));
    }
}
