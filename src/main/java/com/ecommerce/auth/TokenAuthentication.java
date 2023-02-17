package com.ecommerce.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.ecommerce.dto.UserLoginResponse;
import com.ecommerce.dto.UsersData;
import com.ecommerce.service.UsersService;
import com.ecommerce.utils.EShopApiException;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.UnsupportedJwtException;

@Component
public class TokenAuthentication {

	private UsersService usersService;
	@Value("${app.jwt-secret}")
	private String secret;

	@Autowired
	private TokenAuthentication(UsersService usersService) {
		super();
		this.usersService = usersService;
	}

	public String createToken(UserLoginResponse user) {

		return Jwts.builder().setSubject(user.getUserName()).signWith(SignatureAlgorithm.HS512, secret).compact();
	}

	public String getUserNameFromToken(String token) {
		return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody().getSubject();
	}

	public UsersData getUserFromToken(String token) {
		final String username = getUserNameFromToken(token);
		return usersService.getByUserName(username);
	}

	public boolean validateToken(String token) {
		try

		{
			Jwts.parser().setSigningKey(secret).parse(token);
			return true;
		} catch (MalformedJwtException ex) {
			throw new EShopApiException(HttpStatus.BAD_REQUEST, "Invalid JWT token");
		} catch (UnsupportedJwtException ex) {
			throw new EShopApiException(HttpStatus.BAD_REQUEST, "Unsupported JWT token");
		} catch (IllegalArgumentException ex) {
			throw new EShopApiException(HttpStatus.BAD_REQUEST, "JWT claims string is empty.");
		}

	}
}
