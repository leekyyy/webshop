<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    
    <title>"订单信息管理页面"</title>
	<link href="/meituan/bootstrap/css/bootstrap.min.css" type="text/css" rel="stylesheet">
	<script src="/meituan/business/js/jquery-3.3.1.js"></script>
	<script src="/meituan/bootstrap/js/bootstrap.min.js"></script>
  </head>
  
  <body>
     
<div class='row'>
  	<div class="col-md-12">
	    <div class="input-group" style="margin: 20px 0 40px 30px">
	    		<button type="submit" class="btn btn-primary" onclick="to_order()">新的订单</button>
				<button style="margin-left: 30px" type="button" class="btn btn-primary" onclick="deliver()" >送餐订单</button>

				<button style="margin-left: 30px" type="button" class="btn btn-primary" onclick="finish()">已完成订单</button>

			
  		</div>
  	</div>
</div>

<script>
	/* 新的订单 */
	function to_order(){
		var sid = ${sid};
		window.location = "/meituan/NewOrder?sid="+sid+"&state=1";
	}
	
	/* 正在送餐 */
	function deliver (){
		var sid = ${sid};
		window.location = "/meituan/NewOrder?sid="+sid+"&state=2";
	}
	
	/* 已完成 */
	function finish (){
		var sid = ${sid};
		window.location = "/meituan/NewOrder?sid="+sid+"&state=3";
	}
	/* 
	function jiedan(){
		var oid = $("button.jiedan_order").data("oid");
		window.location = "/meituan/DeliveryOrder?oid="+oid+"";
	} */
	
	$(function(){
		$("button.jiedan_order").click(function(){
				var oid = $(this).data("oid");
				$.ajax({
			  		url: '/meituan/DeliveryOrder',
			  		type: 'post',
			  		data: {
			  			oid: oid
			  		},
			  		success: function(){
			  			$("#neworder").find("tr#"+oid+"").remove();
			  		}
			  	})
			  	
		})
	})
	
</script>


<!-- 新的订单 -->
<table class="table table-hover" id="neworder">
    	<tr>
    		<th>用户id</th>
    		<th>订单时间</th>
    		<th>订单金额</th>
    		<th>地址</th>
    		<th>电话</th>
    		<th>留言</th>	
    		<th>操作</th>
    	</tr>
<c:forEach var="user" items="${neworder}" varStatus="vs">
<tr id=${user.oid }>
	<td>${user.user_id}</td>
	<td>${user.ordertime }</td>
	<td>${user.omoney }</td>
	<td>${user.receiveraddr }</td>
	<td>${user.telphone }</td>
	<td>${user.message }</td>
	<td>
	<c:if test="${user.state == 1}">
		<button type='button' data-oid="${user.oid }" class='btn btn-primary jiedan_order' style='width:58px;height:32px;line-height:32px;padding: 0' >接单</button>
	</c:if>
	<c:if test="${user.state == 2}">
		正在送餐
	</c:if>
	<c:if test="${user.state == 3}">
		已完成
	</c:if>
	</td>
</tr>
</c:forEach>   	
</table>
<!-- 新的订单  -->

     
  </body>
</html>
