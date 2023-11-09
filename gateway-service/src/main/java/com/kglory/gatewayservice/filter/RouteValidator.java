package com.kglory.gatewayservice.filter;

import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Predicate;

/**
 * PackageName 	: com.kglory.gatewayservice.filter
 * FileName 	: RouteValidator
 * Author 		: jhchoi
 * Date 		: 2023-08-21
 * Description 	: Gateway Route Validator
 * ======================================================
 * DATE				    AUTHOR				NOTICE
 * ======================================================
 * 2023-08-21			jhchoi				최초 생성
 */
@Component
public class RouteValidator {
	/**
	 * API Endpoint URI List
	 */
	public static final List<String> openApiUris = List.of(
		"/sign/token",
		"/eureka"
	);

	public Predicate<ServerHttpRequest> isSecured =
		request -> openApiUris.stream().noneMatch(uri -> request.getURI().getPath().contains(uri));
}
