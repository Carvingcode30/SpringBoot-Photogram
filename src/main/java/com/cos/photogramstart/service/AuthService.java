package com.cos.photogramstart.service;

import javax.transaction.Transactional;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.cos.photogramstart.domain.user.User;
import com.cos.photogramstart.domain.user.UserRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor // 필수 필드(final이나 @NonNull로 표시된 필드)만을 파라미터로 받는 생성자를 자동으로 생성합니다.필수 필드(final이나 @NonNull로 표시된 필드)만을 파라미터로 받는 생성자를 자동으로 생성합니다.
@Service // 1. IoC 2. 트랜잭션 관리
public class AuthService {
	
	private final UserRepository userRepository;
	private final BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Transactional // 함수가 실행되고 종료될 때 까지 transactional 걸린다 트랜잭션 
	// insert, update, delete때 걸어준다
	// 해당 메서드를 하나의 트랜잭션으로 처리. 메서드 실행 중 예외가 발생하면 모든 DB 변경사항이 롤백된다
	public User registerUser(User user) {
		// 회원가입 진행
		String rawPassword = user.getPassword();
		String encPassword = bCryptPasswordEncoder.encode(rawPassword);
		user.setPassword(encPassword);
		user.setRole("ROLE_USER"); // 관리자 ROLE_ADMIN
		
		User userEntity = userRepository.save(user); // JpaRepository가 제공하는 기본적인 CRUD에서 save는 뭐 insert하는건가 ? update?
		return userEntity;
	}
}
