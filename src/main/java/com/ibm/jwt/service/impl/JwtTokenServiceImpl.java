/**
 * 
 */
package com.ibm.jwt.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.ibm.jwt.model.JwtUser;
import com.ibm.jwt.service.JwtTokenService;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

/**
 * @author 003F0X744
 *
 */
public class JwtTokenServiceImpl implements JwtTokenService {
	
	private static final String SECRET_KEY = "secret";

	private List<String> validTokens = new ArrayList<>();

	@Override
	public String generateToken(JwtUser jwtUser) {
		final Claims claims = Jwts.claims().setSubject(jwtUser.getUsername());
		claims.put("password", jwtUser.getPassword());
		final Date now = new Date();
		final Date expirationDate = new Date(now.getTime() + 3600 * 1000);
		final String token = Jwts.builder().setClaims(claims).setIssuedAt(now).setExpiration(expirationDate)
				.signWith(SignatureAlgorithm.HS256, SECRET_KEY).compact();
		validTokens.add(token);
		return token;
	}

	@Override
	public boolean validateToken(String token) {
		try {
			Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token);
			return validTokens.contains(token);
		} catch (JwtException | IllegalArgumentException e) {
			return false;
		}
	}

	@Override
	public void invalidateToken(String token) {
		validTokens.remove(token);
	}

}
