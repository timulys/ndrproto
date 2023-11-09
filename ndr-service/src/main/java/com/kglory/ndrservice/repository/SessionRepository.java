package com.kglory.ndrservice.repository;

import com.kglory.ndrservice.domain.dto.session.SessionRequest;
import com.kglory.ndrservice.domain.session.Session;
import com.kglory.ndrservice.domain.session.SessionCapture;

import java.util.List;

/**
 * PackageName 	: com.kglory.ndrservice.repository
 * FileName 	: SessionRepository
 * Author 		: jhchoi
 * Date 		: 2023-08-24
 * Description 	: Session Repository Interface
 * ======================================================
 * DATE				    AUTHOR				NOTICE
 * ======================================================
 * 2023-08-24			jhchoi				최초 생성
 */
public interface SessionRepository {
	List<Session> selectAllSession(SessionRequest sessionRequest);
	List<SessionCapture> aggregateSession(SessionRequest sessionRequest);
}
