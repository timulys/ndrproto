package com.kglory.ndrservice.service;

import com.kglory.ndrservice.domain.dto.session.SessionAggResponse;
import com.kglory.ndrservice.domain.dto.session.SessionListResponse;
import com.kglory.ndrservice.domain.dto.session.SessionRequest;
import com.kglory.ndrservice.domain.dto.session.SessionResponse;
import com.kglory.ndrservice.repository.SessionRepository;
import com.kglory.ndrservice.utils.exception.ErrorResponse;
import com.kglory.ndrservice.utils.exception.NdrException;
import com.kglory.ndrservice.utils.exception.code.ErrorCode;
import com.kglory.ndrservice.utils.exception.code.NdrExceptionCode;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * PackageName 	: com.kglory.ndrservice.service
 * FileName 	: SessionService
 * Author 		: jhchoi
 * Date 		: 2023-08-24
 * Description 	: Arkime Session Service
 * ======================================================
 * DATE				    AUTHOR				NOTICE
 * ======================================================
 * 2023-08-24			jhchoi				최초 생성
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class SessionService {
	// Autowired components
	private final SessionRepository sessionRepository;

	/**
	 * Find sessions data for list and graph
	 * @param sessionRequest
	 * @return
	 */
	public SessionResponse findSession(SessionRequest sessionRequest) {
		// List Data
		List<SessionListResponse> sessions = sessionRepository.selectAllSession(sessionRequest)
			.stream().map(session -> SessionListResponse.of(session)).collect(Collectors.toList());

		// Graph Data
		List<SessionAggResponse> aggregations = sessionRepository.aggregateSession(sessionRequest)
			.stream().map(capture -> SessionAggResponse.of(capture.getCaptureDateTime(), capture.getCaptureCount()))
			.collect(Collectors.toList());

		// Response
		return SessionResponse.of(sessions, aggregations);
	}
}

