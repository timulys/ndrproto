package com.kglory.ndrservice.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.kglory.ndrservice.utils.LongTimestampDeserializer;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.apache.hc.core5.http.HttpHost;
import org.opensearch.client.json.jackson.JacksonJsonpMapper;
import org.opensearch.client.opensearch.OpenSearchClient;
import org.opensearch.client.transport.httpclient5.ApacheHttpClient5TransportBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * PackageName 	: com.kglory.ndrservice.config
 * FileName 	: OpenSearchClientConfig
 * Author 		: jhchoi
 * Date 		: 2023-08-23
 * Description 	:
 * ======================================================
 * DATE				    AUTHOR				NOTICE
 * ======================================================
 * 2023-08-23			jhchoi				최초 생성
 */
@Setter
@Component
@Slf4j
public class OpenSearchClientConfig {
	@Value("${opensearch.protocol}")
	public String protocol;
	@Value("${opensearch.url}")
	public String url;
	@Value("${opensearch.port}")
	public int port;
	@Value("${opensearch.username}")
	public String username;
	@Value("${opensearch.password}")
	public String password;

	@Bean
	public OpenSearchClient openSearchClient() {
		// TODO : 추후 HTTPS로 변경
		final HttpHost host = new HttpHost(protocol, url, port);

		// LocalDateTime 변환을 위한 Module 등록
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.registerModule(new JavaTimeModule().addDeserializer(LocalDateTime.class, new LongTimestampDeserializer()));

		return new OpenSearchClient(ApacheHttpClient5TransportBuilder
			.builder(host).setMapper(new JacksonJsonpMapper(objectMapper))
			.build());
	}
}
