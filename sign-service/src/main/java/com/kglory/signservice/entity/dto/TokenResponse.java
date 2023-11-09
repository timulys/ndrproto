package com.kglory.signservice.entity.dto;

import lombok.*;

/**
 * PackageName 	: com.kglory.signservice.entity.dto
 * FileName 	: SignResponse
 * Author 		: jhchoi
 * Date 		: 2023-08-23
 * Description 	:
 * ======================================================
 * DATE				    AUTHOR				NOTICE
 * ======================================================
 * 2023-08-23			jhchoi				최초 생성
 */
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class TokenResponse {
	private String accessToken;
	private String refreshToken;
}
