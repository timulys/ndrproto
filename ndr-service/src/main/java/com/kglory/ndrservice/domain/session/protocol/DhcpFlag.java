package com.kglory.ndrservice.domain.session.protocol;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * PackageName 	: com.kglory.ndr.domain.session.protocol
 * FileName 	: DhcpFlag
 * Author 		: jhchoi
 * Date 		: 2023-08-02
 * Description 	: DHCP Flag Domain
 * ======================================================
 * DATE				    AUTHOR				NOTICE
 * ======================================================
 * 2023-08-02			jhchoi				최초 생성
 */
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class DhcpFlag {
	@JsonAlias("host")
	private String[] hosts;
	@JsonAlias("hostCnt")
	private Integer hostCount;
	@JsonAlias("id")
	private String[] ids;
	@JsonAlias("idCnt")
	private Integer idCount;
	@JsonAlias("mac")
	private String[] macs;
	@JsonAlias("macCnt")
	private Integer macCount;
	@JsonAlias("oui")
	private String[] ouis;
	@JsonAlias("ouiCnt")
	private Integer ouiCount;
	@JsonAlias("type")
	private String[] types;
	@JsonAlias("typeCnt")
	private Integer typeCount;
}
