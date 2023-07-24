<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h3>점수 목록</h3>
	
	<!--  ${list } --> <!-- vo => name, kor, eng -->
	<c:forEach var="vo" items="${list }" varStatus="num"> 
	 	${vo.num } <br/>
		${vo.name } <br/>
		${vo.kor } <br/>
		${vo.eng } <br/>
		
		<button onclick="location.href='scoreDelete?num=${vo.num}'">삭제</button>
		<hr/>
	
	</c:forEach>
	
	<a href="scoreRegist">점수 등록하기</a>
	

</body>
</html>