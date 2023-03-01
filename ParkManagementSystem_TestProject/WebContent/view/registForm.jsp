<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주차 정기권 등록</title>
<script type="text/javascript">
	function registCheck() {
		alert('정기주차권 등록이 완료되었습니다');
	}
	function moveRead() {
		location.href = "/view/readForm";
	}
</script>
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
			<a class="menu" href="/view/infoForm.jsp">[주차차량입,출고]</a>
			<a>[주차현황조회]</a>
		</div>
	<section>
		<form method="post" onSubmit="registCheck()" action="regist.do">
		<div align="center">
			<h1 style="padding-bottom:50px">주차 정기권 등록</h1>
			<table border="1">
				<tr>
					<td width="200">정기권번호</td>
					<td width="200"><input type="text" name="tno"></td>
				</tr>
				<tr>
					<td>차량번호</td>
					<td><input type="text" id="carNo" name="carno"></td>
				</tr>
				<tr>
					<td>차주전화</td>
					<td><input type="text" name="phone"></td>
				</tr>
				<tr>
					<td>주차등급(M/Y)</td>
					<td><input type="text" name="grade"></td>
				</tr>
				<tr>
					<td>정기권상태(Y/N)</td>
					<td><input type="text" name="tstat"></td>
				</tr>
				<tr>
					<td>시작일</td>
					<td><input type="text" name="startDate"></td>
				</tr>
				<tr>
					<td>종료일</td>
					<td><input type="text" name="endDate"></td>
				</tr>
				<tr height=>
					<td colspan="2"><input type="submit" value="등록" >
						<input type="button"  value="조회" onClick="return moveRead()">
						</td>
				</tr>
			</table>
		</div>
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