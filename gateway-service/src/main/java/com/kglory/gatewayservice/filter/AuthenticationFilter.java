package com.kglory.gatewayservice.filter;

import com.kglory.gatewayservice.entity.enums.AuthCode;
import com.kglory.gatewayservice.util.JwtUtil;
import io.jsonwebtoken.ExpiredJwtException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.stereotype.Component;

/**
 * PackageName 	: com.kglory.gatewayservice.filter
 * FileName 	: AuthenticationFilter
 * Author 		: jhchoi
 * Date 		: 2023-08-21
 * Description 	: Gateway Authentication Filter
 * ======================================================
 * DATE				    AUTHOR				NOTICE
 * ======================================================
 * 2023-08-21			jhchoi				최초 생성
 */
@Component
@Slf4j
public class AuthenticationFilter extends AbstractGatewayFilterFactory<AuthenticationFilter.Config> {
	private RouteValidator routeValidator;
	private JwtUtil jwtUtil;

	// Constructor DI
	public AuthenticationFilter(RouteValidator routeValidator, JwtUtil jwtUtil) {
		super(Config.class);
		this.routeValidator = routeValidator;
		this.jwtUtil = jwtUtil;
	}

	@Override
	public GatewayFilter apply(Config config) {
		return ((exchange, chain) -> {
			try {
				if (routeValidator.isSecured.test(exchange.getRequest())) {
					// Header contains access token or not
					String accessToken = "";
					if (exchange.getRequest().getHeaders().containsKey(AuthCode.ACCESS.getType())) {
						accessToken = exchange.getRequest().getHeaders().get(AuthCode.ACCESS.getType()).get(0);
					} else {
						accessToken = exchange.getRequest().getHeaders().get(AuthCode.REFRESH.getType()).get(0);
					}

					if (accessToken.isBlank()) {
						throw new RuntimeException("Missing authorization header.");
					}
					jwtUtil.validateToken(accessToken);
				}
			} catch (ExpiredJwtException e) {
				log.error("Invalid Refresh Token...", e.getLocalizedMessage());
				throw new RuntimeException("Unauthorized access to application.");
			}
			return chain.filter(exchange);
		});
	}

	/**
	 * Config Inner Class
	 */
	public static class Config {
	}
}
