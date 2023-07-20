package com.simple.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.simple.command.Quiz02VO;

@Controller
@RequestMapping("/quiz")
public class QuizController {
	
	
	@RequestMapping("/quiz01")
	public String quiz01() {
		return "quiz/quiz01";
	}
	
	@RequestMapping(value="/quiz01Form", method=RequestMethod.POST)
	public String quiz01Form(@ModelAttribute("year") String year,
							 @ModelAttribute("month") String month,
							 @ModelAttribute("day") String day) {

		return "quiz/quiz01_ok";
	}
	
	
	@RequestMapping("/quiz02")
	public String quiz02() {
		return "quiz/quiz02";
	}
	
	@RequestMapping(value="/join", method=RequestMethod.POST)
	public String join(Quiz02VO vo, Model model) {
		
		model.addAttribute("id", vo.getId());
		model.addAttribute("pw", vo.getPw());
		model.addAttribute("name", vo.getName());
		model.addAttribute("email", vo.getEmail());
		
		return "quiz/quiz02_ok";
	}
	
	
	@RequestMapping("/quiz03")
	public String quiz03() {
		return "quiz/quiz03";
	}
	
	@RequestMapping("/join2")
	public String join2(@ModelAttribute("id") String id,
						@ModelAttribute("pw") String pw,
						@ModelAttribute("pw_check") String pw_check,
						RedirectAttributes ra) {
		
		
		if(id.isEmpty()) {
		ra.addFlashAttribute("msg", "아이디를 입력하세요");
			return "redirect:/quiz/quiz03";
		} else if(!pw.equals(pw_check)) {
		ra.addFlashAttribute("msg2", "비밀번호를 확인하세요");
			return "redirect:/quiz/quiz03";
		}
		
		return "quiz/quiz03_ok";
	}
	


}
