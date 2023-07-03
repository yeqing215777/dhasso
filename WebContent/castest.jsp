<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>用户信息</title>
</head>
<body>
用户信息${pageContext.request.userPrincipal.attributes.email}
<br>
${pageContext.request.userPrincipal}
${pageContext.request.userPrincipal.attributes.first_name}
<a href='/login.jsp'>登录</a>
<a href='/logout.jsp'>退出登录</a>

<a href='http://192.168.1.9:8888/castest.jsp'>测试跳转</a>
</body>
</html>