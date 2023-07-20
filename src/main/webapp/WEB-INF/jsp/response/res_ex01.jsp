<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h3>모델 전달자(데이터 보내기)</h3>
	
	<a href="ex02">res02</a>
	<a href="ex03">res03</a>
	<a href="ex04?id=aaa123">res04</a>
	
	<form action="ex05" method="post">
		이름:<input type="text" name="name">
		나이:<input type="text" name="age">
		<button>서브밋</button>
	</form>
	
</body>
</html>