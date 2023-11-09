package com.kglory.ndrservice.utils;

import lombok.Getter;

/**
 * PackageName 	: com.kglory.ndrservice.utils
 * FileName 	: Constants
 * Author 		: jhchoi
 * Date 		: 2023-09-25
 * Description 	:
 * ======================================================
 * DATE				    AUTHOR				NOTICE
 * ======================================================
 * 2023-09-25			jhchoi				최초 생성
 */
public class Constants {
	// Exception Enum Class
	@Getter
	public enum ExceptionClass {

		PRODUCT("Product"), SIGN("Sign");

		private String exceptionClass;

		ExceptionClass(String exceptionClass) {
			this.exceptionClass = exceptionClass;
		}

		@Override
		public String toString() {
			return getExceptionClass() + " Exception. ";
		}
	}
}
