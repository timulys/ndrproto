package com.kglory.ndrservice.domain.session.protocol;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * PackageName 	: com.kglory.ndr.domain.session.protocol
 * FileName 	: TlsFlag
 * Author 		: jhchoi
 * Date 		: 2023-07-31
 * Description 	:
 * ======================================================
 * DATE				    AUTHOR				NOTICE
 * ======================================================
 * 2023-07-31			jhchoi				최초 생성
 */
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class TlsFlag {
	@JsonAlias("cipherCnt")
	private Integer cipherCount;
	@JsonAlias("cipher")
	private String[] ciphers;
	@JsonAlias("dstSessionId")
	private String[] dstSessionIds;
	@JsonAlias("ja3Cnt")
	private Integer ja3Count;
	@JsonAlias("ja3")
	private String[] ja3;
	@JsonAlias("jas3Cnt")
	private Integer ja3sCount;
	@JsonAlias("ja3s")
	private String[] ja3s;
	@JsonAlias("srcSessionId")
	private String[] srcSessionIds;
	@JsonAlias("versionCount")
	private Integer versionCount;
	@JsonAlias("version")
	private String[] versions;
}
