package com.kglory.gatewayservice.entity.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * PackageName 	: com.kglory.gatewayservice.entity.enums
 * FileName 	: HttpEnum
 * Author 		: jhchoi
 * Date 		: 2023-08-22
 * Description 	:
 * ======================================================
 * DATE				    AUTHOR				NOTICE
 * ======================================================
 * 2023-08-22			jhchoi				최초 생성
 */
@Getter
@RequiredArgsConstructor
public enum AuthCode {
	ACCESS("X-ACCESS-TOKEN"),
	REFRESH("X-REFRESH-TOKEN")
	;

	private final String type;
}
