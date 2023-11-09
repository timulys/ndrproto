package com.kglory.ndrservice.domain.session;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * PackageName 	: com.kglory.ndr.domain.session
 * FileName 	: Detection
 * Author 		: jhchoi
 * Date 		: 2023-07-19
 * Description 	:
 * ======================================================
 * DATE				    AUTHOR				NOTICE
 * ======================================================
 * 2023-07-19			jhchoi				최초 생성
 */
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Detection {
	private String ip;
	private Integer port;
	private Integer bytes;
	private Integer packets;
	@JsonAlias("mac-cnt")
	private Integer macCnt;
	private List<String> mac;
}
