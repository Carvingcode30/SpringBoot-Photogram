package com.cos.photogramstart.handler.ex;

import java.util.Map;

// RuntimeException 메서드의 매개변수는 오직 String만 받으므로 유효성검사 에러처리를 띄우고 싶으니까 커스텀 하는듯?
public class CustomValidationApiException extends RuntimeException {

	// 시리얼번호는 객체를 구분할 때 쓰는거 JVM한테 중요한거 자바 런 타임 머신한테
	private static final long SerialVersionUID = 1L;
	
	private Map<String, String> errorMap;
	
	// 생성자
	public CustomValidationApiException(String message) {
		super(message);
	}
	
	// 생성자
	public CustomValidationApiException(String message, Map<String,String> errorMap) {
		// 부모 클래스 RuntimeException의 생성자를 호출 
		// 이 message는 예외의 기본 메세지로 설정됨 
		super(message); // message는 getter가 필요없는게 이미 만들어져있어서??? 부모한테만 던져주면 된다??? 
		this.errorMap = errorMap;
	}
	
	// getter
	public Map<String, String> getErrorMap() {
		return errorMap;
	}
}
