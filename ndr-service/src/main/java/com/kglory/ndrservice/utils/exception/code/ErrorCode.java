package com.kglory.ndrservice.utils.exception.code;

import org.springframework.http.HttpStatus;

/**
 * PackageName 	: com.kglory.ndrservice.utils.exception.code
 * FileName 	: ErrorCode
 * Author 		: jhchoi
 * Date 		: 2023-08-23
 * Description 	:
 * ======================================================
 * DATE				    AUTHOR				NOTICE
 * ======================================================
 * 2023-08-23			jhchoi				최초 생성
 */
public interface ErrorCode {
	HttpStatus getHttpStatus();
	String getMessage();
}
