package com.kglory.ndrservice.utils.exception;

import com.kglory.ndrservice.utils.exception.code.ErrorCode;
import lombok.*;

/**
 * PackageName 	: com.kglory.ndrservice.utils.exception
 * FileName 	: ErrorResponse
 * Author 		: jhchoi
 * Date 		: 2023-08-23
 * Description 	:
 * ======================================================
 * DATE				    AUTHOR				NOTICE
 * ======================================================
 * 2023-08-23			jhchoi				최초 생성
 */
@Getter
@Builder(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ErrorResponse {
	private int code;
	private String message;

	public static ErrorResponse of(ErrorCode errorCode) {
		return ErrorResponse.builder()
			.code(errorCode.getHttpStatus().value())
			.message(errorCode.getMessage())
			.build();
	}
}
