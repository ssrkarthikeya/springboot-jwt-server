/**
 * 
 */
package com.ibm.jwt.model;

/**
 * @author 003F0X744
 *
 */
public class JwtTokenRequest {

	private String username;
	private String password;
	private String token;

	public JwtTokenRequest() {
	}

	public JwtTokenRequest(String username, String password, String token) {
		this.username = username;
		this.password = password;
		this.token = token;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the token
	 */
	public String getToken() {
		return token;
	}

}
