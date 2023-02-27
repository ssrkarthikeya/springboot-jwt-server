/**
 * 
 */
package com.ibm.jwt.model;

/**
 * @author 003F0X744
 *
 */
public class JwtTokenResponse {

	private final String token;

	public JwtTokenResponse(String token) {
		this.token = token;
	}

	public String getToken() {
		return token;
	}

}
