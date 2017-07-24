<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="sform" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<title>Register</title>
<meta name="description" content="用户注册"/>
<script type="text/javascript" src="${pageContext.request.contextPath }/scripts/jquery-3.1.1.min.js"></script>
<script type="text/javascript">
	$(function(){
		$("#userName").change(function(){
			var val=$(this).val();
			val=$.trim(val);
			var $inputN=$(this);
			$inputN.nextAll("font").remove();
			if(val!=""){
				//alert("发送Ajax 请求");
				var url = "${pageContext.request.contextPath }/register/checkUserName";
				var args={"name":val,"time":new Date()};
				$.post(url,args,function(data){
					if(data=="1"){
						//表示可用						
						$inputN.after("<font color='green'>Name可用!</font>");
					}else if(data=="0"){
						//表示不可用
						$inputN.after("<font color='red' class='saveNG'>Name不可用!</font>");
					}else{
						$inputN.after("<font class='saveNG'></font>");
						//服务器错误
						alert("验证Name时发生服务器错误");
					}
				});
			}else{
				$(this).after("<font color='red' class='saveNG'>Name 不能为空!</font>");
				$(this).val("");
			}
		});
		var password="";
		//验证密码
		$(".userpass").change(function(){
			$(this).nextAll("font").remove();
			var $pass=$(".userpass").eq(0).val();
			$pass=$.trim($pass);
			var $confirm=$(".userpass").eq(1).val();
			$confirm=$.trim($confirm);
			var $this=$(this).val();
			$this=$.trim($this);
			if($this==""){
				$(this).after("<font color='red' class='saveNG'>必填</font>");
				
			}else{
				if($pass==$confirm){
					$(".userpass").nextAll("font").remove();
					$(".userpass").eq(1).after("<font color='green'>OK</font>");
				}else{
					$(".userpass").eq(1).after("<font color='red' class='saveNG'>两次密码不相符</font>");
				}
			}
		});
		$("#saveUserButton").click(function(){
			var numNG=$("#saveUserForm").children(".saveNG").length;
			if(numNG!=0){
				alert("还有 "+numNG+" 处必填项没有搞定哦( *・ω・)✄╰ひ╯")
				return false;
			}
			return true;
		});
		
	})
</script>
</head>
<body>
	<sform:form id="saveUserForm" action="${pageContext.request.contextPath }/register/saveUser" modelAttribute="user" method="POST">
		
		name:<sform:input path="name" id="userName"/><sform:errors path="name"></sform:errors><br/>
		password:<sform:password path="password" class="userpass"/><sform:errors path="password"></sform:errors><br/>
		confirm :<input type="password" class="userpass"/><br/>
		email:<sform:input path="email"/><sform:errors path="email"></sform:errors><br/>
		<br/>
		<input type="submit" value="注册" id="saveUserButton"/>
	</sform:form>
</body>
</html>