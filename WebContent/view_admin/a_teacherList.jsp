<%@page import="cn.etl.entity.Teacher"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
	<tr><th>教工号</th><th>姓名</th><th>密码</th></tr>
	<%List<Teacher> list=(List)request.getAttribute("list"); for(Teacher t:list){ %>
	<tr><td><%=t.gettId() %></td><td><%=t.gettName() %></td><td><%=t.getPassword() %></td><td></td></tr>
	<%} %>
	</table>
</body>
</html>