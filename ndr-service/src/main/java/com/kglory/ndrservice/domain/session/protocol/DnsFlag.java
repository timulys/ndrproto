package com.kglory.ndrservice.domain.session.protocol;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * PackageName 	: com.kglory.ndr.domain.session
 * FileName 	: Dns
 * Author 		: jhchoi
 * Date 		: 2023-08-01
 * Description 	:
 * ======================================================
 * DATE				    AUTHOR				NOTICE
 * ======================================================
 * 2023-08-01			jhchoi				최초 생성
 */
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@JsonIgnoreProperties(ignoreUnknown = true)
public class DnsFlag {
	@JsonAlias("host")
	private String[] hosts;
	@JsonAlias("hostCnt")
	private Integer hostCount;

	@JsonAlias("ip")
	private String[] ips;
	@JsonAlias("ipCnt")
	private Integer ipCount;

	@JsonAlias("opcode")
	private String[] opCode;
	@JsonAlias("opcodeCnt")
	private Integer opCodeCount;

	@JsonAlias("puny")
	private String[] punyCodes;
	@JsonAlias("punyCnt")
	private String punyCount;

	@JsonAlias("qc")
	private String[] queries;
	@JsonAlias("qcCnt")
	private Integer queryString;

	@JsonAlias("qt")
	private String[] queryTypes;
	@JsonAlias("qtCnt")
	private Integer queryType;

	@JsonAlias("status")
	private String[] status;
	@JsonAlias("statusCnt")
	private Integer statusCount;

	@JsonAlias("ASN")
	private String[] ASN;
	@JsonAlias("GEO")
	private String[] GEO;
	@JsonAlias("RIR")
	private String[] RIR;
}
