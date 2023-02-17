package com.ecommerce.security;

import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import com.ecommerce.auth.TokenAuthentication;
import com.ecommerce.dto.UsersData;
import com.ecommerce.utils.EShopApiException;

@Component
public class JwtTokenInterceptor implements HandlerInterceptor {
	@Autowired
	private TokenAuthentication auth;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		if (handler instanceof HandlerMethod) {
			HandlerMethod handlerMethod = (HandlerMethod) handler;
			Method method = handlerMethod.getMethod();
			if (method.getAnnotation(Authorize.class) != null) {
				String token = request.getHeader("Authorization");
				if (token == null || !token.startsWith("Bearer ")) {
					throw new EShopApiException(HttpStatus.INTERNAL_SERVER_ERROR, "Missing or Invalid Token");
				}
				token = token.substring(7);
				UsersData user = auth.getUserFromToken(token);
				if (user == null) {
					throw new EShopApiException(HttpStatus.INTERNAL_SERVER_ERROR, "Invalid Token");
				}
				request.setAttribute("username", user.getUserName());
				request.setAttribute("userid", user.getUserId());
			}

		}
		return true;
	}

}
