package com.kglory.ndrservice.domain.dto.session;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.util.List;

/**
 * PackageName 	: com.kglory.ndr.domain.dto.session
 * FileName 	: SessionResponse
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
public class SessionResponse {
	private List<SessionListResponse> sessions;
	private List<SessionAggResponse> sessionAggregations;

	public static SessionResponse of(List<SessionListResponse> sessions, List<SessionAggResponse> sessionAggregations) {
		return SessionResponse.builder()
			.sessions(sessions)
			.sessionAggregations(sessionAggregations)
			.build();
	}
}
