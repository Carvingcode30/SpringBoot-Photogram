package com.cos.photogramstart.handler.ex;

import java.util.Map;

// RuntimeException 메서드의 매개변수는 오직 String만 받으므로 유효성검사 에러처리를 띄우고 싶으니까 커스텀 하는듯?
public class CustomApiException extends RuntimeException {

	// 시리얼번호는 객체를 구분할 때 쓰는거 JVM한테 중요한거 자바 런 타임 머신한테
	private static final long SerialVersionUID = 1L;
	
	// 생성자
	public CustomApiException(String message) {
		super(message);
	}
}
