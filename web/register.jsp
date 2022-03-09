<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<html>
	<head>
		<meta charset="UTF-8">
        <meta name="author" content="order by dede58.com"/>
		<title>用户注册</title>
		<link rel="stylesheet" type="text/css" href="resource/css/login.css">

		<!--更换验证码-->
		<script type="text/javascript">
            function _change() {
                /*
                1. 得到img元素
                2. 修改其src为/day11_3/VerifyCodeServlet
                */
                var imgEle = document.getElementById("img");
                /*
                加后面的参数的目的就是 由于不加参数的话，网址就不会发生变化 ，
                每一次请求都是一个网址，网站就会有缓存,当点击换一张的时候就不会发生变化
                     加了这个参数以后就是为了，每一次访问的时候网址都是变化的 a=" + new Date().getTime();
                */
                imgEle.src = "/VerifyCodeServlet?a=" + new Date().getTime();
            }

		</script>
		<!--AJAX 传输注册信息到RegisterServlet-->
		<script src="resource/jquery/jquery-1.12.4.js"></script>
		<script>
            function register(){
                var username = $("#regusername").val();
                var password = $("#regpassword").val();
                var confirmpass = $("#comfirmpass").val();
                var phone = $("#regphone").val();
                var verifyCode = $("#regverifyCode").val();
                $.ajax({
                    url:"RegisterServlet",
                    type:"post",
                    dataType:'json',
                    data:{"username":username,"password":password,"comfirmpass":confirmpass,"phone":phone,"verifyCode":verifyCode},
                    success:function(data,textStatus){
                        if(data.state=='success'){
                            alert(data.msg);
                            window.location.href='/login.jsp';
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
	</head>
	<body>
		<div class="regist">
			<div class="regist_center">
				<div class="regist_top">
					<div class="left fl">会员注册</div>
					<div class="right fr"><a href="index.jsp" target="_self">小米商城</a></div>
					<div class="clear"></div>
					<div class="xian center"></div>
				</div>
				<div class="regist_main center">
					<div class="username">用&nbsp;&nbsp;户&nbsp;&nbsp;名:&nbsp;&nbsp;<input class="shurukuang" type="text" name="username" id="regusername" placeholder="请输入你的用户名"/><span>请不要输入汉字</span></div>
					<div class="username">密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码:&nbsp;&nbsp;<input class="shurukuang" type="password" name="" id="regpassword" placeholder="请输入你的密码"/><span>请输入6位以上字符</span></div>
					
					<div class="username">确认密码:&nbsp;&nbsp;<input class="shurukuang" type="password" name="comfirmpass" id="comfirmpass" placeholder="请确认你的密码"/><span>两次密码要输入一致哦</span></div>
					<div class="username">手&nbsp;&nbsp;机&nbsp;&nbsp;号:&nbsp;&nbsp;<input class="shurukuang" type="text" name="phone" id="regphone" placeholder="请填写正确的手机号"/><span>填写下手机号吧，方便我们联系您！</span></div>
					<div class="username">
						<div class="left fl">验&nbsp;&nbsp;证&nbsp;&nbsp;码:&nbsp;&nbsp;<input class="yanzhengma" type="text" name="verifyCode" id="regverifyCode" placeholder="请输入验证码"/></div>
						<div class="right fl">
							<img id="img" src="VerifyCodeServlet"/>
							<a href="javascript:_change()">换一张</a>
						</div>
						<div class="clear"></div>
					</div>
				</div>
				<div class="regist_submit">
					<input class="submit" type="button" name="submit" onclick="register();" value="立即注册"/>
				</div>
				
			</div>
		</div>
	</body>
</html>