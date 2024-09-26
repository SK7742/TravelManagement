package com.travelManagement.UserService.service.impl;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Service;

import com.travelManagement.UserService.model.User;

@Service
public class TokenServiceImpl {

	private final JwtEncoder jwtEncoder;

	public TokenServiceImpl(JwtEncoder jwtEncoder) {
		this.jwtEncoder = jwtEncoder;
	}

	public String generateToken(Authentication authentication) {
		Instant now = Instant.now();
		StringBuffer scope = new StringBuffer();
		authentication.getAuthorities().forEach(authority -> {
			scope.append(authority.getAuthority()).append(" ");
		});
		JwtClaimsSet claimsSet = JwtClaimsSet.builder().issuer("travelManagement").issuedAt(now)
				.expiresAt(now.plus(1, ChronoUnit.HOURS)).claim("scope", scope).build();
		return this.jwtEncoder.encode(JwtEncoderParameters.from(claimsSet)).getTokenValue();
	}
	
	public String generateToken(User user) {
		Instant now = Instant.now();
		JwtClaimsSet claimsSet = JwtClaimsSet.builder().issuer("self").issuedAt(now)
				.expiresAt(now.plus(1, ChronoUnit.HOURS)).claim("scope", "user").build();
		return this.jwtEncoder.encode(JwtEncoderParameters.from(claimsSet)).getTokenValue();
	}
}
