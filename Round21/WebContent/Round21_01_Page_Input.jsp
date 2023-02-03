<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>입력페이지!</title>
<script type="text/javascript">
	var cnt = 1;
	 
	funtion addRow() {
		var area = document.getElementById('area');
		var insert = area.insertRow(cnt+1);
		var subject = "<input type='text' name='subject' size='8'/>";
		insert.insertCell().innerHTML = subject;
		var jumsu = "<input type='text' name='jumsu' size='15'/>";
		insert.insertCell().innerHTML = jumsu;
		
		cnt++;
	}
	
	funtion delRow() {
		if(cnt == 1) {
			alert('더 이상 삭제할 수 없습니다.');
			return;
		}
		var area = document.getElementById('area');
		area.deleteRow();
		
		cnt--;
	}
	
	function check_form() {
		var name = calc_form.name.value;
		if(name == '') {
			alert('수험자 이름을 기재하세요!');
			calc_form.name.focus();
			return false;
		}
		
		if(cnt == 1) {
			var subject = calc_form.subject.value;
			var jumsu = calc_form.jumsu.value;
			if(subject == '' || jumsu == '' || isNaN(jumsu)) {
				alert('과목명이 비었거나 점수가 숫자가 아닙니다.');
				return false;
			} 
		} else {
			for(i = 0; i < cnt; ++i) {
				var subject = calc_form.subject[i].value;
				var jumsu = calc_form.jumsu[i].value;
				if(subject == '' || jumsu == '' || isNaN(jumsu)) {
					alert('과목명이 비었거나 점수가 숫자가 아닙니다.');
					return false;
				} 
			}
		}
		
	}
</script>
</head>
<body>
	<div align='center'>
		<h2>성적 계산!</h2>
		<form name='calc_form' method='post' action="Round21_01_Page_Output.jsp" onSubmit='return check_form()'>
			이름 : <input type='text' name='name'/><br/>
			<h3> < 과목과 점수 > </h3>
			<input type='button' value='추가' onClick='addRow()'/>
			<input type='button' value='삭제' onClick='delRow()'/>
			<input type='submit' value='계산'/><br/><br/>
			<table id='area' width='300' border='1'>
				<tr> <th width='100'>과목 </th>
				<th width='200'>점수 </th> </tr>
				<tr> 
					<td> <input type='text' name='subject' size='8'/></td>
					<td> <input type='text' name='jumsu' size='15'/></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>