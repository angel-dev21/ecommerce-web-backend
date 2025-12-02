package com.example.ecommerceweb.security.jwt;

import java.security.Key;
import java.util.Date;

import javax.crypto.SecretKey;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SignatureException;

@Component
public class JwtUtils {

	private static final Logger logger = LoggerFactory.getLogger(JwtUtils.class);

	@Value("${app.jwtSecret}")
	private String secretPass;
	@Value("${app.jwtExpirationMs}")
	private int expirationMs;

	public String createJwtTokenFromUsername(String username) {
		return Jwts.builder().subject(username).issuedAt(new Date())
				.expiration(new Date((new Date()).getTime() + expirationMs)).signWith(getKey()).compact();
	}

	public String getUsernameFromJwt(String token) {
		return Jwts.parser().verifyWith((SecretKey) getKey()).build().parseSignedClaims(token).getPayload()
				.getSubject();
	}

	public boolean validateJwtToken(String jwtAuthToken) {
		try {
			Jwts.parser().verifyWith((SecretKey) getKey()).build().parse(jwtAuthToken);
			return true;
		} catch (SignatureException e) {
			logger.error("Error signature Jwt.", e.getMessage());
		} catch (MalformedJwtException e) {
			logger.error("Error malformed Jwt.", e.getMessage());
		} catch (ExpiredJwtException e) {
			logger.error("Error expired Jwt.", e.getMessage());
		} catch (UnsupportedJwtException e) {
			logger.error("Error unsupported Jwt.", e.getMessage());
		} catch (IllegalArgumentException e) {
			logger.error("Error empty Jwt.", e.getMessage());
		}
		return false;
	}

	private Key getKey() {
		return Keys.hmacShaKeyFor(Decoders.BASE64.decode(secretPass));
	}

}
