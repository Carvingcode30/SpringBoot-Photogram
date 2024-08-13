package com.cos.photogramstart.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;

// 어노테이션 없어도 JpaRepository를 상속하면 IoC 등록이 자동으로 된다.
// <엔터티타입, @Id 필드의타입>
// JpaRepository를 상속받아 기본적인 CRUD 연산을 자동으로 제공받는다 ?
public interface UserRepository extends JpaRepository<User, Integer> {
	
	/*
	 * 
	 * findById 메소드가 호출되면, JPA가 내부적으로 다음과 같은 작업을 수행합니다:

User 엔티티의 기본 키(primary key)가 1인 레코드를 데이터베이스에서 조회합니다.
대략적인 SQL은 다음과 같을 것입니다: SELECT * FROM user WHERE id = 1
조회 결과를 User 객체로 매핑합니다.
결과를 Optional<User> 형태로 반환합니다.
	 */
	
	User findByUsername(String username);
	
	
	
	
}
