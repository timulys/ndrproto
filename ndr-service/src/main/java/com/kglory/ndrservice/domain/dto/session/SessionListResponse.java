package com.kglory.ndrservice.domain.dto.session;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.kglory.ndrservice.domain.session.Session;
import lombok.*;

import java.time.format.DateTimeFormatter;

/**
 * PackageName 	: com.kglory.ndr.domain.dto.session
 * FileName 	: SessionResponse
 * Author 		: jhchoi
 * Date 		: 2023-07-19
 * Description 	:
 * ======================================================
 * DATE				    AUTHOR				NOTICE
 * ======================================================
 * 2023-07-19			jhchoi				최초 생성
 */
@Getter
@Builder(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class SessionListResponse {
	private String id;
	private String communityId;
	private String startTime;
	private String stopTime;
	private String arkimeNode;
	private String[] protocols;
	private Integer ipProtocol;

	private String srcIp;
	private Integer srcPort;
	private Integer srcPackets;
	private Integer srcBytes;
	private Integer srcDataBytes;
	private String rirCode;

	private String dstIp;
	private Integer dstPort;
	private Integer dstPackets;
	private Integer dstBytes;
	private Integer dstDataBytes;

	private String payload;

	public static SessionListResponse of(Session session) {
		return SessionListResponse.builder()
			.id(session.getId())
			.communityId(session.getNetwork() != null ? session.getNetwork().getCommunityId() : null)
			.startTime(session.getStartTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:MM:ss")))
			.stopTime(session.getStopTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:MM:ss")))
			.arkimeNode(session.getArkimeNode())
			.protocols(session.getProtocol())
			.ipProtocol(session.getIpProtocol())
			.srcIp(session.getSource() != null ? session.getSource().getIp() : null)
			.srcPort(session.getSource() != null ? session.getSource().getPort() : null)
			.srcPackets(session.getSource() != null ? session.getSource().getPackets() : null)
			.srcBytes(session.getSource() != null ? session.getSource().getBytes() : null)
			.srcDataBytes(session.getClientBytes())
			.dstIp(session.getDestination() != null ? session.getDestination().getIp() : null)
			.dstPort(session.getDestination() != null ? session.getDestination().getPort() : null)
			.dstPackets(session.getDestination() != null ? session.getDestination().getPackets() : null)
			.dstBytes(session.getDestination() != null ? session.getDestination().getBytes() : null)
			.dstDataBytes(session.getServerBytes())
			.build();
	}
}
