package com.kglory.ndrservice.domain.session;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.kglory.ndrservice.domain.BaseDomain;
import com.kglory.ndrservice.domain.session.protocol.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Map;

/**
 * PackageName 	: com.kglory.ndr.domain.session
 * FileName 	: Session
 * Author 		: jhchoi
 * Date 		: 2023-07-18
 * Description 	:
 * ======================================================
 * DATE				    AUTHOR				NOTICE
 * ======================================================
 * 2023-07-18			jhchoi				최초 생성
 */
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Session extends BaseDomain {
	@JsonAlias("id")
	private String id;
	@JsonAlias("length")
	private Long length;
	@JsonAlias("ipProtocol")
	private Integer ipProtocol;
	@JsonAlias("initRTT")
	private Integer RoundTripTime;
	@JsonAlias("srcPayload8")
	private String srcPayload;
	@JsonAlias("dstPayload8")
	private String dstPayload;
	@JsonAlias("@timestamp")
	private String timestamp;
	@JsonAlias("srcRIR")
	private String srcRIR;		// Regional Internet Registry
	@JsonAlias("dstRIR")
	private String dstRIR;		// Regional Internet Registry
	@JsonAlias("totDataBytes")
	private Integer totDataBytes;
	@JsonAlias("segmentCnt")
	private Integer segmentCnt;
	@JsonAlias("node")
	private String arkimeNode;
	@JsonAlias("packetPos")
	private Long[] packetList;
	@JsonAlias("fileId")
	private Integer[] fileId;
	@JsonAlias("protocolCnt")
	private Integer protocolCnt;
	@JsonAlias("protocol")
	private String[] protocol;
	@JsonAlias("srcDscpCnt")
	private Integer srcDscpCnt;
	@JsonAlias("srcDscp")
	private String[] srcDscp;
	@JsonAlias("dstOuiCnt")
	private Integer dstOuiCnt;
	@JsonAlias("dstOui")
	private String[] dstOuiList;
	@JsonAlias("srcOuiCnt")
	private Integer srcOuiCnt;
	@JsonAlias("srcOui")
	private String[] srcOuiList;
	@JsonAlias("tagsCnt")
	private Integer tagCount;
	@JsonAlias("tags")
	private String[] tags;

	// Objects
	private Detection source;
	private Detection destination;
	private Network network;
	private Oracle oracle;
	private Cert[] certs;

	@JsonAlias("krb5")
	private Kerberos kerberos;
	@JsonAlias("irc")
	private InternetRelayChat irc;
	@JsonAlias("smb")
	private ServerMessageBlock smb;

	// Protocol Flag
	@JsonAlias("tcpflags")
	private TcpFlag tcpFlag;
	@JsonAlias("http")
	private HttpFlag httpFlag;
	@JsonAlias("tls")
	private TlsFlag tlsFlag;
	@JsonAlias("snmp")
	private SnmpFlag snmpFlag;
	@JsonAlias("dns")
	private DnsFlag dnsFlag;
	@JsonAlias("ldap")
	private LdapFlag ldapFlag;
	@JsonAlias("dhcp")
	private DhcpFlag dhcpFlag;

	// Client & Server
	private Integer serverBytes;
	private Integer clientBytes;
	@SuppressWarnings("unchecked")
	@JsonProperty("server")
	private void unpackServer(Map<String, Object> server) {
		this.serverBytes = (Integer) server.get("bytes");
	}
	@SuppressWarnings("unchecked")
	@JsonProperty("client")
	private void unpackClient(Map<String, Object> client) {
		this.clientBytes = (Integer) client.get("bytes");
	}

	/**
	 * document _id 설정
	 * @param _id
	 */
	public void _id(String _id) {
		this.id = _id;
	}
}

