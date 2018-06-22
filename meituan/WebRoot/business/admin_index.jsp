<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
// String path = request.getContextPath();
// String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<html>
  <head>
    <title>管理员主页</title>
    <link href="/meituan/business/css/bootstrap.min.css" type="text/css" rel="stylesheet">
    <link href="/meituan/business/css/admin_index.css" type="text/css" rel="stylesheet">
    <link href="/meituan/business/css/public.css" type="text/css" rel="stylesheet">
    <!-- jQuery (Bootstrap 的 JavaScript 插件需要引入 jQuery) -->
	<script src="/meituan/business/js/jquery-3.3.1.js" type="text/javascript"></script>
	<script src="/meituan/business/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/meituan/business/js/admin_index.js"></script>
    <script src="/meituan/business/js/modify.js"></script>
  </head>
  
  <body>
    <form action="" method="post">
    	<nav class="navbar navbar-default">
    		<div class="navbar-header">${username}，欢迎来到美团商家后台管理！</div>
    		<div class="navbar-text">
				<a href="javascript:;" onclick="$('#admin').modal('show')">个人中心</a>&nbsp;&nbsp;
				<a href="javascript:;" onclick="$('#editAdmin').modal('show')">修改密码</a>&nbsp;&nbsp;
				<a href="/meituan/QuitController">注销</a>
			</div>
    	</nav>
    	<div class="container">
    		<div class="navLeft">
    			<table>
    				<tr align="center" class="active">
    					<td><a href="../stores/stores.jsp" target="manage" id="user_manage"><span id="userSpan">店铺信息管理</span></a></td>
    				</tr>
    				<tr align="center" class="active">
    					<td><a href="../merchandise/merchandise.jsp" target="manage" id="user_manage"><span id="userSpan">商品信息管理</span></a></td>
    				</tr>
    				<tr align="center" class="active">
    					<td><a href="../order/order.jsp" target="manage" id="user_manage"><span id="userSpan">订单信息管理</span></a></td>
    				</tr>
    				
    			</table>
    		</div>
    		<iframe class="navRight" src="../stores/stores.jsp" name="manage">
    			
    		</iframe>
    	</div>
    	<div class="f">
		    <span> ©2015 meituan.com 京ICP证070791号 京公网安备11010502025545号</span>
    	</div>
    </form>
   <button id="addUserButton" data-toggle="modal" data-target="#addUser" class="hide"></button>
    <!-- 添加用户信息模态框（Modal） -->
    <form id="addUserForm" action="userinfo?method=addUserinfo&type=2&currentPage=1&searchName=" method="post" target="manage">
		<div class="modal fade" id="addUser" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		   <div class="modal-dialog">
		      <div class="modal-content">
		         <div class="modal-header">
		            <button type="button" class="close" 
		               data-dismiss="modal" aria-hidden="true">
		                  &times;
		            </button>
		            <h4 class="modal-title" id="myModalLabel">添加用户信息</h4>
		         </div>
		         <table>
		         	<tr>
		         		<td>用户账号：</td>
		         		<td><input type="text" name="userName" id="addName" class="form-control" required /></td>
		         	</tr>
		         	<tr>
		         		<td>用户密码：</td>
		         		<td><input type="password" name="password" class="form-control" required /></td>
		         	</tr>
		         	<tr>
		         		<td>宝贝年龄：</td>
		         		<td>
		         			<select class="form-control" name="babyAge">
						        <option value="">请选择</option>
						        <option value="1">1</option>
						        <option value="2">2</option>
						        <option value="3">3</option>
						        <option value="4">4</option>
						        <option value="5">5</option>
						        <option value="6">6</option>
						     </select>
						</td>
		         	</tr>
		         	<tr>
		         		<td>电子邮箱：</td>
		         		<td><input type="email" name="email" class="form-control" /></td>
		         	</tr>
		         	<tr>
		         		<td>手机号码：</td>
		         		<td><input type="text" name="phone" class="form-control" /></td>
		         	</tr>
		         </table>
		         <div class="modal-footer">
		            <button type="submit" class="btn btn-primary">添加</button>
		            <button type="button" class="btn btn-default" 
		               data-dismiss="modal">关闭</button>
		         </div>
		      </div>
			</div>
		</div>
	</form>
    <button id="editUserButton" data-toggle="modal" data-target="#editUser" class="hide"></button>
    
	
	
	

	<!-- 修改密码模态框（Modal） -->
<!--     <form id="" action="" method="post"> -->
		<div class="modal fade" id="editAdmin" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		   <div class="modal-dialog">
		      <div class="modal-content">
		         <div class="modal-header">
		            <button type="button" class="close" 
		               data-dismiss="modal" aria-hidden="true">
		                  &times;
		            </button>
		            <h4 class="modal-title" id="myModalLabel">修改密码</h4>
		         </div>
		         <table>
		         	<tr>
		         		<td>编号：<input type="hidden" name="uid" id="uid" value="${uid }"></td>
		         		<td>${uid}</td>
		         	</tr>
		         	<tr>
		         		<td>账号：<input type="hidden" name="username" id="username"  class="form-control" value="${username }" required /></td>
		         		<td>${username}</td>
		         	</tr>
		         	<tr>
		         		<td>密码：</td>
		         		<td><input type="password" name="password" id="password" class="form-control" value="${password }" required /></td>
		         	</tr>
		         </table>
		         <div class="modal-footer">
		            <button id="change" class="btn btn-primary">提交更改</button>
		            <button type="button" class="btn btn-default" 
		               data-dismiss="modal">关闭</button>
		         </div>
		      </div>
			</div>
		</div>
<!-- 	</form> -->
	<!-- 个人中心模态框（Modal） -->
	<div class="modal fade" id="admin" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	   <div class="modal-dialog" style="width:300px">
	      <div class="modal-content">
	         <div class="modal-header">
	            <button type="button" class="close" 
	               data-dismiss="modal" aria-hidden="true">
	                  &times;
	            </button>
	            <h4 class="modal-title" id="myModalLabel">个人中心</h4>
	         </div>
	         <table>
	         	<tr>
	         		<td>账号：</td>
	         		<td>${username }</td>
	         	</tr>
	         	<tr>
	         		<td>密码：</td>
	         		<td>${password }</td>
	         	</tr>
	         </table>
	         <div class="modal-footer">
	            <button type="button" class="btn btn-default" 
	               data-dismiss="modal">关闭</button>
	         </div>
	      </div>
		</div>
	</div>
  </body>
</html>
