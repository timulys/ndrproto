package com.kglory.ndrservice.utils;

import com.kglory.ndrservice.domain.dto.session.SessionRequest;
import org.opensearch.client.opensearch._types.FieldValue;
import org.opensearch.client.opensearch._types.SortOptions;
import org.opensearch.client.opensearch._types.SortOrder;
import org.opensearch.client.opensearch._types.aggregations.Aggregation;
import org.opensearch.client.opensearch._types.query_dsl.Query;
import org.opensearch.client.opensearch.core.SearchRequest;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;

/**
 * PackageName 	: com.kglory.ndrservice.utils
 * FileName 	: QueryBuilder
 * Author 		: jhchoi
 * Date 		: 2023-08-24
 * Description 	: Open Search Query Builder Util
 * ======================================================
 * DATE				    AUTHOR				NOTICE
 * ======================================================
 * 2023-08-24			jhchoi				최초 생성
 */
@Component
public class QueryBuilder {
	// Arkime Session Indexs
	private static String SESSIONS = "arkime_sessions3-"; 		// append current date
	private static String ALL_SESSIONS = "arkime_sessions3-*";	// all sessions indexs

	/**
	 * Must Query Builder
	 * @return
	 */
	public SearchRequest mustQueryBuilder(SessionRequest sessionRequest) {
		SearchRequest.Builder builder = new SearchRequest.Builder();
		List<Query> mustQueries = new ArrayList<>();
		// search condition : _id
		if (!sessionRequest.getId().isBlank()) {
			mustQueries.add(Query.of(query -> query.match(
				value -> value.field("_id").query(FieldValue.of(sessionRequest.getId()))
			)));
		}
		
//		TODO : 도메인 설계 완료 후 검색 조건에 추가할 것
//		// search condition : times
//		if (!sessionRequest.getStartTime().isBlank()) {
//			mustQueries.add(Query.of(query -> query.range(value -> value.field("@timestamp")
//				.gte(JsonData.of(sessionRequest.getStartTime()))
//				.lte(JsonData.of(sessionRequest.getStopTime())))));
//		}

		return builder.index(ALL_SESSIONS).size(10000).query(query -> query.bool(bool -> bool.must(mustQueries)))
			.aggregations("sessions_aggregation", aggregateSession(sessionRequest))
			.sort(SortOptions.of(option -> option.field(value -> value.field("firstPacket").order(SortOrder.Desc))))
			.build();
	}

	/**
	 * Aggregate Sessions Index
	 * @param sessionRequest
	 * @return
	 */
	private Aggregation aggregateSession(SessionRequest sessionRequest) {
		return new Aggregation.Builder()
			.histogram(term -> term.field("lastPacket").interval(60000.0).minDocCount(1)).build();
	}

	/**
	 * Sessions Index Range
	 * @param sessionRequest
	 * @return
	 */
	private List<String> getIndexRange(SessionRequest sessionRequest) {
		String startDateTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(Long.valueOf(sessionRequest.getStartTime()))
			, TimeZone.getDefault().toZoneId()).minusMinutes(9 * 60).format(DateTimeFormatter.ofPattern("yyMMdd"));
		String stopDateTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(Long.valueOf(sessionRequest.getStopTime()))
			, TimeZone.getDefault().toZoneId()).minusMinutes(9 * 60).format(DateTimeFormatter.ofPattern("yyMMdd"));

		List<String> indexList = new ArrayList<>();
		indexList.add(SESSIONS + startDateTime);
		indexList.add(SESSIONS + stopDateTime);

		return indexList;
	}
}
