<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="model.CalcService"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>��1 �׽�Ʈ ���</title>
</head>
<body>
<%
	// 1. Ŭ���̾�Ʈ�� ���� ���� 2���� �о�´�. - ��û�� �޴� �۾�
	int num1 = Integer.parseInt(request.getParameter("num1"));
	int num2 = Integer.parseInt(request.getParameter("num2"));
	
	// 2. ���2. Ŭ���̾�Ʈ�� ��û�� �۾��� ó���Ѵ�. - Business Logic �и�
	CalcService cs = new CalcService();
	int sum = cs.plus(num1, num2);
	
	// 3. ����� ��û�� Ŭ���̾�Ʈ�� �����ش�. - ����
%>
<%=num1 %> + <%=num2 %> = <%=sum %>
</body>
</html>