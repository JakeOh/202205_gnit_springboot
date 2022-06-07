package com.example.mybootapp.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

// MVC(Model-View-Controller)
// Model: 데이터 클래스 객체.
// View: UI(User Interface). Template(템플릿). JSP, HTML, mustache, ...
// Controller: 요청(request)을 처리하는 클래스 객체.
// @Controller 애너테이션: Spring Boot app에 Controller 클래스로 등록. 
@Controller
public class ExampleController {

	// request method(요청 방식): GET, POST, PUT, DELETE, ...
	// @GetMapping("url"): GET 방식의 url 요청을 처리하는 메서드임을 등록.
	@GetMapping("/test1")
	public String test1() {
		// controller 메서드에서 리턴하는 문자열은 view의 이름(HTML 파일 이름).
		// Spring Boot에서는 src/main/resources/templates 폴더 아래에서 HTML 파일을 찾음.
		return "test";
	}
	
	// GET 방식의 "/test2" url을 처리하는 컨트롤러 메서드.
	@GetMapping("/test2")
	public String test2(
			@RequestParam(name = "userName") String userName,
			Model model) {
		// @RequestParam(name="paramName"): 요청 파라미터 paramName의 값을 변수에 전달.
		// Model: controller 메서드에서 view로 전달되는 데이터를 저장하기 위한 객체.
		// dispatcherServlet 객체가 controller 메서드를 호출하면서,
		// 파라미터 userName에 요청 파라미터 값을 전달, Model 객체도 전달.
		
		// Model 객체에 "userName" 속성 이름으로 값 userName을 저장.
		model.addAttribute("userName", userName);
		// view(HTML) 이름을 리턴.
		return "test";
	}
	
}
