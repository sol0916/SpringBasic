package com.simple.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.simple.command.ReqVO;

@Controller
@RequestMapping("/response")
public class ResponseController {
	
	@RequestMapping("/res_ex01")
	public void ex01() {
				
	}
	
	//model 전달자
	@RequestMapping("/ex02")
	public String ex02(Model model) {
		
		model.addAttribute("name", "홍길동");
		model.addAttribute("date", new Date());
		
		return "response/ex02";
	}
	
	//ModelAndView - 데이터와 화면 정보를 동시에 저장하는 객체
	@RequestMapping("/ex03")
	public ModelAndView ex03() {
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("serverTime", new Date()); //데이터
		mv.setViewName("response/ex03"); //화면 정보
		
		return mv;
	}
	
	//@ModelAttribute(화면에서 넘어온 값)
	@RequestMapping("/ex04")
	public String ex04(@ModelAttribute("id") String id) {
		
		System.out.println("넘어온 값:"+id);
		
		return "response/ex04";
	}
	
	
	//ModelAttribute 객체타입 vo 받아서 xxx이름으로 변경해서 화면으로 전달
	//xxx로 명칭을 지어서 다음 화면으로 넘김 => xxx로 vo값을 받을 수 있음
	@RequestMapping("/ex05")
	public String ex05(@ModelAttribute("xxx") ReqVO vo) { 
		
		System.out.println(vo.toString());
		
		return "response/ex05";
	}
	
	
	////////////////////리디렉션과 리디렉션어트리뷰트
	
	//화면처리
	@RequestMapping("/join")
	public String join() {
		return "response/join";
	}
	
	//폼요청
	@RequestMapping(value ="/joinForm", method=RequestMethod.POST)
	public String joinForm(ReqVO vo, RedirectAttributes ra) {
		
		//가입처리
		
		//리다이렉트시에 사용하며, 1회성 데이터를 화면에 전달해줄 수 있습니다. ("키", 값)
		//리다이렉트시에 model은 사용할 수 없습니다
		ra.addFlashAttribute("msg", "정상 처리되었습니다");
		
		return "redirect:/"; //redirect:/주소(절대경로)
		
	}
	
	
	////////////// quiz
	
	//화면요청
	@RequestMapping("/res_quiz01")
	public String quiz01() {
		return "response/res_quiz01";
	}
	
	@RequestMapping(value = "/joinQuiz", method=RequestMethod.POST)
	public String joinQuiz(@ModelAttribute("id") String id,
						   @ModelAttribute("pw") String pw,
						   RedirectAttributes ra) {
		
		
		if(id.equals("kim12") && pw.equals("1234")) {
			return "response/res_quiz02";
		}
		
		ra.addFlashAttribute("msg", "<script> alert('아이디와 비밀번호가 다릅니다'); </script>");
		//ra.addFlashAttribute("msg", "<script> alert('아이디와 비밀번호가 다릅니다'); location.href='/res_quiz01'; </script>");
				
		return "redirect:/response/res_quiz01";
	}
	

}
