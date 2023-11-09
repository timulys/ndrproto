package com.kglory.ndrservice.domain.session;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.kglory.ndrservice.utils.LongTimestampDeserializer;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * PackageName 	: com.kglory.ndr.domain.session
 * FileName 	: Cert
 * Author 		: jhchoi
 * Date 		: 2023-08-07
 * Description 	:
 * ======================================================
 * DATE				    AUTHOR				NOTICE
 * ======================================================
 * 2023-08-07			jhchoi				최초 생성
 */
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Cert {
	private String serial;
	private String curve;	// FIXME : 타입 확인 필요
	private String hash;
	private String publicAlgorithm;

	private Integer validDays;
	private Integer remainingDays;

	@JsonAlias("altCnt")
	private Integer altCount;
	@JsonAlias("alt")
	private String[] alts;

	private String[] issuerCN;
	private String[] subjectCN;
	private String[] issuerON;
	private String[] subjectON;
	private String[] issuerOU;
	private String[] subjectOU;

	@JsonAlias("notBefore")
	@JsonDeserialize(using = LongTimestampDeserializer.class)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime notBefore;

	@JsonAlias("notAfter")
	@JsonDeserialize(using = LongTimestampDeserializer.class)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime notAfter;
}
