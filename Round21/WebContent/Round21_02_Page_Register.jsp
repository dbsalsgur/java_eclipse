<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register Page!</title>
<script type="text/javascript">
	function isNull2(obj) {
		var data = obj.value;
		if(data == '') {
			alert(obj.name + '필드는 공백일 수 없습니다');
			obj.focus();
			return true;
		}
		return false;
	}
	function check_form() {
		if(isNull2(reg_form.name)) return false;
		if(isNull2(reg_form.id)) return false;
		if(isNull2(reg_form.pw)) return false;
		if(isNull2(reg_form.tel)) return false;
		return true;
	} 
</script>
</head>
<body>
	<div align='center'>
		<h2>Register Page!</h2>
		<form name='reg_form' method='post' onSubmit='return check_form()' action="Round21_02_Page_Register_Process.jsp">
			<table width='300' border='1'>
				<tr>
					<th width='100'>이름</th>
					<td>
					<input type='text' name='name' size='15' />
					</td>
				</tr>
				<tr>
					<th width='100'>아이디 </th>
					<td>
					<input type='text' name='id' size='15'/>
					</td>
				</tr>
				<tr>
					<th>비밀번호 </th>
					<td>
					<input type='password' name='pw' size='15'/>
					</td>
				</tr>
				<tr>
					<th>전화번호 </th>
					<td>
					<input type='text' name='tel' size='15'/>
					</td>
				</tr>
				<tr>
					<td colspan='2' align='right'>
					<input type='submit' value='회원가입'/>
					</td>
				</tr>
 			</table>
		</form>
	</div>
</body>
</html>