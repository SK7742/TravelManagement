package com.travelManagement.UserService.service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Service;

import ch.qos.logback.core.util.StringUtil;

@Service
public class TokenService {
	
	private final JwtEncoder jwtEncoder;
	public TokenService(JwtEncoder jwtEncoder) {
		this.jwtEncoder = jwtEncoder;
	}
	
	public String generateToken(Authentication authentication){
	    Instant now = Instant.now();
	    StringBuffer scope = new StringBuffer();
	    authentication.getAuthorities().forEach(
	    		authority -> {
	    			scope.append(authority.getAuthority()).append(" ");
	    		});
	    JwtClaimsSet claimsSet = JwtClaimsSet.builder()
	            .issuer("self")
	            .issuedAt(now)
	            .expiresAt(now.plus(1, ChronoUnit.HOURS))
	            .claim("scope", scope)
	            .build();
	    return this.jwtEncoder.encode(JwtEncoderParameters.from(claimsSet)).getTokenValue();
	}
}
