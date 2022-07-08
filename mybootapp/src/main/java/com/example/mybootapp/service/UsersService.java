package com.example.mybootapp.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.mybootapp.domain.Users;
import com.example.mybootapp.domain.UsersRepository;
import com.example.mybootapp.dto.UserSignupDto;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
public class UsersService implements UserDetailsService {
	
	// 생성자를 사용한 의존성 주입 - UsersRepository 객체 자동 주입
	private final UsersRepository usersRepository;
	
	@Transactional
	public Long registerUser(UserSignupDto dto) {
		log.info("registerUser(dto={})", dto);
		
		// DTO를 Entity 객체로 변환
		Users entity = dto.toEntity();
		// usersRepository를 사용해서 DB에 회원 정보 INSERT
		usersRepository.save(entity);
		
		return entity.getId();
	}

	@Override
	public UserDetails loadUserByUsername(String username) 
			throws UsernameNotFoundException {
		log.info("loadUserByUsername(username={})", username);
		
		// DB의 Users 테이블에서 username이 일치하는 레코드를 검색
		Users user = usersRepository.findByUsername(username);
		if (user != null) {  // 검색된 결과가 있으면
			return user;  // 검색 결과(Users 객체)를 리턴
		}
		
		// 검색된 결과가 없으면(username이 일치하는 계정이 없으면) Exception을 만듦.
		throw new UsernameNotFoundException(username + " NOT FOUND...");
	}

}
