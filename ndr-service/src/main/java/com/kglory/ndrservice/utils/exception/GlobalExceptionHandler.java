package com.kglory.ndrservice.utils.exception;

import com.kglory.ndrservice.utils.exception.code.ExceptionCode;
import com.kglory.ndrservice.utils.exception.code.OpenSearchExceptionCode;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.opensearch.client.opensearch._types.OpenSearchException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.io.IOException;

/**
 * PackageName 	: com.kglory.ndrservice.utils.exception
 * FileName 	: GlobalExceptionHandler
 * Author 		: jhchoi
 * Date 		: 2023-08-23
 * Description 	:
 * ======================================================
 * DATE				    AUTHOR				NOTICE
 * ======================================================
 * 2023-08-23			jhchoi				최초 생성
 */
@RestControllerAdvice
@RequiredArgsConstructor
@Slf4j
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
	// OpenSearch Exception Handlers
	@ExceptionHandler(OpenSearchException.class)
	protected ResponseEntity<ErrorResponse> handleOpenSearchException(OpenSearchException e) {
		log.error(e.getLocalizedMessage(), e);
		final ErrorResponse errorResponse = ErrorResponse.of(OpenSearchExceptionCode.OPENSEARCH_ERROR);
		return new ResponseEntity<>(errorResponse, OpenSearchExceptionCode.OPENSEARCH_ERROR.getHttpStatus());
	}

	// Exception Handlers
	@ExceptionHandler(NdrException.class)
	protected ResponseEntity<ErrorResponse> handleRuntimeException(NdrException e) {
		log.error(e.getLocalizedMessage());
		final ErrorResponse errorResponse = ErrorResponse.of(e.getErrorCode());
		return new ResponseEntity<>(errorResponse, e.getErrorCode().getHttpStatus());
	}

	@ExceptionHandler(NullPointerException.class)
	protected ResponseEntity<ErrorResponse> hendleNullPointerException(NullPointerException e) {
		log.error(e.getLocalizedMessage());
		final ErrorResponse errorResponse = ErrorResponse.of(ExceptionCode.RESOURCE_NOT_FOUND);
		return new ResponseEntity<>(errorResponse, ExceptionCode.RESOURCE_NOT_FOUND.getHttpStatus());
	}

	@ExceptionHandler(Exception.class)
	protected ResponseEntity<ErrorResponse> handleException(Exception e) {
		log.error(e.getLocalizedMessage(), e);
		final ErrorResponse errorResponse = ErrorResponse.of(ExceptionCode.INTERNAL_SERVER_ERROR);
		return new ResponseEntity<>(errorResponse, ExceptionCode.INTERNAL_SERVER_ERROR.getHttpStatus());
	}

	@ExceptionHandler(IOException.class)
	protected ResponseEntity<ErrorResponse> handleIOException(IOException e) {
		log.error(e.getLocalizedMessage(), e);
		final ErrorResponse errorResponse = ErrorResponse.of(ExceptionCode.INTERNAL_IO_ERROR);
		return new ResponseEntity<>(errorResponse, ExceptionCode.INTERNAL_IO_ERROR.getHttpStatus());
	}
}
