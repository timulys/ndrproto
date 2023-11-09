package com.kglory.ndrservice.domain.session;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * PackageName 	: com.kglory.ndr.domain.session
 * FileName 	: ServerMessageBlock
 * Author 		: jhchoi
 * Date 		: 2023-08-09
 * Description 	:
 * ======================================================
 * DATE				    AUTHOR				NOTICE
 * ======================================================
 * 2023-08-09			jhchoi				최초 생성
 */
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ServerMessageBlock {
	@JsonAlias("filenameCnt")
	private Integer fileNameCount;
	@JsonAlias("filename")
	private String[] fileNames;
	@JsonAlias("host")
	private String host;	// FIXME : 타입 확인 필요
	@JsonAlias("osCnt")
	private Integer osCount;
	@JsonAlias("os")
	private String[] os;
	@JsonAlias("userCnt")
	private Integer userCount;
	@JsonAlias("user")
	private String[] users;
	@JsonAlias("versionCnt")
	private Integer versionCount;
	@JsonAlias("version")
	private String[] versions;
}
