<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<%--
	1. res_quiz01 파일의 화면처리를 할 수 있는 메서드를 생성하세요. (res_quiz01 맵핑)
	2. 폼태그의 맵핑은 res_login 으로 맵핑하세요.
	3. ID:kim12, PW:1234 라면 res_quiz02페이지로 이동해서 "로그인 성공" "ID님 환영합니다" 출력
	4. 아니라면 다시 로그인창으로 이동해서 alert()을 띄워주세요.
	
	--%>
	
	<form action="joinQuiz" method="post">
		ID: <input type="text" name="id" size="10"><br>
		PW: <input type="password" name="pw" size="10"><br>
		<input type="submit" value="로그인">
	</form>
	
	${msg }
	
	<!--<script> 
      var msg = '${msg}'
      if(msg != ''){
         alert(msg);
      }
   </script> -->
	
	
</body>
</html>