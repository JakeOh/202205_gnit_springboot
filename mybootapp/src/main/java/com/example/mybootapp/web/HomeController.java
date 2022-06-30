package com.example.mybootapp.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.mybootapp.dto.PostsFindAllResponseDto;
import com.example.mybootapp.dto.PostsReadResponseDto;
import com.example.mybootapp.service.PostsService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Controller
public class HomeController {
	// Spring Framework: DI(Dependency Injection)을 제공하는 프레임워크.
	// IoC(Inversion of Control, 제어의 역전):
	//   객체를 사용하는 클래스가 객체 생성을 담당하지 않고, 객체를 주입받아서 사용.
	// 생성자에 의한 의존성 주입 패턴:
	private final PostsService postsService;
	
	@GetMapping("/")
	public String index(Model model) {
		// 파라미터 Model: controller에서 view(HTML)로 전달할 데이터가 있을 때 사용.
		
		log.info("index() 호출...");
		
		// Service 객체를 사용해서 DB 테이블(posts)의 모든 내용을 읽어 온다(SELECT).
		List<PostsFindAllResponseDto> list = postsService.findAll();
		// DB에서 select한 리스트를 Model 객체를 사용해서 view에 전달.
		model.addAttribute("posts", list);
		
		return "index";
	}
	
	@GetMapping("/save")
	public String save() {
		log.info("save() GET 호출...");
		return "post_save";
	}
	
	@GetMapping("/read/{id}")
	public String read(@PathVariable(name = "id") Long id, Model model) {
		// Long id 파라미터: path variable의 값이 전달됨.
		// Model model 파라미터: controller에서 view(HTML)에게 데이터를 전달하기 위해서.
		log.info("read(id={})", id);
		
		// postsService의 메서드를 호출해서 해당 글 번호의 내용을 읽어옴.
		PostsReadResponseDto dto = postsService.findById(id);
		
		// Posts의 내용을 model에 넣어서 view(HTML)에게 전달.
		model.addAttribute("post", dto);
		
		return "post_read";
	}
	
	@GetMapping("/update/{id}")
	public String update(@PathVariable(name = "id") Long id, Model model) {
		log.info("update(id={})", id);
		
		PostsReadResponseDto dto = postsService.findById(id);
		model.addAttribute("post", dto);
		
		return "post_update";
	}
	
	@GetMapping("/search")
	public String search(@RequestParam(name = "searchType") String type,
			@RequestParam(name = "searchKeyword") String keyword,
			Model model) {
		log.info("search(type={}, keyword={})", type, keyword);
		
		List<PostsFindAllResponseDto> list = 
				postsService.findByKeyword(type, keyword);
		model.addAttribute("posts", list);
		
		return "index";
	}
	
}
