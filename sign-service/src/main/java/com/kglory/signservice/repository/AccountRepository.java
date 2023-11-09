package com.kglory.signservice.repository;

import com.kglory.signservice.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * PackageName 	: com.kglory.signservice.repository
 * FileName 	: AccountRepository
 * Author 		: jhchoi
 * Date 		: 2023-08-23
 * Description 	: Account Repository Interface
 * ======================================================
 * DATE				    AUTHOR				NOTICE
 * ======================================================
 * 2023-08-23			jhchoi				최초 생성
 */
public interface AccountRepository extends JpaRepository<Account, Long> {
	Optional<Account> findById(String id);
}
