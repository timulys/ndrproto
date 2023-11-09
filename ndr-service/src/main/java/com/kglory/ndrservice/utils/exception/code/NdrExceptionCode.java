package com.kglory.ndrservice.utils.exception.code;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

/**
 * PackageName 	: com.kglory.ndrservice.utils.exception.code
 * FileName 	: NdrExceptionCode
 * Author 		: jhchoi
 * Date 		: 2023-08-24
 * Description 	:
 * ======================================================
 * DATE				    AUTHOR				NOTICE
 * ======================================================
 * 2023-08-24			jhchoi				최초 생성
 */
@Getter
@RequiredArgsConstructor
public enum NdrExceptionCode implements ErrorCode {
	// NDR Exception Enumeration Codes
	NO_RECORD(HttpStatus.NO_CONTENT, "No Search Record...", HttpStatus.NO_CONTENT.value()),
	NO_SEARCH_DATA(HttpStatus.NOT_FOUND, "Not Found Data...", HttpStatus.NOT_FOUND.value())
	;

	private final HttpStatus httpStatus;
	private final String message;
	private final int code;
}
