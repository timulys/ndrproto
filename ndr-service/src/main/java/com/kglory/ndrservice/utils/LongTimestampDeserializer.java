package com.kglory.ndrservice.utils;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

/**
 * PackageName 	: com.kglory.ndrservice.utils
 * FileName 	: LongTimestampDeserializer
 * Author 		: jhchoi
 * Date 		: 2023-08-23
 * Description 	: Deserializer for converting Long to LocalDateTime
 * ======================================================
 * DATE				    AUTHOR				NOTICE
 * ======================================================
 * 2023-08-23			jhchoi				최초 생성
 */
public class LongTimestampDeserializer extends JsonDeserializer<LocalDateTime> {
	/**
	 * Convert Long Type Value to LocalDateTime
	 * @param jsonParser
	 * @param deserializationContext
	 * @return LocalDateTime
	 * @throws IOException
	 * @throws JacksonException
	 */
	@Override
	public LocalDateTime deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JacksonException {
		long timestamp = jsonParser.getValueAsLong();
		Instant instant = Instant.ofEpochMilli(timestamp);
		return LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
	}

}
