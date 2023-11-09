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
 * FileName 	: Email
 * Author 		: jhchoi
 * Date 		: 2023-08-08
 * Description 	:
 * ======================================================
 * DATE				    AUTHOR				NOTICE
 * ======================================================
 * 2023-08-08			jhchoi				최초 생성
 */
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Email {
	@JsonAlias("bodyMagicCnt")
	private Integer bodyMagicCount;
	@JsonAlias("bodyMagic")
	private String[] bodyMagics;
	@JsonAlias("contentTypeCnt")
	private Integer contentTypeCount;
	@JsonAlias("contentType")
	private String[] contentTypes;
	@JsonAlias("dstCnt")
	private Integer receiverCount;
	@JsonAlias("dst")
	private String[] receivers;
	@JsonAlias("srcCnt")
	private Integer senderCount;
	@JsonAlias("src")
	private String[] senders;
	@JsonAlias("hostCnt")
	private Integer hostCount;
	@JsonAlias("host")
	private String[] hosts;
	@JsonAlias("filenameCnt")
	private Integer fileCount;
	@JsonAlias("filename")
	private String[] fileNames;
	@JsonAlias("headerCnt")
	private String headerCount;
	@JsonAlias("header-x-priority")
	private Integer[] priority;
	@JsonAlias("idCnt")
	private Integer idCount;
	@JsonAlias("id")
	private String[] ids;
	@JsonAlias("ipCnt")
	private Integer ipCount;
	@JsonAlias("ip")
	private String[] ips;
	@JsonAlias("md5Cnt")
	private Integer md5Count;
	@JsonAlias("md5")
	private String[] md5s;
	@JsonAlias("mimeVersionCnt")
	private Integer mimeVersionCount;
	@JsonAlias("mimeVersion")
	private String[] mimeVersions;
	@JsonAlias("smtpHelloCnt")
	private Integer smtpHelloCount;
	@JsonAlias("smtpHello")
	private String[] smtpHellos;
	@JsonAlias("subjectCnt")
	private Integer subjectCount;
	@JsonAlias("subject")
	private String[] subjects;
	@JsonAlias("useragentCnt")
	private Integer userAgentCount;
	@JsonAlias("useragent")
	private String[] userAgents;

	@JsonAlias("ASN")
	private String[] asn;
	@JsonAlias("GEO")
	private String[] geo;
	@JsonAlias("RIR")
	private String[] rir;
}

