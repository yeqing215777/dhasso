<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
	String str = "//signin.e-dunhuang.com/login";
	if(request.getParameter("service") == null || request.getParameter("service") == ""){
		str+="?service="+java.net.URLEncoder.encode(request.getHeader("referer"), "utf-8");
	}
	response.sendRedirect(str);
%>