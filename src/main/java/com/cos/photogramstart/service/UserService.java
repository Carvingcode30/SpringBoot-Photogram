package com.cos.photogramstart.service;


import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.cos.photogramstart.domain.subscribe.SubscribeRepository;
import com.cos.photogramstart.domain.user.User;
import com.cos.photogramstart.domain.user.UserRepository;
import com.cos.photogramstart.handler.ex.CustomApiException;
import com.cos.photogramstart.handler.ex.CustomException;
import com.cos.photogramstart.handler.ex.CustomValidationApiException;
import com.cos.photogramstart.web.dto.user.UserProfileDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserService {

	private final UserRepository userRepository;
	private final SubscribeRepository subscribeRepository;
	private final BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Value("${file.path}") 
	private String uploadFolder;
	
	@Transactional
	public User userProfileUpdate(int princiaplId, MultipartFile profileImageFile) {
		UUID uuid = UUID.randomUUID(); // UUID 고유 식별자
		String imageFileName = uuid+"_"+profileImageFile.getOriginalFilename();
		System.out.println("이미지 파일이름: " + imageFileName);
		
		Path imageFilePath = Paths.get(uploadFolder+imageFileName); 
	
		try {
			Files.write(imageFilePath, profileImageFile.getBytes());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		User userEntity = userRepository.findById(princiaplId).orElseThrow(()->{
			throw new CustomApiException("유저를 찾을 수 없습니다.");
		});
		userEntity.setProfileImageUrl(imageFileName);
		
		return userEntity;
	} // 더티체킹으로 업데이트 됨
	
	@Transactional(readOnly = true)
	public UserProfileDto userProfile(int pageUserId, int principalId) {
		UserProfileDto dto = new UserProfileDto();
		
		/*
		 * JpaRepository는 기본적인 CRUD 연산을 위한 메소드들을 이미 정의하고 있습니다.
findById는 이 기본 메소드 중 하나입니다.

만약 해당 ID의 사용자가 존재하면 User 객체를 반환합니다.
존재하지 않으면 지정된 예외를 던집니다.
		 */
		
		// SELECT * FROM image WHERE userId = :userId;
		User userEntity = userRepository.findById(pageUserId).orElseThrow(()-> {
			throw new CustomException("해당 프로필 페이지는 없는 페이지입니다.");
		});
		
		dto.setUser(userEntity);
		dto.setPageOwnerState(pageUserId == principalId);
		dto.setImageCount(userEntity.getImages().size());
		
		int subscribeState = subscribeRepository.mSubscribeState(principalId, pageUserId);
		int subscribeCount = subscribeRepository.mSubscribeCount(pageUserId);
		
		dto.setSubscribeState(subscribeState==1);
		dto.setSubscribeCount(subscribeCount);
		
		// 좋아요 카운트 추가하기
		userEntity.getImages().forEach((image)->{
			image.setLikeCount(image.getLikes().size());
		});
		
		return dto;
	}
	
	@Transactional
	public User userUpdate(int id, User user) {
		// 1. 영속화
		// 1. 무조건 찾았다 걱정ㄴ get() 2. 못찾음 익셉션 발동시킬게 orElseThrow()
		User userEntity = userRepository.findById(id).orElseThrow(() -> {return new CustomValidationApiException("찾을 수 없는 id입니다.");}); 
		
		// 2. 영속화된 오브젝트 수정 - 더티체킹(업데이트 완료)
		userEntity.setName(user.getName());
		
		String rawPassword = user.getPassword();
		String encPassword = bCryptPasswordEncoder.encode(rawPassword);
		
		userEntity.setPassword(encPassword);
		userEntity.setBio(user.getBio());
		userEntity.setWebsite(user.getWebsite());
		userEntity.setPhone(user.getPhone());
		userEntity.setGender(user.getGender());
		
		return userEntity;
		// 더티체킹이 일어나서 업데이트가 완료됨
	}
}
