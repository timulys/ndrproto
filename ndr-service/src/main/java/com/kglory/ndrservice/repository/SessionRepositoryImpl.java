package com.kglory.ndrservice.repository;

import com.kglory.ndrservice.domain.dto.session.SessionRequest;
import com.kglory.ndrservice.domain.session.Session;
import com.kglory.ndrservice.domain.session.SessionCapture;
import com.kglory.ndrservice.utils.QueryBuilder;
import com.kglory.ndrservice.utils.exception.NdrException;
import com.kglory.ndrservice.utils.exception.code.NdrExceptionCode;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.opensearch.client.opensearch.OpenSearchClient;
import org.opensearch.client.opensearch.core.SearchResponse;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * PackageName 	: com.kglory.ndrservice.repository
 * FileName 	: SessionRepositoryImpl
 * Author 		: jhchoi
 * Date 		: 2023-08-24
 * Description 	: Session Repository Interface Implement Class
 * ======================================================
 * DATE				    AUTHOR				NOTICE
 * ======================================================
 * 2023-08-24			jhchoi				최초 생성
 */
@Repository
@RequiredArgsConstructor
@Slf4j
public class SessionRepositoryImpl implements SessionRepository {
	// Autowired components
	private final OpenSearchClient client;
	private final QueryBuilder queryBuilder;

	/**
	 * Search session data list
	 * @param sessionRequest
	 * @return List<Session>
	 */
	@Override
	public List<Session> selectAllSession(SessionRequest sessionRequest) {
		try {
			SearchResponse<Session> searchResponse =
				client.search(queryBuilder.mustQueryBuilder(sessionRequest), Session.class);
			return searchResponse.hits().hits().stream().map(hit -> {
				// FIXME : Document _id 조회 방법 찾을것
				Session session = hit.source();
				session._id(hit.id());
				return session;
			}).collect(Collectors.toList());
		} catch (Exception e) {
			log.error(e.getLocalizedMessage(), e);
			throw new NdrException(NdrExceptionCode.NO_RECORD);
		}
	}

	/**
	 * Search session aggregation data list
	 * @param sessionRequest
	 * @return List<SessionCapture>
	 */
	@Override
	public List<SessionCapture> aggregateSession(SessionRequest sessionRequest) {
		try {
			SearchResponse<SessionCapture> searchResponse = client.search(queryBuilder.mustQueryBuilder(sessionRequest), SessionCapture.class);
			return searchResponse.aggregations().get("sessions_aggregation").histogram().buckets().array()
				.stream().map(b -> SessionCapture.of(b.keyAsString(), b.docCount())).collect(Collectors.toList());
		} catch (IOException e) {
			log.error(e.getLocalizedMessage(), e);
			throw new NdrException(NdrExceptionCode.NO_RECORD);
		}
	}
}
