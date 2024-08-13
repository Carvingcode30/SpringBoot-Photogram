package com.cos.photogramstart.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.cos.photogramstart.config.oauth.Oauth2DetailsService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@EnableWebSecurity
@Configuration // IoC 등록 --> 메모리에 띄우기
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	private final Oauth2DetailsService oAuth2DetailsService;
	
	// SecurityConfig가 IoC에 등록될 때 @Bean 읽어서 B크립트패스워드를 갖고있다 
	@Bean
	BCryptPasswordEncoder encode() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		http.authorizeRequests()
				.antMatchers("/", "/user/**", "/image/**", "/subscribe/**", "/comment/**", "/api/**").authenticated()
				// 위의 경로로 오는건 인증을 해야한다 **은 뒤에 붙는 모든 것 
				.anyRequest().permitAll()
				// 그 외 경로는 모두 허용하겠다
				.and()
				.formLogin()
				.loginPage("/auth/signin") // GET
				// 그래서 인증을 해야하는 경로로 오면 자동으로 /auth/signin 경로로 리다이렉션 해준다
				.loginProcessingUrl("/auth/signin") // POST -> 스프링 시큐리티가 로그인 프로세스 진행
				.defaultSuccessUrl("/")
				.and()
				.oauth2Login()
				.userInfoEndpoint()
				.userService(oAuth2DetailsService);
	}
}
