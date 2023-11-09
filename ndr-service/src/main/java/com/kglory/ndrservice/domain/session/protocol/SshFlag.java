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
 * FileName 	: SshFlag
 * Author 		: jhchoi
 * Date 		: 2023-08-09
 * Description 	: SSH Flag Domain
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
public class SshFlag {
	@JsonAlias("hasshCnt")
	private Integer haSshCount;
	@JsonAlias("hassh")
	private String[] haSshs;
	@JsonAlias("hasshServerCnt")
	private Integer haSshServerCount;
	@JsonAlias("hasshServer")
	private String[] haSshServers;
	@JsonAlias("keyCnt")
	private Integer keyCount;
	@JsonAlias("key")
	private String[] keys;
	@JsonAlias("versionCnt")
	private Integer versionCount;
	@JsonAlias("version")
	private String[] versions;
}
