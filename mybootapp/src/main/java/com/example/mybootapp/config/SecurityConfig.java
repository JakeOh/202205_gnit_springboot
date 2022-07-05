package com.example.mybootapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration  // Spring Boot 환경 설정 클래스 Bean
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	// WebSecurityConfigurerAdapter를 상속
	// http 인증과 사용자 인증과 관련된 configure 메서드를 override하기 위해서.
	// http 인증: 인증없이 접속 가능한 페이지, 인증해야만 접속 가능한 페이지 등을 설정.
	// 사용자 인증: 로그인 가능한 사용자 설정

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.csrf().disable()
		.headers().frameOptions().disable()
		// 여기까지 설정은 h2-console을 접속할 수 있게끔 하기 위해서. Ajax 요청을 처리하기 위해서.
		.and()
			.authorizeHttpRequests()  // 인증 필요한 요청, 인증 필요없는 요청을 설정.
			.antMatchers("/save", "/read/**", "/update/**", "/api/posts/**")
			.hasRole("USER")  // 위쪽의 요청(request)들은 USER 권한의 사용자만 접근 가능.
			.antMatchers("/", "/**")
			.permitAll()  // 위쪽의 요청들은 인증없이 접근 가능.
		.and()
			.httpBasic()  // custom login page가 없을 때 
		;  
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// in-memory user store: 
		// 메모리에 테스트용 사용자 인증 정보(username, password, role)를 생성
		// Spring 5 버전부터 비밀번호는 암호화를 하지 않으면 HTTP 403 에러를 발생시킴.
		auth.inMemoryAuthentication()
			.withUser("user1")
			.password(pwdEncoder().encode("password1"))
			.roles("USER")
		.and()
			.withUser("user2")
			.password(pwdEncoder().encode("password2"))
			.roles("USER");
	}

	@Bean
	public PasswordEncoder pwdEncoder() {
		return new BCryptPasswordEncoder();
	}
	
}
