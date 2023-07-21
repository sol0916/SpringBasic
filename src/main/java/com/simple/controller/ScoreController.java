package com.simple.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
	@Qualifier("scoreService")
	ScoreService scoreService;
	
	
	//등록화면
	@RequestMapping("/scoreRegist")
	public String scoreRegist() {
		return "service/scoreRegist";
	}

	//목록화면
	@RequestMapping("/scoreList")
	public String scoreList(Model model) {
		
		//반환 받은 데이터
		ArrayList<ScoreVO> list = scoreService.getScores();
		model.addAttribute("list", list);
		
		
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
		
		scoreService.scoreRegist(vo);
		
		
		return "redirect:/service/scoreResult"; //등록 이후에 결과 화면으로
	}
	
	//삭제요청
	@RequestMapping("/scoreDelete")
	public String scoreDelete(@RequestParam("num") int index) {
		
		scoreService.scoreDelete(index);
		
		return "redirect:/service/scoreList"; //삭제 이후에는 목록으로
	}

}
