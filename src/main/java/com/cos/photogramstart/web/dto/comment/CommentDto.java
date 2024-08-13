package com.cos.photogramstart.web.dto.comment;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class CommentDto {
	@NotBlank // 빈 값이거나 null, 공백 
	private String content;
	@NotNull // 빈 값이거나 null 체크
	private Integer imageId;
}
