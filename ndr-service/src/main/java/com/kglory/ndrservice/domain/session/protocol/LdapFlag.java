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
 * FileName 	: LdapFlag
 * Author 		: jhchoi
 * Date 		: 2023-08-02
 * Description 	: LDAP Flag Domain
 * ======================================================
 * DATE				    AUTHOR				NOTICE
 * ======================================================
 * 2023-08-02			jhchoi				최초 생성
 */
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class LdapFlag {
	@JsonAlias("authCnt")
	private Integer authCount;
	@JsonAlias("authtype")
	private String[] authTypes;
	@JsonAlias("bindnameCnt")
	private Integer bindNameCount;
	@JsonAlias("bindname")
	private String[] bindNames;
}
