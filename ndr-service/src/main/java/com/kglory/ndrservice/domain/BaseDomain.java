package com.kglory.ndrservice.domain;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.kglory.ndrservice.utils.LongTimestampDeserializer;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * PackageName 	: com.kglory.ndr.domain.session
 * FileName 	: BaseDomain
 * Author 		: jhchoi
 * Date 		: 2023-07-24
 * Description 	:
 * ======================================================
 * DATE				    AUTHOR				NOTICE
 * ======================================================
 * 2023-07-24			jhchoi				최초 생성
 */
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BaseDomain {
	@JsonAlias("firstPacket")
	@JsonDeserialize(using = LongTimestampDeserializer.class)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime startTime;

	@JsonAlias("lastPacket")
	@JsonDeserialize(using = LongTimestampDeserializer.class)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime stopTime;
}