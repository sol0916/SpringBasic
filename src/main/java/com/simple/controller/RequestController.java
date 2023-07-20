package com.simple.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.simple.command.ReqVO;

@Controller
@RequestMapping("/request") //각 메서드의 공통분모
public class RequestController {

	//화면을 띄우는 
	@RequestMapping("/req_ex01") //request/req_ex01
	public String ex01() {
		return "request/req_ex01";
	}
	
	//get 요청만 허용
	//value는 기본값으로 들어가 있음 (생략 가능)
	//@RequestMapping(value = "/basic1", method = RequestMethod.GET)
	@GetMapping("/basic1")
	public void basic1() {
		System.out.println("basic1 요청"); 
	}
	
	//post 요청만 허용
	//@RequestMapping(value ="/basic2", method = RequestMethod.POST)
	@PostMapping("/basic2")
	public void basic2() {
		System.out.println("basic2 요청");
	}
	
	//get, post 둘다 허용
	@RequestMapping("/basic3")
	public void basic3() {
		System.out.println("basic3 요청");
	}
	
	/////////////파라미터 값 받기///////////////////////////
	
	@RequestMapping("/req_ex02")
	public String ex02() {
		return "request/req_ex02";
	}
	
	//전통적인 방법
//	@RequestMapping("/param1")
//	public String param1(HttpServletRequest request) {
//		
//		String name = request.getParameter("name");
//		String age = request.getParameter("age");
//		String[] inter = request.getParameterValues("inter");
//		
//		System.out.println(name);
//		
//		return "request/result"; //result 페이지로
//	}
	
	
	//어노테이션을 이용한 방법
	//@RequestParam(네임값)=> form 태그의 네임값
	//RequestParam은 반드시 필수로 값이 전달이 되야 합니다
	//required = false는 반드시 필수가 아님
	//defaultValue 값이 없을 때 기본값
//	@RequestMapping("/param1")
//	public String param1(@RequestParam("name") String x,
//						 @RequestParam(value = "age", required = false, defaultValue="0") int y,
//						 @RequestParam(value = "inter", required = false, defaultValue="") ArrayList<String> z) {
//		
//		
//		System.out.println(x);
//		System.out.println(y);
//		System.out.println(z.toString());
//		
//		return "request/result"; //result 페이지로
//	}
	
	
	//커맨드객체를 이용하는 방법
	@RequestMapping("/param1")
	public String param1(ReqVO vo) {
		
		System.out.println(vo.toString());
		
		return "request/result";
	}
	
	
	////////// quiz //////////
	
	//화면처리
	@RequestMapping("/req_quiz01")
	public String quiz01() {
		return "request/req_quiz01";
	}
		
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@RequestParam(value = "id") String id,
						@RequestParam(value = "pw") String pw) {
					
		if(id.equals("abc123")&&pw.equals("xxx123")) {
			System.out.println(id);
			System.out.println(pw);
			return "request/req_quiz01_ok";
		}
		
		System.out.println(id);
		System.out.println(pw);
		return "request/req_quiz01_no";
	}
	
	
}
