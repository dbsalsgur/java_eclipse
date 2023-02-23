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
		locationl.href = "/view/readForm";
	}
</script>
</head>
<body>
	<div align="center">
		<h1>주차관리 프로그램 ver 1.0</h1>
	</div>
	<a>[정기권등록]</a>&nbsp;&nbsp;&nbsp;&nbsp;
	<a>[정기권조회]</a>&nbsp;&nbsp;&nbsp;&nbsp;
	<a>[주차차량입,출고]</a>&nbsp;&nbsp;&nbsp;&nbsp;
	<a>[주차현황조회]</a>
	<form method="post" onSubmit="registCheck()" action="regist.do">
		<div align="center">
			<h1>주차 정기권 등록</h1>
			<table border="1">
				<tr>
					<td width="250">정기권번호</td>
					<td width="250"><input type="text" name="tno"></td>
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
				<tr>
					<td colspan="2"><input type="submit" value="등록" >
						<input type="button"  value="조회" onClick="return moveRead()">
				</tr>
			</table>
		</div>
	</form>

</body>
</html>