package com.simple.service;

import org.springframework.stereotype.Service;

import com.simple.command.ScoreVO;

@Service //컴포넌트 스캔에 읽히면 자동으로 빈으로 등록
public class ScoreServiceImpl implements ScoreService {

	@Override
	public void scoreRegist(ScoreVO vo) {
		
		System.out.println(vo.toString());
		
	}
	
}
