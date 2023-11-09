package com.kglory.ndrservice.domain.session.protocol;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * PackageName 	: com.kglory.ndr.domain.session.protocol
 * FileName 	: SnmpFlag
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
public class SnmpFlag {
	@JsonAlias("community")
	private String[] communities;
	@JsonAlias("communityCnt")
	private Integer communityCount;
	@JsonAlias("error")
	private String[] error;
	@JsonAlias("errorCnt")
	private Integer errorCount;
	@JsonAlias("type")
	private String[] types;
	@JsonAlias("typeCnt")
	private Integer typeCount;
	@JsonAlias("variable")
	private List<String> variables;
	@JsonAlias("variableCnt")
	private Integer variableCount;
	@JsonAlias("version")
	private String[] versions;
	@JsonAlias("versionCnt")
	private Integer versionCount;
}
