$(function(){
	$("#change").click(function(){
		var uid = $("#uid").val();
		var username = $("#username").val();
		var password = $("#password").val();
		$.ajax({
			url:"/meituan/ModifyController",
			type:"post",
			data:{
				uid:uid,
				username:username,
				password:password
			},
			success: function(result){
				if(result == "1")
				{
					alert('修改成功')
					$('#editAdmin').modal('hide')
				}else{
					alert('修改失败')
					$('#editAdmin').modal('hide')
				}
			},
			error: function(data){
				alert('修改失败')
			}
		})
	})
	
})