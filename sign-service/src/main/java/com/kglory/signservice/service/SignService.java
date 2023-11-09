package com.kglory.signservice.service;

import com.kglory.signservice.entity.Account;
import com.kglory.signservice.entity.dto.TokenRequest;
import com.kglory.signservice.entity.dto.TokenResponse;
import com.kglory.signservice.repository.AccountRepository;
import com.kglory.signservice.util.TokenPublisher;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * PackageName 	: com.kglory.signservice.service
 * FileName 	: SignService
 * Author 		: jhchoi
 * Date 		: 2023-08-23
 * Description 	:
 * ======================================================
 * DATE				    AUTHOR				NOTICE
 * ======================================================
 * 2023-08-23			jhchoi				최초 생성
 */
@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class SignService {
	// 사용자 계정 정보 검증을 위한 repository
	private final AccountRepository accountRepository;
	// 토큰 발급 주체
	private final TokenPublisher tokenPublisher;

	/**
	 * Publishing Access Token
	 * @param tokenRequest
	 * @return
	 */
	public TokenResponse publishToken(TokenRequest tokenRequest) {
		Account account = accountRepository.findById(tokenRequest.getId()).orElseThrow(IllegalArgumentException::new);
		if (!tokenRequest.getPassword().equals(account.getPassword())) {
			log.error("Unregistered user information...");
			throw new RuntimeException("Unregistered");
		}
		return tokenPublisher.createToken(tokenRequest.getId());
	}

	/**
	 * Validation Refresh Token and Update Access ToKen
	 */
	public TokenResponse updateToken(String refreshToken) {
		if (refreshToken.isEmpty()) {
			log.error("Invalid refresh token...");
			throw new RuntimeException("Invalid refresh token...");
		}
		// Refresh token 만료 검증
		if (tokenPublisher.isExpire(refreshToken)) {
			String id = tokenPublisher.getAccountId(refreshToken); // refresh token 에서 id 추출
			return tokenPublisher.updateToken(id); // access token update dto return
		}
		throw new RuntimeException("Expired refresh token.");
	}
}
