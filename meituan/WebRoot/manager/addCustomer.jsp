<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="checkLogin.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<!-- 导入css样式的时候引入绝对路径 -->
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/addC.css" />
<script type="text/javascript"
	src="<%=request.getContextPath()%>/script/jquery-1.7.2.js"></script>
<script type="text/javascript">
	$(function() {
		$("#bubmitBtn")
				.click(
						function() {

							//检查密码: 长度为6-12位, 只能输入数字和英文
							var $passwordEle = $("#password1");
							reg = /^[a-zA-Z0-9]{6,12}$/;
							if (!reg.test($passwordEle.val())) {
								alert("密码的长度为6-12位, 只能输入数字和英文");
								$passwordEle[0].focus();
								return false;
							}

							//确认密码必须与密码相同
							var $password2Ele = $("#password2");
							if ($password2Ele.val() != $passwordEle.val()) {
								$password2Ele[0].focus();
								alert("确认密码必须与密码相同");
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
	<form method="post"
		action="<%=request.getContextPath()%>/AddCustomerServlet?method=addCustomer">
		<fieldset>
			<legend>客户信息</legend>
			<table align="center">
				<tr>
					<td>姓名(*):</td>
					<td><input type="text" name="CName" id="name"><span
						id="result"></span></td>
				</tr>
				<tr>
					<td>密码(*):</td>
					<td><input type="password" name="CPassword1" id="password1"></td>
				</tr>
				<tr>
					<td>再次确认密码(*):</td>
					<td><input type="password" name="CPassword2" id="password2"></td>
				</tr>
				<tr>
					<td>用户类型</td>
					<td><input type="text" name="uTypeId" id="uTypeId"><span
						id="result1"></span></td>
				</tr>
				<tr align="center">
					<td colspan="2"><br> <br> <input type="submit"
						name="button" id="bubmitBtn" class="but" value="提交"></td>
				</tr>
			</table>
		</fieldset>
	</form>
</body>
</html>