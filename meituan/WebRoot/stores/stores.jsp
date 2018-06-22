<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>

<html>
  <head>
    <title>店铺信息管理页面</title>
    <link href="../bootstrap/css/bootstrap.min.css" type="text/css" rel="stylesheet">
	<script src="../business/js/jquery-3.3.1.js"></script>
	<script src="../bootstrap/js/bootstrap.min.js"></script>
	<style type="text/css">
		.input-group {
			padding: 6px 0
		}
	</style>
  </head>
  <body>
<div class='row'>
  	<div class="col-md-12">
	    <div class="input-group" style="margin: 20px 0 40px 30px">
			<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#addShop">添加店铺信息</button>
			<button style="margin-left: 30px" type="button" class="btn btn-primary" onclick="showStores()">查看店铺信息</button>
			<input type="text" class="form-control" id="searchname" style="flex: 0;width: 300px;margin-left: 40px"  placeholder="请输入店铺名">
			<span class="input-group-btn">
				<button class="btn btn-default" type="button" onclick="searchStores()">Go!</button>
			</span>
  		</div>
  	</div>
</div>

<!-- 添加店铺信息 -->
			<div class="modal fade" id="addShop" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
			  <div class="modal-dialog" role="document">
			    <div class="modal-content">
			      <div class="modal-header">
			 		<h4 class="modal-title" id="myModalLabel">添加店铺信息</h4>
			        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
			      </div>
			      <div class="modal-body">
					<div class="input-group">
					  <span class="input-group-addon" >店铺名：</span>
					  <input type="text" class="form-control" id="name" placeholder="name" aria-describedby="basic-addon1" >
					</div>
					
					<div class="input-group">
					  <span class="input-group-addon" >地址：</span>
					  <input type="text" class="form-control" id="address" placeholder="address" aria-describedby="basic-addon1">
					</div>
					
					<div class="input-group">
					  <span class="input-group-addon" >电话：</span>
					  <input type="text" class="form-control" id="telphone" placeholder="telphone" aria-describedby="basic-addon1">
					</div>
					
					<div class="input-group">
					  <span class="input-group-addon" >开始营业时间：</span>
					  <input type="text" class="form-control" id="startime" placeholder="hh:mm:ss" aria-describedby="basic-addon1">
					</div>
					
					<div class="input-group">
					  <span class="input-group-addon" >结束营业时间：</span>
					  <input type="text" class="form-control" id="endtime" placeholder="hh:mm:ss" aria-describedby="basic-addon1">
					</div>
					
					<div class="input-group">
					  <span class="input-group-addon" >平均配送时间：</span>
					  <input type="text" class="form-control" id="deliverytime" placeholder="minute" aria-describedby="basic-addon1">
					</div>
					
					<div class="input-group">
					  <span class="input-group-addon" >配送费：</span>
					  <input type="text" class="form-control" id="deliveryfee" placeholder="yuan" aria-describedby="basic-addon1">
					</div>
			      </div>
			      
			      <div class="modal-footer">
			        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
			        <button type="button" class="btn btn-primary" onclick="addStores()" >Add Stores</button>
			      </div>
			    </div>
			  </div>
			</div>

<!-- 修改店铺模态框开始 -->
<!-- <button type="button" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#alter_data">修改</button> -->
	<div class="modal fade" id="alter_data" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	      <h4 class="modal-title">修改店铺信息</h4>
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	      </div>
	      <div class="modal-body">
	      <!-- 要修改的内容开始 -->
       		<div class="input-group">
			  <span class="input-group-addon" >店铺名：</span>
			  <input type="text" class="form-control" placeholder="name" id="shop_name11" aria-describedby="basic-addon1" >
			</div>
			
			<div class="input-group">
			  <span class="input-group-addon" >地址：</span>
			  <input type="text" class="form-control" placeholder="address" id="address11" aria-describedby="basic-addon1">
			</div>
			
			<div class="input-group">
			  <span class="input-group-addon" >电话：</span>
			  <input type="text" class="form-control" placeholder="telphone" id="telphone11" aria-describedby="basic-addon1">
			</div>
			
			<div class="input-group">
			  <span class="input-group-addon" >开始营业时间：</span>
			  <input type="text" class="form-control" placeholder="hh:mm:ss" id="startime11" aria-describedby="basic-addon1">
			</div>
			
			<div class="input-group">
			  <span class="input-group-addon" >结束营业时间：</span>
			  <input type="text" class="form-control" placeholder="hh:mm:ss" id="endtime11" aria-describedby="basic-addon1">
			</div>
			
			<div class="input-group">
			  <span class="input-group-addon" >平均配送时间：</span>
			  <input type="text" class="form-control" placeholder="minute" id="deliverytime11" aria-describedby="basic-addon1">
			</div>
			
			<div class="input-group">
			  <span class="input-group-addon" >配送费：</span>
			  <input type="text" class="form-control" placeholder="yuan"  id="deliveryfee11" aria-describedby="basic-addon1">
			</div>
			<!-- 要修改的内容开始 -->
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
	        <button type="button" class="btn btn-primary save_alter_store">Save Change</button>
	      </div>
	    </div>
	  </div>
	</div>
<!-- 修改模态框结束-->
  
     
    <table class="table table-hover" id="showstore">
    	<tr>
    		<th>商家id</th>
    		<th>店铺名</th>
    		<th>地址</th>
    		<th>操作</th>
    	</tr>
    	
    </table>
  </body>
</html>

<script>
	$(function(){
	
		var cur_alter_sid = -1;
	
		/* 默认开始就显示数据 */
		showStores();
	
		$('#addShop').on('shown.bs.modal', function () {
			$('#addShop').focus()
		})
		
		/* 删除店铺函数  */
		$("#showstore").delegate("button.delete_store","click",function(event){
			if (confirm("你确认要删除吗？")){
			  	cur_alter_sid = $(this).data('sid');
			  	$.ajax({
			  		url: '/meituan/DeleteStoresController',
			  		type: 'post',
			  		data: {
			  			sid: cur_alter_sid
			  		},
			  		success: function(data){
			  			alert(data);
			  			showStores();
			  		}
			  	})
		  	}
		});
		
		
		/* 修改店铺函数 */
		$("#showstore").delegate("button.change_store","click",function(event){
		  	cur_alter_sid = $(this).data('sid');
		  	
		  	$.ajax({
		  		url: '/meituan/ChangeStoresController',
		  		type: 'post',
		  		dataType: 'json',
		  		data: {
		  			sid: cur_alter_sid
		  		},
		  		success: function(data){
		  			console.log(data[0])
		  			console.log(data[0].sid)
		  			$("#shop_name11").val(data[0].sname)
		  			$("#address11").val(data[0].saddress)
		  			$("#telphone11").val(data[0].stelphone)
		  			$("#startime11").val(data[0].startime)
		  			$("#endtime11").val(data[0].endtime)
		  			$("#deliverytime11").val(data[0].deliverytime)
		  			$("#deliveryfee11").val(data[0].deliveryfee)
		  		}
		  	})
		});
		
		//点击修改保存后的按钮
		$('.save_alter_store').click(function(){
			  		var name = $("#shop_name11").val(),
			  			address = $("#address11").val(),
			  			telphone = $("#telphone11").val(),
			  			startime = $("#startime11").val(),
			  			endtime = $("#endtime11").val(),
			  			deliverytime = $("#deliverytime11").val(),
			  			deliveryfee = $("#deliveryfee11").val();
					  	$.ajax({
							url: '/meituan/ModifyStoresController',
							type: 'post',
							data: {
									sid: cur_alter_sid,
									name: name,
									address: address,
									telphone: telphone,
									startime: startime,
									endtime: endtime,
									deliverytime: deliverytime,
									deliveryfee: deliveryfee	
								  },
								success: function(data){
									alert(data);
									$('#alter_data').modal('hide')
									showStores();
								}		
					  })
					  	
					  	
			  	})
		
	})
	
	function to_store(bu){
			/*进入店铺函数  */
			var sid = $(bu).data('sid');
			/* alert(sid); */
			window.location="/meituan/ToStores?sid="+sid+"";
	}
	
	
	function addStores(){
		var name = $("#name").val(),
			address = $("#address").val(),
			telphone = $("#telphone").val(),
			startime = $("#startime").val(),
			endtime = $("#endtime").val(),
			deliverytime = $("#deliverytime").val(),
			deliveryfee = $("#deliveryfee").val();
			$.ajax({
			url: '/meituan/AddStoresController',
			type: 'post',
			data: {
				name:name,
				address:address,
				telphone:telphone,
				startime:startime,
				endtime:endtime,
				deliverytime:deliverytime,
				deliveryfee:deliveryfee	
			},
			success: function(data){
				alert(data);
				$('#addShop').modal('hide')
				showStores();
			}
			
		})	
	}
	
	function showStores(){
		$.ajax({
			url: '/meituan/ShowstoresController',
			type: 'post',
			data: {
			
			},
			success:function(data){
				/* console.log(data); */
				var table = $("#showstore");
				$("#showstore  tr:not(:first)").html(""); 
				$.each(JSON.parse(data),function(i,a){
					/* console.log(a.sid) */
					table.append("<tr><td>"+a.user_id+"</td>"+
					"<td>"+a.sname+"</td>"+
					"<td>"+a.saddress+"</td>"+
					"<td class='alter_store'><button data-sid='" + a.sid + "' data-toggle='modal' data-target='#alter_data' type='button' class='btn btn-primary change_store' style='width:58px;height:32px;line-height:32px;padding: 0'>修改</button>"+
					"<button data-sid='" + a.sid + "' class='btn btn-primary delete_store' style='width:58px;height:32px;line-height:32px;padding: 0;margin-left:10px'>删除</button>"+
					"<button data-sid='" + a.sid + "' class='btn btn-primary' onclick='to_store(this)' style='width:58px;height:32px;line-height:32px;padding: 0;margin-left:10px'>进店</button></td></tr>")
				});
			}
		})
	}
	
	
	function searchStores(){
		var searchname=$("#searchname").val();
		if (searchname === "") {
			return false
		}
		$.ajax({
			url: '/meituan/SearchStoresController',
			type: 'post',
			data: {
				searchname: searchname
			},
			success:function(data){
				console.log(data);
				var table = $("#showstore");
				$("#showstore  tr:not(:first)").html(""); 
				$.each(JSON.parse(data),function(i,a){
					table.append("<tr><td>"+a.user_id+"</td>"+
					"<td>"+a.sname+"</td>"+
					"<td>"+a.saddress+"</td>"+
					"<input type='hidden' value=" + a.sid + " />"+
					"<td class='alter_store'><button data-sid='" + a.sid + "' data-toggle='modal' data-target='#alter_data' type='button' class='btn btn-primary change_store' style='width:58px;height:32px;line-height:32px;padding: 0'>修改</button>"+
					"<button data-sid='" + a.sid + "' class='btn btn-primary delete_store' style='width:58px;height:32px;line-height:32px;padding: 0;margin-left:10px'>删除</button>"+
					"<button data-sid='" + a.sid + "' class='btn btn-primary' onclick='to_store(this)' style='width:58px;height:32px;line-height:32px;padding: 0;margin-left:10px'>进店</button></td></tr>")
				});
			}
		})
	}
	
	
</script>
