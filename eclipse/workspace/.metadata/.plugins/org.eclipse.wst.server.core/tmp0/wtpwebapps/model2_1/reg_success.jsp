<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>��2 �׽�Ʈ ��� (�⺻) - ��ϰ��</title>
</head>
<body>
���ó���� �����߽��ϴ�.<br/>
����<br/>
id : ${requestScope.custInfo.id }<br/>
pwd : ${requestScope.custInfo.password }<br/>
�̸� : ${requestScope.custInfo.name }<br/>
���� : ${requestScope.custInfo.age }<p/>
<form action="Search" method="post">
	�˻��� ID : <input type="text" name="id"/>
	<input type="submit" value="�˻�"/>
</form>
</body>
</html>