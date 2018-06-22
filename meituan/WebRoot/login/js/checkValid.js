$(function() {	
	$('#login #login-password').focus(function() {
		$('.login-owl').addClass('password');
	}).blur(function() {
		$('.login-owl').removeClass('password');
	});
	$('#login #register-password').focus(function() {
		$('.register-owl').addClass('password');
	}).blur(function() {
		$('.register-owl').removeClass('password');
	});
	$('#login #register-repassword').focus(function() {
		$('.register-owl').addClass('password');
	}).blur(function() {
		$('.register-owl').removeClass('password');
	});
	$('#login #forget-password').focus(function() {
		$('.forget-owl').addClass('password');
	}).blur(function() {
		$('.forget-owl').removeClass('password');
	});
});

function goto_register(){
	$("#register-username").val("");
	$("#register-password").val("");
	$("#register-repassword").val("");
	// $("#register-code").val("");
	$("#tab-2").prop("checked",true);
}

function goto_login(){
	$("#login-username").val("");
	$("#login-password").val("");
	$("#tab-1").prop("checked",true);
}

function goto_forget(){
	$("#forget-username").val("");
	$("#forget-password").val("");
	$("#forget-code").val("");
	$("#tab-3").prop("checked",true);
}

function login(){//登录
	var username = $("#login-username").val(),
		password = $("#login-password").val(),
		verifycode = $("#login-verify-code").val(),
		validatecode = null;
	//判断用户名密码是否为空
	if(username == ""){
		$.pt({
    		target: $("#login-username"),
    		position: 'r',
    		align: 't',
    		width: 'auto',
    		height: 'auto',
    		content:"用户名不能为空"
    	});
		return;
	}
	if(password == ""){
		$.pt({
    		target: $("#login-password"),
    		position: 'r',
    		align: 't',
    		width: 'auto',
    		height: 'auto',
    		content:"密码不能为空"
    	});
		return;
	}
	if(verifycode == ""){
		$.pt({
    		target: $("#login-verify-code-canvas"),
    		position: 'r',
    		align: 't',
    		width: 'auto',
    		height: 'auto',
    		content:"验证码不能为空"
    	});
		return;
	}		
	if(timeout_flag){
		$.pt({
    		target: $("#login-verify-code-canvas"),
    		position: 'r',
    		align: 't',
    		width: 'auto',
    		height: 'auto',
    		content:"验证码已经失效"
    	});
		return;
	}
	//用户名只能是15位以下的字母或数字
	var regExp = new RegExp("^[a-zA-Z0-9_]{1,15}$");
	if(!regExp.test(username)){
		$.pt({
    		target: $("#login-username"),
    		position: 'r',
    		align: 't',
    		width: 'auto',
    		height: 'auto',
    		content:"用户名必须为15位以下的字母或数字"
    	});
		return;
	}
	//判断验证码是否正确
	if(verifycode != show_num.join("")){
		$.pt({
    		target: $("#login-verify-code-canvas"),
    		position: 'r',
    		align: 't',
    		width: 'auto',
    		height: 'auto',
    		content:"验证码不正确"
    	});
		return;
	}
	
	//登录
	//调用后台登录验证的方法

	//调用后台接口
	$.ajax({
		url: '/meituan/LoginController',
		type: 'post',
		data: {
			username: username,
			password: password
		},
		success: function(data){
			if (data === "1") {
				window.location.href = '/meituan/business/admin_index.jsp'
			}
			
			if (data === "2") {
				window.location.href = '/meituan/manager/main.jsp'
				
			}
		}
	})
	

	return false;
}

//注册
function register(){
	var username = $("#register-username").val(),
		password = $("#register-password").val(),
		repassword = $("#register-repassword").val(),
		code = $("#register-code").val(),
		flag = false,
		validatecode = null;
	//判断用户名密码是否为空
	if(username === ""){
		$.pt({
    		target: $("#register-username"),
    		position: 'r',
    		align: 't',
    		width: 'auto',
    		height: 'auto',
    		content:"用户名不能为空"
    	});
		flag = true;
		return false;
	}
	if(password === ""){
		$.pt({
    		target: $("#register-password"),
    		position: 'r',
    		align: 't',
    		width: 'auto',
    		height: 'auto',
    		content:"密码不能为空"
    	});
		flag = true;
		return false;
	}else{
		if(password !== repassword){
			$.pt({
        		target: $("#register-repassword"),
        		position: 'r',
        		align: 't',
        		width: 'auto',
        		height: 'auto',
        		content:"两次输入的密码不一致"
        	});
			flag = true;
			return false;
		}
	}
	//用户名只能是15位以下的字母或数字
	var regExp = new RegExp("^[a-zA-Z0-9_]{1,15}$");
	if(!regExp.test(username)){
		$.pt({
    		target: $("#register-username"),
    		position: 'r',
    		align: 't',
    		width: 'auto',
    		height: 'auto',
    		content:"用户名必须为15位以下的字母或数字"
    	});
		flag = true;
		return false;
	}
	
	$.ajax({
		url: '/meituan/RegisterController',
		type: 'post',
		data: {
			username: username,
			password: password
		},
		success: function(data){
			if (data === "1") {
				spop({			
					template: '<h4 class="spop-title">注册成功</h4>即将于3秒后返回登录',
					position: 'top-center',
					style: 'success',
					autoclose: 3000,
					onOpen : function(){
						var second = 2;
						var showPop = setInterval(function(){
							if(second == 0){
								clearInterval(showPop);
							}
							$('.spop-body').html('<h4 class="spop-title">注册成功</h4>即将于'+second+'秒后返回登录');
							second--;
						},1000);
					},
					onClose : function(){
						goto_login();
					}
				});
			}
		}
	})
	
}

//重置密码
// function forget(){
// 	var username = $("#forget-username").val(),
// 		password = $("#forget-password").val(),
// 		code = $("#forget-code").val(),
// 		flag = false,
// 		validatecode = null;
// 	//判断用户名密码是否为空
// 	if(username == ""){
// 		$.pt({
//     		target: $("#forget-username"),
//     		position: 'r',
//     		align: 't',
//     		width: 'auto',
//     		height: 'auto',
//     		content:"用户名不能为空"
//     	});
// 		flag = true;
// 	}
// 	if(password == ""){
// 		$.pt({
//     		target: $("#forget-password"),
//     		position: 'r',
//     		align: 't',
//     		width: 'auto',
//     		height: 'auto',
//     		content:"密码不能为空"
//     	});
// 		flag = true;
// 	}
// 	//用户名只能是15位以下的字母或数字
// 	var regExp = new RegExp("^[a-zA-Z0-9_]{1,15}$");
// 	if(!regExp.test(username)){
// 		$.pt({
//     		target: $("#forget-username"),
//     		position: 'r',
//     		align: 't',
//     		width: 'auto',
//     		height: 'auto',
//     		content:"用户名必须为15位以下的字母或数字"
//     	});
// 		flag = true;
// 	}
	//检查用户名是否存在
	//调后台方法
	
	//检查注册码是否正确
	// if(code != '11111111'){
	// 	$.pt({
	//         target: $("#forget-code"),
	//         position: 'r',
	//         align: 't',
	//         width: 'auto',
	//         height: 'auto',
	//         content:"注册码不正确"
	//        });
	// 	flag = true;
	// }
	// 
	// 这里应该改为检查密码是否正确
	
	
	
	// if(flag){
	// 	return false;
	// }else{//重置密码
	// 	spop({			
	// 		template: '<h4 class="spop-title">重置密码成功</h4>即将于3秒后返回登录',
	// 		position: 'top-center',
	// 		style: 'success',
	// 		autoclose: 3000,
	// 		onOpen : function(){
	// 			var second = 2;
	// 			var showPop = setInterval(function(){
	// 				if(second == 0){
	// 					clearInterval(showPop);
	// 				}
	// 				$('.spop-body').html('<h4 class="spop-title">重置密码成功</h4>即将于'+second+'秒后返回登录');
	// 				second--;
	// 				},1000);
	// 		},
	// 		onClose : function(){
	// 			goto_login();
	// 		}
	// 	});
	// 	return false;
	// }
// }


function checkUserName(){ 
  var user = $("#register-username").val();   
  $.ajax({
	   url:"/meituan/Ajax",  
	   data: {
   		username : user
	   },  
	   async:true,  
	   type:"POST",  
	   dataType:"html",  
	   success:function(result){
		   if (result === 'faile') {
			   $.pt({
		     		target: $("#register-username"),
		     		position: 'r',
		     		align: 't',
		     		width: 'auto',
		     		height: 'auto',
		     		content:"用户名已被注册"
		     	});
		   }
	   }  
   }); 
}