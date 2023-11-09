package com.kglory.gatewayservice.entity.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

/**
 * PackageName 	: com.kglory.gatewayservice.entity.dto
 * FileName 	: TokenResponse
 * Author 		: jhchoi
 * Date 		: 2023-08-21
 * Description 	: Normal & Refresh Token Delivery Response DTO
 * ======================================================
 * DATE				    AUTHOR				NOTICE
 * ======================================================
 * 2023-08-21			jhchoi				최초 생성
 */
@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class TokenResponse {
	private String accessToken;
	private String refreshToken;
}
