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
			<a class="menu" href="/view/readForm.jsp">[정기권조회]</a> 
			<a>[주차차량입,출고]</a>
			<a>[주차현황조회]</a>
	</div>
	<section>
			<h1>주차차량 입고, 출고 관리</h1>
			차량번호 <input type="text" name="carNo"> 
			<input type="submit" value="주차입고" formaction="/view/inputForm">
			<input type="submit" value="주차출고" formaction="/view/outputForm"> <br/>
			<form method="post">
				<table border="1">
					<tr>
						<td width="200">정기권번호</td>
						<td width="400"><input type="text" name="parkNo"></td>
					</tr>
					<tr>
						<td>차량번호</td>
						<td><input type="text" name="carNo" value="${tic.getcarNo }"></td>
					</tr>
					<tr>
						<td>차주전화</td>
						<td><input type="text" name="grade"></td>
					</tr>
					<tr>
						<td>등급</td>
						<td><input type="text" name="grade"></td>
					</tr>
					<tr>
						<td>주차시작일</td>
						<td><input type="text" name="startDate"></td>
					</tr>
					<tr>
						<td>주차종료일</td>
						<td><input type="text" name="endDate"></td>
					</tr>
					<tr>
						<td>비고</td>
						<td><input type="text" name="note"></td>
					</tr>
					<tr>
						<td>다음주차번호</td>
						<td><input type="text" name="nextCarno"></td>
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