package com.kglory.ndrservice.domain.session;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

/**
 * PackageName 	: com.kglory.ndr.domain.session
 * FileName 	: SessionCapture
 * Author 		: jhchoi
 * Date 		: 2023-07-27
 * Description 	: Session Capture Count Domain for graph
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
@JsonIgnoreProperties(ignoreUnknown = true)
public class SessionCapture {
	private String captureDateTime;
	private Long captureCount;

	public static SessionCapture of(String captureDateTime, Long captureCount) {
		return SessionCapture.builder()
			.captureDateTime(captureDateTime)
			.captureCount(captureCount)
			.build();
	}
}
