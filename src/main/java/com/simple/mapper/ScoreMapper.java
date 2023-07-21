package com.simple.mapper;

import java.util.ArrayList;

import com.simple.command.ScoreVO;

public interface ScoreMapper {
	
	public void scoreRegist(ScoreVO vo); //등록
	public ArrayList<ScoreVO> getScores(); //조회 
	public void scoreDelete(int index); //삭제

}
