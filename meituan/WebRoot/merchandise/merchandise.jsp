<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
  <title>商品管理信息页面</title>
  	<link href="/meituan/bootstrap/css/bootstrap.min.css" type="text/css" rel="stylesheet">
	<script src="/meituan/business/js/jquery-3.3.1.js"></script>
	<script src="/meituan/bootstrap/js/bootstrap.min.js"></script>
  	
  	<style type="text/css">
		.input-group {
			padding: 6px 0
		}
		
		p{text-align:center;
		margin-top:50px}
	</style>

  </head>
  
  <body>
  
<div class='row'>
  	<div class="col-md-12">
	    <div class="input-group" style="margin: 20px 0 40px 30px">
			<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#addProduct">添加商品信息</button>
			<button style="margin-left: 30px" type="button" class="btn btn-primary" onclick="to_order()">查看订单信息</button>
			<input type="text" class="form-control" id="searchname" style="flex: 0;width: 300px;margin-left: 40px"  placeholder="请输入商品名">
			<span class="input-group-btn">
				<button class="btn btn-default" type="button" onclick="searchStores()">Go!</button>
			</span>
  		</div>
  	</div>
</div>


<!-- 添加商品模态框开始 -->

<!-- Modal -->
<form method="post" action="/meituan/AddMerchandise" enctype="multipart/form-data">
<div class="modal fade" id="addProduct" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
      	<h4 class="modal-title" id="myModalLabel">添加商品信息</h4>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        
      </div>
      <!-- 模态框内容开始 -->
      <div class="modal-body">
        <div class="input-group">
		  <span class="input-group-addon" id="basic-addon1" > &nbsp &nbsp 商品名：</span>
		  <input type="text" class="form-control" name="pname" placeholder="name" aria-describedby="basic-addon1">
		</div>
		
		<div class="input-group">
		  <span class="input-group-addon" id="basic-addon1">商品价格：</span>
		  <input type="text" class="form-control" name="pprice" placeholder="yuan" aria-describedby="basic-addon1">
		</div>
		
		<div class="input-group">
		  <span class="input-group-addon" id="basic-addon1">商品库存：</span>
		  <input type="text" class="form-control" name="pnum" placeholder="reserve" aria-describedby="basic-addon1">
		</div>
		
		<div class="input-group">
		  <span class="input-group-addon" id="basic-addon1">商品图片：</span>
		  <input type="file" name="file" class="form-control" aria-describedby="basic-addon1">
		</div>
	   
      </div>
      <!-- 模态框内容结束 -->
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        <button type="submit" class="btn btn-primary">Add product</button>
      </div>
    </div>
  </div>
</div>
</form>
<!-- 添加商品模态框结束 -->


<!-- 修改商品模态框开始 -->
<!-- Modal -->

<div class="modal fade" id="ModifyProduct" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
      	<h4 class="modal-title" id="myModalLabel">修改商品信息</h4>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        
      </div>
<form method="post" action="/meituan/ModifyMerchandise" enctype="multipart/form-data">
      <!-- 模态框内容开始 -->
      <div class="modal-body">
        <div class="input-group">
		  <span class="input-group-addon" id="basic-addon1" > &nbsp &nbsp 商品名：</span>
		  <input type="text" class="form-control" name="pname" id="pname" placeholder="name" aria-describedby="basic-addon1">
		</div>
		
		<div class="input-group">
		  <span class="input-group-addon" id="basic-addon1">商品价格：</span>
		  <input type="text" class="form-control" name="pprice" id="pprice" placeholder="yuan" aria-describedby="basic-addon1">
		</div>
		
		<div class="input-group">
		  <span class="input-group-addon" id="basic-addon1">商品库存：</span>
		  <input type="text" class="form-control" name="pnum" id="pnum" placeholder="reserve" aria-describedby="basic-addon1">
		</div>
		
		<div>
			<img id="imgurl" height="156" width="208" style="margin-left:80px"/>
		</div>
		
		<div class="input-group">
		  <span class="input-group-addon" id="basic-addon1">商品图片：</span>
		  <input type="file" name="file" class="form-control" aria-describedby="basic-addon1">
		</div>
		
		<div>
			<input type="hidden" name="pid" id="pid">
		</div>
	   
      </div>
      <!-- 模态框内容结束 -->
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        <button type="submit" class="btn btn-primary">Modify product</button>
      </div>
      </form>
    </div>
  </div>
</div>

<!-- 修改商品模态框结束 -->
<script>
	/* 修改商品函数 */
	$(function(){
		$("button.modify_product").click(function(){
			var pid = $(this).data("pid");
			var imgurl = $(this).data("img");
			var tableRow = "#" + pid +"";
			var tdRow = $(tableRow).children("td");
			var pname,pprice,pnum,sid;
			sid = tdRow.eq(0).html();
			pname = tdRow.eq(1).html();
			pprice = tdRow.eq(2).html();
			pnum = tdRow.eq(3).html();
			$("#pname").val(pname);
			$("#pprice").val(pprice);
			$("#pnum").val(pnum);
			$("#imgurl").attr("src",imgurl);
			$("#pid").val(pid);
			$("#imgurl").val(imgurl);
		})
	})
	
	
	/* 删除商品函数 */
	$(function(){
		$("button.delete_product").click(function(){
			if (confirm("你确认要删除吗？")){
				var pid = $(this).data("pid");
				$.ajax({
			  		url: '/meituan/DeleteMerchandise',
			  		type: 'post',
			  		data: {
			  			pid: pid
			  		},
			  		success: function(){
			  			$("#showstore").find("tr#"+pid+"").remove();
			  		}
			  	})
			}
			
			
		})
	})
	
	
/* 跳转到订单servlet */	
	function to_order (){
		var sid = ${sid};
		window.location = "/meituan/NewOrder?sid="+sid+"&state=1";
	}
	
	
</script>

<!-- 分页显示商品信息 -->
<table class="table table-hover" id="showstore">
    	<tr>
    		<th>店铺id</th>
    		<th>商品名</th>
    		<th>商品价格</th>
    		<th>库存</th>
    		<th>操作</th>
    	</tr>
<c:forEach var="user" items="${pageBean.data }" varStatus="vs">
<tr id="${user.pid}">
	<td>${user.store_id }</td>
	<td>${user.pname }</td>
	<td>${user.pprice }</td>
	<td>${user.pnum }</td>
	<td>
		<button data-pid="${user.pid}" data-img="${user.imgurl}" data-toggle='modal' data-target='#ModifyProduct' type='button' class='btn btn-primary modify_product' style='width:58px;height:32px;line-height:32px;padding: 0'>修改</button>
		<button data-pid="${user.pid}" class='btn btn-primary delete_product' style='width:58px;height:32px;line-height:32px;padding: 0;margin-left:10px'>删除</button>
	</td>
</tr>
</c:forEach>   	
</table>

<p>
	
	页数 ${pageBean.curPage }/${pageBean.totalPages}

	<br/>
	<c:choose>
		<c:when test="${pageBean.curPage==1 }">首页   上一页</c:when>
		<c:otherwise>
			<a href="uis?page=1">首页</a>
			<a href="uis?page=${pageBean.curPage-1 }">上一页</a>
		</c:otherwise>
	</c:choose>
	
	<c:choose>
		<c:when test="${pageBean.curPage==pageBean.totalPages }">下一页   尾页</c:when>
		<c:otherwise>
			<a href="uis?page=${pageBean.curPage+1 }">下一页</a>
			<a href="uis?page=${pageBean.totalPages }">尾页</a>
		</c:otherwise>
	</c:choose>

</p>
<!-- 分页显示商品信息结束 -->


	
  </body>
</html>

<script>
	
	
	
</script>
