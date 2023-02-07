<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page info="장바구니 처리" %>
<%@ page import="java.util.*, round22.base.*" %>
<%@ page session="true" %>

<% 
	ArrayList baguni = null;
	Object obj = session.getAttribute("jang");
	
	if(obj==null) baguni = new ArrayList();
	else baguni = (ArrayList)obj;
	request.setCharacterEncoding("utf-8");
	
	String name = request.getParameter("name");
	String price = request.getParameter("price");
	
	int pos = -1;
	for(int i  = 0; i< baguni.size(); ++i) {
		JangBaguni jang = (JangBaguni)baguni.get(i);
		if(jang.getName().equals(name)) {
			pos = i;
			jang.setCnt(jang.getCnt() + 1);
			break;
		}
	}
	
	if(pos == -1) {
		JangBaguni jang = new JangBaguni();
		jang.setName(name);
		jang.setPrice(Integer.parseInt(price.replace(",", "")));
		
		jang.setCnt(1);
		baguni.add(jang);
	}
	
	session.setAttribute("jang", baguni);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	alert('장바구니에 담았습니다');
	history.go(-1);
</script>
</head>
<body>

</body>
</html>