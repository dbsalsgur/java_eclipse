<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주차차량 입고</title>
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
			<input type="submit" value="주차출고" formaction="/searchParkInfo.do"> <br/>
		</form>
		<form method="post" action="/input.do" onSubmit="return check_form()">
			<table border="1">
				<tr>
					<td width="200">차량번호</td>
					<td width="400"><input type="text" name="carNo" value="${ param.carNo }"></td>
				</tr>
				<tr>
					<td>등급</td>
					<td><input type="text" name="grade" value="D"></td>
				</tr>
				<tr>
					<td>입고일시</td>
					<td><input type="text" value="${ inDate }"></td>
				</tr>
				<tr>
					<td>출고일시</td>
					<td><input type="text"></td>
				</tr>
				<tr>
					<td>비고</td>
					<td><input type="text" value="입차 준비 중입니다"></td>
				</tr>
			</table><br/>
			<input type="submit" value="입고확인">
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