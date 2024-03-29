<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주차 정기권 조회</title>
<style type="text/css">
td {
	width: 150px;
}
</style>
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
			<div align="center">
				<h1 style="padding-bottom: 50px">정기권 조회</h1>
				<table border="1">
					<tr>
						<td>정기권번호</td>
						<td>차량번호</td>
						<td>차주전화</td>
						<td>주차등급</td>
						<td>정기권상태</td>
						<td>주차시작일</td>
						<td>주차종료일</td>
					</tr>
					<c:forEach var="ticket" items="${tlistPage}">
						<tr>
							<td>${ticket.tno }</td>
							<td>${ticket.carno}</td>
							<td>${ticket.phone}</td>
							<td>${ticket.grade.equals("Y")? "연회원" : "월회원"}</td>
							<td>${ticket.tstat}</td>
							<td>${ticket.startDateStr}</td>
							<td>${ticket.endDateStr}</td>
						</tr>
					</c:forEach>
				</table>
			</div>
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