<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주차 입출고 현황 조회</title>
<style type="text/css">
	td {
		width : 200px;
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
			<h1 style="padding-bottom:50px">주차현황 조회</h1>
			<table border="1">
					<tr>
						<td>주차번호</td>
						<td>차량번호</td>
						<td>주차등급</td>
						<td>상태</td>
						<td>입고일시</td>
						<td>출고일시</td>
					</tr>
					<c:forEach var="info" items="${plistPage}">
						<tr>
							<td>${info.parkNo }</td>
							<td>${info.carNo}</td>
							<td>${info.grade.equals("Y")? "연회원" : info.grade.equals("M")? "월회원" : "일일회원"}</td>
							<td>${info.tstat.equals("I")? "입고" : "출고"}</td>
							<td>${info.inDateStr}</td>
							<td>${info.outDateStr}</td>
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