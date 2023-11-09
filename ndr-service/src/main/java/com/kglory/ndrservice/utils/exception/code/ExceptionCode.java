package com.kglory.ndrservice.utils.exception.code;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

/**
 * PackageName 	: com.kglory.ndrservice.utils.exception.code
 * FileName 	: ExcetionCode
 * Author 		: jhchoi
 * Date 		: 2023-08-23
 * Description 	:
 * ======================================================
 * DATE				    AUTHOR				NOTICE
 * ======================================================
 * 2023-08-23			jhchoi				최초 생성
 */
@Getter
@RequiredArgsConstructor
public enum ExceptionCode implements ErrorCode {
	// Exception Codes
	INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "Internal server error...", HttpStatus.INTERNAL_SERVER_ERROR.value()),
	INTERNAL_IO_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "Internal Server IO Exception...", HttpStatus.INTERNAL_SERVER_ERROR.value()),
	RESOURCE_NOT_FOUND(HttpStatus.NOT_FOUND, "Resource not found...", HttpStatus.NO_CONTENT.value())
	;

	private final HttpStatus httpStatus;
	private final String message;
	private final int code;
}
