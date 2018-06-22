<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.Date,zhku.lyy.web_shop.entity.*,zhku.lyy.web_shop.dao.*,java.util.*" %>
<%
/* User user = (User) session.getAttribute("user");// 在session中查找已存在的用户信息 */
   String user = (String)request.getSession().getAttribute("user");
// 找到用户信息则已登录，否则返回登录界面，重新登录
if (user == null) {
	response.sendRedirect("/meituan/login/login.html");// 请求转发，地址栏不会变化
}
%>