package com.kglory.ndrservice.domain.session.protocol;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * PackageName 	: com.kglory.ndr.domain.session
 * FileName 	: Http
 * Author 		: jhchoi
 * Date 		: 2023-07-31
 * Description 	: HTTP Flag Domain
 * ======================================================
 * DATE				    AUTHOR				NOTICE
 * ======================================================
 * 2023-07-31			jhchoi				최초 생성
 */
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class HttpFlag {
	// auth
	@JsonAlias("authTypeCnt")
	private Integer authTypeCount;
	@JsonAlias("authType")
	private String[] authTypes;
	// body magic
	@JsonAlias("bodyMagicCnt")
	private Integer bodyMagicCount;
	@JsonAlias("bodyMagic")
	private String[] bodyMagics;
	// cookie
	@JsonAlias("cookieKeyCnt")
	private Integer cookieKeyCount;
	@JsonAlias("cookieKey")
	private String[] cookieKeys;
	@JsonAlias("cookieValueCnt")
	private Integer cookieValueCount;
	@JsonAlias("cookieValue")
	private String[] cookieValues;
	// host
	@JsonAlias("hostCnt")
	private Integer hostCount;
	@JsonAlias("host")
	private String[] hosts;
	// key
	@JsonAlias("keyCnt")
	private Integer keyCount;
	@JsonAlias("key")
	private String[] keys;
	// MD5
	@JsonAlias("md5Cnt")
	private Integer md5Count;
	@JsonAlias("md5")
	private String[] md5s;
	// Method
	@JsonAlias("methodCnt")
	private Integer methodCount;
	@JsonAlias("method")
	private String[] methods;
	// Path
	@JsonAlias("pathCnt")
	private Integer pathCount;
	@JsonAlias("path")
	private String[] paths;
	//Request
	@JsonAlias("request-authorization")
	private String[] requestAuthorizations;
	@JsonAlias("request-authorizationCnt")
	private Integer requestAuthorizationCount;
	@JsonAlias("request-chad")
	private String[] requestChads;
	@JsonAlias("request-chadCnt")
	private Integer requestChadCount;
	@JsonAlias("request-content-type")
	private String[] requestContentTypes;
	@JsonAlias("request-content-typeCnt")
	private Integer requestContentTypeCount;
	@JsonAlias("request-origin")
	private String[] requestOrigins;
	@JsonAlias("request-referer")
	private String[] requestReferers;
	@JsonAlias("request-refererCnt")
	private Integer requestRefererCount;
	@JsonAlias("requestBody")
	private String[] requestBodys;
	@JsonAlias("requestHeader")
	private String[] requestHeader;
	@JsonAlias("requestHeaderCnt")
	private Integer requestHeaderCount;
	// Response
	@JsonAlias("response-content-type")
	private String[] responseContentType;
	@JsonAlias("response-content-typeCnt")
	private Integer responseContentTypeCount;
	@JsonAlias("response-location")
	private String[] responseLocation;
	@JsonAlias("response-server")
	private String[] responseServer;
	@JsonAlias("responseHeader")
	private String[] responseHeaders;
	@JsonAlias("responseHeaderCnt")
	private Integer responseHeaderCount;
	// client version
	@JsonAlias("clientVersionCnt")
	private Integer clientVersionCount;
	@JsonAlias("clientVersion")
	private String[] clientVersions;
	// server version
	@JsonAlias("serverVersion")
	private String[] serverVersions;
	@JsonAlias("serverVersionCnt")
	private Integer serverVersionCount;
	// http status
	@JsonAlias("statuscode")
	private String[] statusCodes;
	@JsonAlias("statuscodeCnt")
	private Integer statusCodeCount;
	// http uri
	@JsonAlias("uri")
	private String[] uris;
	@JsonAlias("uriCnt")
	private Integer uriCount;
	// user
	@JsonAlias("user")
	private String[] users;
	@JsonAlias("userCnt")
	private Integer userCount;
	// useragent
	@JsonAlias("useragent")
	private String[] userAgents;
	@JsonAlias("useragentCnt")
	private Integer userAgentCount;
	// value
	@JsonAlias("value")
	private String[] values;
	@JsonAlias("valueCnt")
	private Integer valueCount;
	// XFF
	private String[] xffASN;
	private String[] xffGEO;
	private String[] xffRIR;
	private String[] xffIp;
	private Integer xffIpCnt;
}
