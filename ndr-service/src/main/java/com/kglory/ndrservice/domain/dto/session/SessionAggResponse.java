package com.kglory.ndrservice.domain.dto.session;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

/**
 * PackageName 	: com.kglory.ndr.domain.dto.session
 * FileName 	: SessionAggResponse
 * Author 		: jhchoi
 * Date 		: 2023-07-27
 * Description 	:
 * ======================================================
 * DATE				    AUTHOR				NOTICE
 * ======================================================
 * 2023-07-27			jhchoi				최초 생성
 */
@Getter
@Builder(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class SessionAggResponse {
	private String captureDateTime;
	private Long captureCount;

	public static SessionAggResponse of(String captureDateTime, Long captureCount) {
		return SessionAggResponse.builder()
			.captureDateTime(captureDateTime)
			.captureCount(captureCount)
			.build();
	}
}
