<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page info="쇼핑몰 페이지" %>
<%@ page session="true" %>

<%
	String[] img = new String[] {
			"뉴진스_하니","뉴진스_하니2","뉴진스_하니3","뉴진스_민지","뉴진스_민지2","뉴진스_민지3","뉴진스_혜인","뉴진스_다니엘", "뉴진스_해린"
	};
	String[] name = new String[] {
			"뉴진스_하니","뉴진스_하니2","뉴진스_하니3","뉴진스_민지","뉴진스_민지2","뉴진스_민지3","뉴진스_혜인","뉴진스_다니엘", "뉴진스_해린"
	};
	String[] price = new String[] {
			"20,000", "32,000", "29,000", "35,000", "29,000", "25,000", "32,000", "28,000", "30,000"
	};
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>프리렉 쇼핑몰!</title>
<script type="text/javascript">
	function jang(name, price) {
		location.href='Round22_04_Page_JangProcess.jsp?name=' + name  + '&price=' + price;
	}
	
	function move_jang() {
		location.href = './Round22_04_Page_Baguni.jsp';
	}
</script>
</head>
<body>
	<div align='center'>
	<h2>프리렉 쇼핑몰!</h2>
		<table width='400' border='0'>
			<tr>
				<td align='right' colspan='3'>
					<input type='button' value='내 장바구니' onClick='move_jang()' style='border:none'/>
				</td>
			</tr>
			<%
			for(int i = 0; i < img.length; ++i) {
				if(i%3 == 0) out.println("<tr>");
				out.println("<td><table border='0'>");
				out.println("<tr height='100'><td align='center'>");
				out.println("<img src='./images/" +img[i] + ".jpg'");
				out.println("width='80' height='100'/>");
				out.println("</td></tr>");
				
				out.println("<tr height='20'><td align='center'>");
				out.println("<B>" +name[i]+"</B></td></tr>");
				out.println("<tr height='20'><td align='center'>");
				out.println("가격 : " + price[i]+ "원</td></tr>");
				out.println("<tr height='20'><td align='right'>");
				
				out.println("<input type='button' value='담기'");
				out.println("onClick='jang(\"" +name[i] + "\", \"" + price[i] + "\")' style='border:none'/>");
				
				out.println("</td></tr>");
				out.println("</table></td>");
			}
			%>
		</table>
	</div>
</body>
</html>