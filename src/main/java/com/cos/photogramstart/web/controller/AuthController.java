package com.cos.photogramstart.web.controller;


import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.cos.photogramstart.domain.user.User;
import com.cos.photogramstart.service.AuthService;
import com.cos.photogramstart.web.dto.auth.SignupDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor // final필드를 DI할때 사용
@Controller // IoC에 등록이 됐다는 의미, 파일을 리턴하는 컨트롤러(메서드의 반환값은 기본적으로 뷰 이름 == 뷰 파일)
public class AuthController {
	
	private static final Logger log = LoggerFactory.getLogger(AuthController.class);
	
	// DI에서 불러온다 서비스를 --> 의존성 주입
	private final AuthService authService;
	
	
	@GetMapping("/auth/signin")
	public String signinForm() {
		return "auth/signin";
	}
	
	@GetMapping("/auth/signup")
	public String signupForm() {
		return "auth/signup";
	}
	
	@PostMapping("/auth/signup") 
	// @Valid를 통해 SignupDto에 유효성 검사를 하라고 지시 검사 결과는 BindingResult 객체에 저장 
	public String signup(@Valid SignupDto signupDto, BindingResult bindingResult) { 
		
		// 유효성 검사 이후 에러가 존재한다면 아래 로직을 실행 
			User user = signupDto.toEntity(); // 빌더패턴으로 User 인스턴스를 메모리에 생성 후 DTO 데이터를 저장
			authService.registerUser(user);
			return "auth/signin";
	}
}
