package com.kglory.ndrservice.domain.dto.session;

import lombok.*;

import java.time.LocalDateTime;
import java.time.ZoneId;

/**
 * PackageName 	: com.kglory.ndr.domain.dto
 * FileName 	: SessionDTO
 * Author 		: jhchoi
 * Date 		: 2023-07-19
 * Description 	:
 * ======================================================
 * DATE				    AUTHOR				NOTICE
 * ======================================================
 * 2023-07-19			jhchoi				최초 생성
 */
@Getter
@Builder(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class SessionRequest {
	// _id
	private String id;
	// network.community_id
	private String communityId;
	// startTime
	private String startTime;
	// stopTime
	private String stopTime;

	public static SessionRequest of(String id, String communityId, String searchTime) {
		return SessionRequest.builder()
			.id(id)
			.communityId(communityId)
			.startTime(String.valueOf(LocalDateTime.now().minusMinutes(Integer.parseInt(searchTime)).atZone(ZoneId.systemDefault()).toInstant().toEpochMilli()))
			.stopTime(String.valueOf(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant().toEpochMilli()))
			.build();
	}
}