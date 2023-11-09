package com.kglory.gatewayservice.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * PackageName 	: com.kglory.gatewayservice.util
 * FileName 	: JwtUtil
 * Author 		: jhchoi
 * Date 		: 2023-08-21
 * Description 	: Gateway JWT Validation Util
 * ======================================================
 * DATE				    AUTHOR				NOTICE
 * ======================================================
 * 2023-08-21			jhchoi				최초 생성
 */
@Component
public class JwtUtil {
	/**
	 * Secret Key
	 */
	public static final String KEY = "secretkeysecretkeysecretkeysecretkeysecretkeysecretkeysecretkeysecretkeysecretkey";

	/**
	 * Access / Refresh Token Validation method
	 * @param token
	 * @return boolean
	 */
	public boolean validateToken(final String token) {
		Jws<Claims> claims = Jwts.parserBuilder().setSigningKey(Keys.hmacShaKeyFor(Decoders.BASE64.decode(KEY)))
			.build().parseClaimsJws(token);
		// TODO : Refresh일 경우 만료 시간이 5분 미만으로 남았다면 재발급 받는 로직 추가할 것
		return claims.getBody().getExpiration().before(new Date());
	}
}
