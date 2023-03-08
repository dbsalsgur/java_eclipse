<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주차차량 입고, 출고 관리</title>

</head>
<link rel="stylesheet" href="/style.css">
<body>
<div id="wrap">
	<header>
		<div align="center">
			<h1>주차관리 프로그램 ver 1.0</h1>
		</div>
	</header>
	<div id="menus">
			<a class="menu" href="/regist.do">[정기권등록]</a> 
			<a class="menu" href="/readTic.do">[정기권조회]</a> 
			<a class="menu" href="/view/infoForm.jsp">[주차차량입,출고]</a> 
			<a class="menu" href="/readPark.do">[주차현황조회]</a>
		</div>
	<section>
			<form method="post">
				<h1>주차차량 입고, 출고 관리</h1>
				차량번호 <input type="text" name="carNo"> 
				<input type="submit" value="주차입고" formaction="/searchTicket.do">
				<input type="submit" value="주차출고" formaction="/searchParkInfo.do"> 
				<c:if test="${errors.carNo }">차량번호를 입력하세요. </c:if><br/>
			</form>
	</section>
	<footer>
		<div align="center">
			<p>
				<span>MHCorp. Copyright@2023 All rights reserved </span>
			</p>
		</div>
	</footer>
</div>
</body>
</html>