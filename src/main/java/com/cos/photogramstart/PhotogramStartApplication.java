package com.cos.photogramstart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.github.cdimascio.dotenv.Dotenv;

@SpringBootApplication
public class PhotogramStartApplication {

	public static void main(String[] args) {
		
		 // .env 파일에서 환경 변수 로드
        Dotenv dotenv = Dotenv.configure()
            .filename("oauth.env") // 파일명을 설정
            .load();

        // 환경 변수를 System properties에 설정
        System.setProperty("FACEBOOK_CLIENT_ID", dotenv.get("FACEBOOK_CLIENT_ID"));
        System.setProperty("FACEBOOK_CLIENT_SECRET", dotenv.get("FACEBOOK_CLIENT_SECRET"));
        System.setProperty("GOOGLE_CLIENT_ID", dotenv.get("GOOGLE_CLIENT_ID"));
        System.setProperty("GOOGLE_CLIENT_SECRET", dotenv.get("GOOGLE_CLIENT_SECRET"));
		
		SpringApplication.run(PhotogramStartApplication.class, args);
	}

}
