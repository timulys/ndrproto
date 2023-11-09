package com.kglory.ndrservice.controller;

import com.kglory.ndrservice.domain.dto.session.SessionRequest;
import com.kglory.ndrservice.domain.dto.session.SessionResponse;
import com.kglory.ndrservice.service.SessionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * PackageName 	: com.kglory.ndrservice.controller
 * FileName 	: SessionRestController
 * Author 		: jhchoi
 * Date 		: 2023-08-24
 * Description 	:
 * ======================================================
 * DATE				    AUTHOR				NOTICE
 * ======================================================
 * 2023-08-24			jhchoi				최초 생성
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/session")
public class SessionRestController {
	// Autowired components...
	private final SessionService sessionService;

	@GetMapping("/search")
	public ResponseEntity<SessionResponse> sessionList(@RequestParam String id,
													   @RequestParam String communityId,
													   @RequestParam String searchTime) {
		return ResponseEntity.ok(sessionService.findSession(SessionRequest.of(id, communityId, searchTime)));
	}
}
