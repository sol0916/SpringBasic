package com.simple.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.simple.command.ScoreVO;
import com.simple.service.ScoreService;
import com.simple.service.ScoreServiceImpl;

@Controller
@RequestMapping("/service")
public class ScoreController {

	//1st =>자식 클래스를 부모 인터페이스로 저장
	//필요한 시점에 새로운 객체를 만드는 방식은 스프링에서 권장하지 않음
	//ScoreService service = new ScoreServiceImpl();

	//2nd - 직접 빈등록 자동주입
	//@Autowired
	//ScoreService service;
	
	//3nd
	@Autowired
	ScoreService service;
	
	
	//등록화면
	@RequestMapping("/scoreRegist")
	public String scoreRegist() {
		return "service/scoreRegist";
	}

	//목록화면
	@RequestMapping("/scoreList")
	public String scoreList() {
		return "service/scoreList";
	}

	//결과화면
	@RequestMapping("/scoreResult")
	public String scoreResult() {
		return "service/scoreResult";
	}
	
	//등록요청
	@RequestMapping(value="/scoreForm", method=RequestMethod.POST)
	public String scoreForm(ScoreVO vo) {
		
		//service.scoreRegist(vo);
		
		
		return "";
	}

}
