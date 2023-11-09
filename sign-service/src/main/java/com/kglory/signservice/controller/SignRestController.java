package com.kglory.signservice.controller;

import com.kglory.signservice.entity.AuthCode;
import com.kglory.signservice.entity.dto.TokenRequest;
import com.kglory.signservice.entity.dto.TokenResponse;
import com.kglory.signservice.service.SignService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * PackageName 	: com.kglory.signservice.controller
 * FileName 	: SignRestController
 * Author 		: jhchoi
 * Date 		: 2023-08-23
 * Description 	: Sign Controller
 * ======================================================
 * DATE				    AUTHOR				NOTICE
 * ======================================================
 * 2023-08-23			jhchoi				최초 생성
 */
@RestController
@RequestMapping("/sign")
@RequiredArgsConstructor
public class SignRestController {
	// Autowired component
	private final SignService signService;

	@PostMapping("/token")
	public ResponseEntity<TokenResponse> publishToken(@RequestBody TokenRequest tokenRequest) {
		return ResponseEntity.ok(signService.publishToken(tokenRequest));
	}

	@PutMapping("/refresh")
	public ResponseEntity<TokenResponse> updateToken(HttpServletRequest request) {
		String refreshToken = request.getHeader(AuthCode.REFRESH.getType()); // Refresh Token
		return ResponseEntity.ok(signService.updateToken(refreshToken));
	}
}
