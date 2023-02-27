/**
 * 
 */
package com.ibm.jwt.service;

import com.ibm.jwt.model.JwtUser;

/**
 * @author 003F0X744
 *
 */
public interface JwtTokenService {
	
    String generateToken(JwtUser jwtUser);
    
    boolean validateToken(String token);
 
    void invalidateToken(String token);

}
