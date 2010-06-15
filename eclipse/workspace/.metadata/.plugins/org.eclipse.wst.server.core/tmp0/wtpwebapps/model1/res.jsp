<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="model.CalcService"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>모델1 테스트 결과</title>
</head>
<body>
<%
	// 1. 클라이언트가 보낸 숫자 2개를 읽어온다. - 요청을 받는 작업
	int num1 = Integer.parseInt(request.getParameter("num1"));
	int num2 = Integer.parseInt(request.getParameter("num2"));
	
	// 2. 방법2. 클라이언트가 요청한 작업을 처리한다. - Business Logic 분리
	CalcService cs = new CalcService();
	int sum = cs.plus(num1, num2);
	
	// 3. 결과를 요청한 클라이언트에 보내준다. - 응답
%>
<%=num1 %> + <%=num2 %> = <%=sum %>
</body>
</html>