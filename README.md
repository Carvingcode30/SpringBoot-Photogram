# 인스타그램 클론 프로젝트

![289036994-32c9715b-693d-4d67-b238-04f4da7b7904](https://github.com/user-attachments/assets/301036db-8f9f-4d5a-9743-2750f2a06a74)


## 프로젝트 소개
Spring Boot와 JPA를 사용하여 구현한 인스타그램 클론 웹 애플리케이션입니다.


## 기술 스택
- Backend: Java, Spring Boot, JPA, MariaDB
- Frontend: JavaScript, jQuery, JSP
- 보안인증: Spring Security, OAuth 2.0 (Facebook, Google 로그인)
- 세부구현사항: AOP, ResponseEntity, Custom 예외처리


## ERD
![photogram](https://github.com/user-attachments/assets/e1f4c821-2391-417a-abe1-b94aee9d2261)


![Photogram](https://github.com/user-attachments/assets/56344c19-9a35-4abf-8a13-9be6db778439)


## 주요 기능
1. 사용자 관리
   - 회원가입 및 로그인 (ID, Facebook, Google)
   - 회원정보 수정 및 프로필 이미지 업로드
   - 비밀번호 암호화 저장
   
2. 게시글 관리
   - 사진 업로드 및 게시글 작성
   - 좋아요 및 댓글 기능
   - 최신순 정렬 및 페이징 (무한 스크롤)

3. 사용자 상호작용
   - 사용자 간 구독 및 구독 취소
   - 좋아요 기능

4. 보안 및 성능
   - Spring Security를 이용한 인증 및 인가
   - AOP를 활용한 유효성 검사 자동화
   - DTO 매핑 및 커스텀 예외 처리

5. 데이터베이스
   - JPA를 이용한 복잡한 연관관계 처리
   - 다대다 관계 처리

