<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Board Write!</title>
<script type="text/javascript">
	function move_list() {
		location.href='Round23_Page_BBS_List.jsp';
	}
</script>
</head>
<body>
	<div align='center'>
		<h2>게시판 글쓰기</h2>
		<form action="Round23_Page_BBS_Write_Process.jsp">
		<table border='1' width='500'>
			<tr>
				<th width='150'>
					글제목
				</th>
				<td>
					<input type='text' name='content_title' size='40'/>
				</td>
			</tr>
			<tr>
				<th width='150'>
					작성자
				</th>
				<td>
					<input type='text' name='content_writer' size='40'/>
				</td>
			</tr>
			<tr>
				<td colspan='2'>
					<textarea name='content_contents' rows="8" cols="60"></textarea>
				</td>
			</tr>
		</table>
		<table border='0' width='500'>
			<tr>
				<td align='left'>
					<input type='button' value='리스트로' onCLick='move_list()'/> &nbsp;
				</td>
				<td align='right'>
					<input type='submit' value='글쓰기'/>
					<input type='reset' value='초기화'/>
				</td>
			</tr>
		</table>
		</form>
	</div>
</body>
</html>