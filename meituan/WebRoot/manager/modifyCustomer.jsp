<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="checkLogin.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<!-- 导入css样式的时候引入绝对路径 -->
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/modifyC.css" />
<script type="text/javascript"
	src="<%=request.getContextPath()%>/script/jquery-1.7.2.js"></script>
<script type="text/javascript">
	$(function() {
		$("#buttonbin").click(function() {
			//检查输入信息是否不为空格
			//alet("--");
			var $cindexEle = $("#index");
			var reg = /\s/;
			if (!reg.test($cindexEle)) {
				alert("输入信息为空，请重新输入");
				//$cindexEle[0].focus();
				return false;
			}
			return true;
		});

		$("#buttonbin1")
				.click(
						function() {
							//检查密码: 长度为6-12位, 只能输入数字和英文,可以不输入
							var $passwordEle = $("#password");
							reg = /^[a-zA-Z0-9]{6,12}$/;
							if ($passwordEle.val() != ""
									&& !reg.test($passwordEle.val())) {
								alert("密码的长度为6-12位, 只能输入数字和英文");
								$passwordEle[0].focus();
								return false;
							}
							return true;
						});
		
		// 检查重复名
		$("#name").blur( function() {
								var url = "${pageContext.request.contextPath}/AddCustomerServlet";
								$.post(url,{
											method : "checkNameExist",
											customerName : this.value
											},
										function(data) {
											if (data == "true") {
												$("#result").html("&nbsp;<font color='red'>此姓名已存在</font>");
											} else {
												$("#result").html("&nbsp;<font color='blue'>姓名未入数据库,可用</font>");
											}
								});
		});

	});
</script>
</head>
<body>
	<form action="<%=request.getContextPath()%>/GetCustomerServlet"
		method="post">
		<fieldset>
			<legend>
				<font color="#FFFFFF">客户信息查找栏</font>
			</legend>
			<table>
				<tr>
					<td><input type="text" class="input"
						placeholder="请输入你要修改的客户姓名" id="index" name="cindex">
						<input type="submit" class="but" id="buttonbin" value="搜索"></td>
				</tr>
			</table>
		</fieldset>
	</form>
	<br>
	<br>
	<fieldset>
		<legend>
			<font color="#FFFFFF">客户信息显示栏</font>
		</legend>
		<c:choose>
			<c:when test="${empty Customer}">
				<font color="#FFFFFF">您输入的是:${requestScope.result}<br> <br>无此用户信息，请检查您是否已搜索或客户姓名填写是否正确。
				</font>
			</c:when>
			<c:when test="${!empty Customer}">
				<table class="bordered" bgcolor="#FFFFFF">
					<tr>
						<td width="50px">Name(*)</td>
						<td width="105px">Password</td>
						<td width="105px">用户类型</td>
					</tr>
					<tr>
						<td width="50px">${Customer.username}</td>
						<td width="105px">${Customer.password}</td>
						<td width="105px">${Customer.uTypeid}</td>
					</tr>
				</table>
			</c:when>
		</c:choose>

	</fieldset>
	<br>
	<br>
	<form action="<%=request.getContextPath()%>/ModifyCustomerServlet"
		method="post">
		<fieldset>
			<legend>
				<font color="#FFFFFF">客户信息修改栏</font>
			</legend>
			<c:choose>
				<c:when test="${empty Customer}">
					<font color="#FFFFFF">请先进行查询操作。</font>
				</c:when>
				<c:when test="${!empty Customer}">
					<table class="bordered" bgcolor="#FFFFFF">
						<tr>
							<td>Name(*)</td>
							<td>Password</td>
							<td>uTypeid</td>
						</tr>
						<tr>
							<td width="50px"><input type="text" class="input1"
								name="CName" id="name" value="${Customer.username}"></td>
							<td width="105px"><input type="text" class="input1"
								name="CPassword" id="password" value="${Customer.password}"></td>
							<td width="105px"><input type="text" class="input1"
								name="CGender" id="gender" value="${Customer.uTypeid}"></td>
						</tr>
						<tr>
						<td><span
						id="result"></span></td>
						</tr>
					</table>
					<br>
					<font color="#FFFFFF">Tips：直接在上方表格中直接输入对应的修改内容，姓名一定要有，其他信息无需修改的可以不输入。</font>
					<table>
						<tr>
							<td><input type="hidden" id="id" name="Id"
								value="${Customer.id}"> <input type="submit"
								id="buttonbin1" class="but1" value="提交"></td>
						</tr>
					</table>
				</c:when>
			</c:choose>
		</fieldset>
	</form>
</body>
</html>