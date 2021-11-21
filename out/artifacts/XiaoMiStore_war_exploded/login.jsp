<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<html>
	<head>
		<meta charset="UTF-8">
        <meta name="author" content="order by dede58.com"/>
		<title>会员登录</title>
		<link rel="stylesheet" type="text/css" href="resource/css/login.css">

	</head>
	<body>
		<!-- login -->
		<div class="top center">
			<div class="logo center">
				<a href="index.jsp" target="_blank"><img src="resource/image/mistore_logo.png" alt=""></a>
			</div>
		</div>
--  		<form  method="post" action="LoginServlet" class="form center">
		<div class="login">
			<div class="login_center">
				<div class="login_top">
					<div class="left fl">会员登录</div>
					<div class="right fr">您还不是我们的会员？<a href="register.jsp" target="_self">立即注册</a></div>
					<div class="clear"></div>
					<div class="xian center"></div>
				</div>
				<div class="login_main center">
					<div class="username">用户名:&nbsp;<input class="shurukuang" type="text" name="username" id="username" placeholder="请输入你的用户名"/></div>
					<div class="username">密&nbsp;&nbsp;&nbsp;&nbsp;码:&nbsp;<input class="shurukuang" type="password" name="password" id="password" placeholder="请输入你的密码"/></div>
					<div class="username">
						<div class="left fl">验证码:&nbsp;<input class="yanzhengma" type="text" name="verifyCode" id="verifyCode" placeholder="请输入验证码"/></div>
						<div class="right fr">
 						<img id="img" src="VerifyCodeServlet"/>
						<a href="javascript:_change()">换一张</a>
						</div>
						<div class="clear"></div>
					</div>
				</div>

				<div class="login_submit">
 					<!--<input class="submit" type="submit" name="submit" value="立即登录" src="check();" />-->
                <input class="submit" type="button" name="submit" onclick="check();" value="立即登录"/>
				</div>

			</div>
		</div>
--  		</form>
		<footer>
			<div class="copyright">简体 | 繁体 | English | 常见问题</div>
			<div class="copyright">小米公司版权所有-京ICP备10046444-<img src="resource/image/ghs.png" alt="">京公网安备11010802020134号-京ICP证110507号</div>

		</footer>
		<!--更换验证码-->
		<script type="text/javascript">
            function _change() {
                var imgEle = document.getElementById("img");
                imgEle.src = "/VerifyCodeServlet?a=" + new Date().getTime();
            }
		</script>

		<script src="resource/jquery/jquery-1.12.4.js"></script>
		<script>
            <!--AJAX传输username password 到LoginServelt-->
             function check(){

                  var username = $("#username").val();
                  var password = $("#password").val();
		          var verifyCode= $("#verifyCode").val();
		          $.ajax({
		              url:"LoginServlet",
                      type:"post",
                      dataType: 'json',
                      async:false,
                      data:{"username":username,"password":password,"verifyCode":verifyCode},

                      success:function(data,textStatus){
                          if(data.state=='success'){
                              alert(data.msg);
                              window.location.href='/index.jsp';
                          }
						  if(data.state=='erorrs'){
		                      alert(data.msg);
						  }

					  },
                      error:function(){
                          alert("请求失败，请重试");
                      }

				  })

                  }
		</script>

	</body>

</html>