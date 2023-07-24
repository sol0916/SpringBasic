package com.simple.basic.mapper;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.annotations.Param;

import com.simple.command.MemberVO;
import com.simple.command.ScoreVO;

public interface TestMapper {
	
	//xml에서 실행시킬 추상메서드
	public String getTime();
	
	//insert - 단일 값 전달
	public int insertOne(String name);

	//insert - 다중 값 전달 (vo를 통해서 전달하는 게 좋음)
	public int insertTwo(ScoreVO vo);
	
	//insert - 다중 값 전달(맵)
	public int insertThree(HashMap<String, Object> map);
	
	//insert - 매개변수가 여러개 일 때 - Param("이름")
	public int insertFour(@Param("name") String name,
						  @Param("kor") String kor,
						  @Param("eng") String eng);

	
	//update
	public boolean updateOwn(ScoreVO vo);

	
	//select - 파라미터를 넘기는 과정은 위와 동일합니다.
	public ScoreVO selectOne(int num);
	
	//select - 반환유형이 맵
	public HashMap<String, Object> selectTwo(int num);
	
	//select - 한행을 맵으로 처리하는데 여러행이라면
	public ArrayList<HashMap<String, Object>> selectThree();
	
	
	//join처리
	//M:1 방식 => ORM은 M쪽에 변수를 추가
	public ArrayList<ScoreVO> joinOne();
	
	//1:M 방식 => ORM 직접 처리
	public MemberVO joinTwo(String name);
	

}
