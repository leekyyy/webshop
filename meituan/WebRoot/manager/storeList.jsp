<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*,zhku.lyy.web_shop.entity.*,java.util.*" %>
<%@ include file="checkLogin.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>店铺列表</title>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/addC.css" />
</head>
<body>
	<h1 align="center">商铺列表</h1>
    <table border="1" class="bordered" align="center">
    	<tr>
   			</td>
    	</tr>
    	<tr>
    		<td>用户ID</td>
    		<td>商铺ID</td>
    		<td>商铺名称</td>
    		<td>商铺地址</td>
    		<td>商铺电话</td>
    		<td>开始营业时间</td>
    		<td>结束营业时间</td>
    		<td>配送时间</td>
    		<td>配送费用</td>
    		<td colspan="2">操作</td>
    	</tr>
    	<%
    		request.setCharacterEncoding("UTF-8");
    		List<Store> store = (List<Store>)request.getAttribute("storeList");
    		for(Iterator<Store> it=store.iterator();it.hasNext();){
    			Store s=it.next();
    	%>
	    	<tr>
	    		<td><%=s.getUser_id() %></td>
	    		<td><%=s.getSid() %></td>
	    		<td><%=s.getSname() %></td>
	    		<td><%=s.getSaddress() %></td>
	    		<td><%=s.getStelphone() %></td>
	    		<td><%=s.getStartime() %></td>
	    		<td><%=s.getEndtime() %></td>
	    		<td><%=s.getDeliverytime() %></td>
	    		<td><%=s.getDeliveryfee() %></td>
	    		
	    		<%
    			%>
	    		<td>
	    			<a href="manager/storeModify.jsp?id=<%=s.getSid() %>">修改</a>
	    			<a href="manager/storeDelete.jsp?id=<%=s.getSid() %>" onclick="alert('即将删除该用户');">删除</a>
	    		</td>
	    		<%
    			%>
	    	</tr>
    	<%
    	}
    	%>
    </table>
</body>
</html>