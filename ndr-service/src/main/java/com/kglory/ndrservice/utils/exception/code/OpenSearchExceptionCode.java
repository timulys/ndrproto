package com.kglory.ndrservice.utils.exception.code;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

/**
 * PackageName 	: com.kglory.ndrservice.utils.exception.code
 * FileName 	: OpenSearchCode
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
public enum OpenSearchExceptionCode implements ErrorCode {
	// OpenSearch Exception Enumeration Codes
	OPENSEARCH_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "OpenSearch Server Error...", HttpStatus.INTERNAL_SERVER_ERROR.value())
	;

	private final HttpStatus httpStatus;
	private final String message;
	private final int code;
}
