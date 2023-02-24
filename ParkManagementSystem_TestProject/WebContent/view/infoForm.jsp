<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주차차량 입고, 출고 관리</title>

</head>
<link rel="stylesheet" href="../style.css">
<body>
	<header>
		<div align="center">
			<h1>주차관리 프로그램 ver 1.0</h1>
		</div>
	</header>
	<div id="menus">
		<a href="regist.do">[정기권등록]</a>&nbsp;&nbsp;&nbsp;&nbsp; <a
			href="read.do">[정기권조회]</a>&nbsp;&nbsp;&nbsp;&nbsp; <a>[주차차량입,출고]</a>&nbsp;&nbsp;&nbsp;&nbsp;
		<a>[주차현황조회]</a>
	</div>
	<section>
			<h1>주차차량 입고, 출고 관리</h1>
			차량번호 <input type="text" name="carno"> 
			<input type="button" name="input" value="주차입고"> 
			<input type="button" name="output" value="주차출고"> <br>
	</section>
	<footer>
		<div align="center">
			<p>
				<span>MHCorp. Copyright@2023 All rights reserved </span>
			</p>
		</div>
	</footer>
</body>
</html>