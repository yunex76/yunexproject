<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>모델2 테스트 결과 (기본) - 조회결과</title>
</head>
<body>
조회한 고객정보<br/>
id : ${requestScope.custInfo.id }<br/>
pwd : ${requestScope.custInfo.password }<br/>
이름 : ${requestScope.custInfo.name }<br/>
나이 : ${requestScope.custInfo.age }<p/>
</body>
</html>