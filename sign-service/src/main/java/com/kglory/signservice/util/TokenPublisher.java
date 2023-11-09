package com.kglory.signservice.util;

import com.kglory.signservice.entity.dto.TokenResponse;
import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

/**
 * PackageName 	: com.kglory.signservice.util
 * FileName 	: TokenPublisher
 * Author 		: jhchoi
 * Date 		: 2023-08-22
 * Description 	: Access & Refresh Token Publisher
 * ======================================================
 * DATE				    AUTHOR				NOTICE
 * ======================================================
 * 2023-08-22			jhchoi				최초 생성
 */
@Component
public class TokenPublisher {
	// TODO : Access Token 전용 키와 Refresh Token 전용 키로 분리할 지 고민이 필요함.
	@Value("${spring.jwt.secretKey}")
	private String secretKey;
	private Key key;
	// Access token expire time : 5min
	private long accessTokenTime = 1000L * 60 * 5;
	// Refresh token expire time : 30min
	private long refreshTokenTime = 1000L * 60 * 30;

	/**
	 * 키 암호화
	 */
	@PostConstruct
	protected void init() {
		this.key = Keys.hmacShaKeyFor(Decoders.BASE64URL.decode(secretKey));
	}

	/**
	 * Token 생성(Access & Refresh)
	 * @param id
	 * @return
	 */
	public TokenResponse createToken(String id) {
		return TokenResponse.builder()
			.accessToken(publishToken(id, accessTokenTime))
			.refreshToken(publishToken(id, refreshTokenTime))
			.build();
	}

	/**
	 * Token 갱신(Access Token Only)
	 * @param id
	 * @return
	 */
	public TokenResponse updateToken(String id) {
		return TokenResponse.builder()
			.accessToken(publishToken(id, accessTokenTime))
			.build();
	}

	/**
	 * Token 검증 로직(Access & Refresh)
	 * @param token
	 * @return
	 */
	public String getAccountId(String token) {
		try {
			return Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token).getBody().getSubject();
		} catch (ExpiredJwtException e) {
			return e.getClaims().getSubject();
		}
	}

	/**
	 * Token 유효기간 확인(Access & Refresh)
	 * @param token
	 * @return
	 */
	public boolean isExpire(String token) {
		Jws<Claims> claims = Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token);
		return !claims.getBody().getExpiration().before(new Date());
	}

	private String publishToken(String id, long tokenTime) {
		Claims claims = Jwts.claims().setSubject(id);
		Date now = new Date();
		return Jwts.builder().setClaims(claims).setIssuedAt(now).
			setExpiration(new Date(now.getTime() + tokenTime)).signWith(key, SignatureAlgorithm.HS256).compact();
	}
}
