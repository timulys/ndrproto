package com.kglory.ndrservice.utils.exception;

import com.kglory.ndrservice.utils.exception.code.ErrorCode;
import lombok.Getter;

/**
 * PackageName 	: com.kglory.ndrservice.utils.exception
 * FileName 	: NdrException
 * Author 		: jhchoi
 * Date 		: 2023-08-24
 * Description 	:
 * ======================================================
 * DATE				    AUTHOR				NOTICE
 * ======================================================
 * 2023-08-24			jhchoi				최초 생성
 */
@Getter
public class NdrException extends RuntimeException{
	//
	private final ErrorCode errorCode;

	public NdrException(ErrorCode errorCode) {
		super(errorCode.getMessage());
		this.errorCode = errorCode;
	}
}
