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
 * FileName 	: Kerberos
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
public class Kerberos {
	@JsonAlias("cnameCnt")
	private Integer cnameCount;
	@JsonAlias("cname")
	private String[] cnames;
	@JsonAlias("realmCnt")
	private Integer realmCount;
	@JsonAlias("realm")
	private String[] realms;
	@JsonAlias("snameCnt")
	private Integer snameCount;
	@JsonAlias("sname")
	private String[] snames;
}
