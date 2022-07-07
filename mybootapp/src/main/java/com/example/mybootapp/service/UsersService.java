package com.example.mybootapp.service;

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
public class UsersService {
	
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

}
