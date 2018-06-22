<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*,zhku.lyy.web_shop.entity.*,zhku.lyy.web_shop.dao.*,java.util.*" %>
<%@ include file="checkLogin.jsp" %>
<%
	int id=Integer.parseInt(request.getParameter("id"));
	StoreDao sd = new StoreDao();
	Store s = new Store();
	s.setSid(id);
	sd.deleteStore(s);
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>删除用户</title>
	<link rel="stylesheet" type="text/css"
		href="<%=request.getContextPath()%>/css/addC.css" />
  </head>

   <body>
    <h1 align="center">删除成功</h1><br><a align="center" href="<%=request.getContextPath()%>/GetPageShopServlet?page=0">点击返回用户列表</a>
  </body>
</html>
