<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="java.sql.Date,zhku.lyy.web_shop.entity.*,zhku.lyy.web_shop.dao.*,java.util.*" %>
<%@ include file="checkLogin.jsp" %>
<%
	request.setCharacterEncoding("UTF-8");
	String action=request.getParameter("action");
	
	if(action!=null && action.equals("modify")){
		int sid = Integer.parseInt(request.getParameter("sid"));
		String sname = request.getParameter("sname");
		String saddress = request.getParameter("saddress");
		String stelphone = request.getParameter("stelphone");
		String startime = request.getParameter("startime");
		String endtime = request.getParameter("endtime");
		int deliverytime = Integer.parseInt(request.getParameter("deliverytime"));
		int deliveryfee = Integer.parseInt(request.getParameter("deliveryfee"));
		
		StoreDao sd = new StoreDao();
		
		Store s=new Store(sname,saddress,stelphone,startime,endtime,deliverytime,deliveryfee);
		s.setSid(sid);
		sd.modifyStore(s);
%>
<head>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/addC.css" />
</head>
<h1 align="center">修改成功<h1>
<a href="<%=request.getContextPath()%>/GetPageShopServlet?page=0">点击返回主界面</a>
<%
return;
}
%>

<%
	String strId = request.getParameter("id");
	int id = Integer.parseInt(strId);
	StoreDao sd = new StoreDao();
	Store s = sd.getStoreById(id);
%>
<!DOCTYPE HTML PUBLIC 
>
<html>
  <head>
	<title>修改商铺</title>
	<meta http-equiv="content-type" content="text/html; charset=gb2312">
	<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/addC.css" />
  </head>
  <body background-position:center; background-repeat:no-repeat">
  <form action="storeModify.jsp" method="post" align="center">
    <input type="hidden" name="action" value="modify">
    <input type="hidden" name="pid" value="<%=id%>">
    	<table border="1" class="bordered" align="center">
    		<tr>
    			<td colspan="2" align="center">修改商铺信息</td>
    		</tr>
    		<tr>
    			<td>店铺ID：</td>
    			<td><input type="text" readonly="readonly" name="sid" value="<%=s.getSid() %>" ></td>
    		</tr>
    		<tr>
    			<td>店铺名称：</td>
    			<td><input type="text" name="sname" value="<%=s.getSname() %>"></td>
    		</tr>
    		<tr>
    			<td>店铺地址：</td>
    			<td><input type="text" name="saddress" value="<%=s.getSaddress() %>"></td>
    		</tr>
    		<tr>
    			<td>送餐电话：</td>
    			<td><input type="text" name="stelphone" value="<%=s.getStelphone() %>"></td>
    		</tr>
    		<tr>
    			<td>营业开始时间：</td>
    			<td><input type="text" name="startime" value="<%=s.getStartime() %>"></td>
    		</tr>
    		<tr>
    			<td>营业结束时间：</td>
    			<td><input type="text" name="endtime" value="<%=s.getEndtime() %>"></td>
    		</tr>
    		<tr>
    			<td>送货时间：</td>
    			<td><input type="text" name="deliverytime" value="<%=s.getDeliverytime() %>"></td>
    		</tr>
    		<tr>
    			<td>送货费用：</td>
    			<td><input type="text" name="deliveryfee" value="<%=s.getDeliveryfee() %>"></td>
    		</tr>
    		<tr>
    			<td colspan="2" align="center"><input type="submit" value="修改"></td>
    		</tr>
    	</table>
    </form>
  </body>
</html>
