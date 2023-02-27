/**
 * 
 */
package com.ibm.jwt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.jwt.model.JwtTokenRequest;
import com.ibm.jwt.model.JwtTokenResponse;
import com.ibm.jwt.model.JwtUser;
import com.ibm.jwt.service.JwtTokenService;

/**
 * @author 003F0X744
 *
 */
@RestController
@RequestMapping("/token")
public class TokenController {

	@Autowired
	private JwtTokenService jwtTokenService;

	@PostMapping("/generate")
	public ResponseEntity<?> generateToken(@RequestBody JwtUser jwtUser) {
		final String token = jwtTokenService.generateToken(jwtUser);
		return ResponseEntity.ok(new JwtTokenResponse(token));
	}

	@PostMapping("/validate")
	public ResponseEntity<?> validateToken(@RequestBody JwtTokenRequest jwtTokenRequest) {
		final String token = jwtTokenRequest.getToken();
		if (jwtTokenService.validateToken(token)) {
			return ResponseEntity.ok(new JwtTokenResponse(token));
		}
		return ResponseEntity.badRequest().build();
	}

	@PostMapping("/invalidate")
	public ResponseEntity<?> invalidateToken(@RequestBody JwtTokenRequest jwtTokenRequest) {
		final String token = jwtTokenRequest.getToken();
		jwtTokenService.invalidateToken(token);
		return ResponseEntity.ok().build();
	}

}
