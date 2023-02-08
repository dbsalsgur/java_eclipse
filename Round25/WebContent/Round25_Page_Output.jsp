<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page isELIgnored="false" %>

<% request.setCharacterEncoding("utf-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Output Data</title>
</head>
<body>
	initParam ipAddress : ${ initParam.ipAddress }<br/><br/>
	
	Application URI : ${ applicationScope.uri }<br/><br/>
	
	Session 아이디 : ${ sessionScope.id }<br/>
	Session 비밀번호 : ${ sessionScope.pw }<br/><br/>
	
	Request 이름 : ${ param.name }<br/>
	Request 주소 : ${ param.addr }<br/><br/>
	
	0번 과목 : ${ sessionScope.subject[0] }<br/>
	1번 과목 : ${ sessionScope.subject[1] }<br/>
	2번 과목 : ${ sessionScope.subject[2] }<br/><br/>
	
	0번 선택 내용 : ${ paramValues.language[0] }<br/>
	1번 선택 내용 : ${ paramValues.language[1] }<br/>
	2번 선택 내용 : ${ paramValues.language[2] }<br/>
</body>
</html>