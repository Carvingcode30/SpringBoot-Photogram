package com.cos.photogramstart.web.dto;

import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CMRespDto<T> { // 제네릭: 다양한 데이터 타입 포함 가능
	// <T> 타입 파라미터로 실제 사용 시 구체적인 타입을 대체 됨 
	
	private int code; // 1(성공) -1(실패)
	private String message;
	private T data;
	
}
