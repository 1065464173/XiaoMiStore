<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<html>
	<head>
		<meta charset="UTF-8">
        <meta name="author" content="order by dede58.com"/>
		<title>小米商城-个人中心</title>
		<link rel="stylesheet" type="text/css" href="resource/css/style.css">
	</head>
	<!--注销-->
	<script src="resource/jquery/jquery-1.12.4.js"></script>
	<script>
        function removeState(){
            window.location.href='/RemoveStateServlet';
        }
		function editUser(){
			var nickname=$("#editnickname").val();
			var phone=$("#editphone").val();
			var signature=$("#editsignature").val();
			var hobby=$("#edithobby").val();
			var address=$("#editaddress").val();
			$.ajax({
				url:"EditUserServlet",
				type:"post",
                dataType:'json',
                async:false,
				data:{"nickname":nickname,"phone":phone,"signature":signature,"hobby":hobby,"address":address},
                success:function(data,textStatus){
                    if(data.state=='success'){
                        alert(data.msg);
                        window.location.href='/self_info.jsp';
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
	<body>
	<!-- start header -->
		<header>
			<div class="top center">
				<div class="left fl">
					<ul>
						<li><a href="http://www.mi.com/" target="_blank">小米商城</a></li>
						<li>|</li>
						<li><a href="">MIUI</a></li>
						<li>|</li>
						<li><a href="">米聊</a></li>
						<li>|</li>
						<li><a href="">游戏</a></li>
						<li>|</li>
						<li><a href="">多看阅读</a></li>
						<li>|</li>
						<li><a href="">云服务</a></li>
						<li>|</li>
						<li><a href="">金融</a></li>
						<li>|</li>
						<li><a href="">小米商城移动版</a></li>
						<li>|</li>
						<li><a href="">问题反馈</a></li>
						<li>|</li>
						<li><a href="">Select Region</a></li>
						<div class="clear"></div>
					</ul>
				</div>
				<div class="right fr">
					<div class="gouwuche fr"><a href="dingdanzhongxin.jsp">我的订单</a></div>
					<div class="fr">
						<!-- 判断是否登陆-->
						<!-- 已经登陆-->
						<c:if test="${empty user}">
							<ul>
								<li><a href="login.jsp" target="_self">登录</a></li>
								<li>|</li>
								<li><a href="register.jsp" target="_self" >注册</a></li>
								<li>|</li>
								<li><a href="">消息通知</a></li>
							</ul>
						</c:if>
						<!--未登录-->
						<c:if test="${!empty user}">
							<ul>
								<li><a href="self_info.jsp" target="_self">用户：${user.username}</a></li>
								<li>|</li>
								<li><a href="index.jsp" target="_self" onclick="removeState();"  >注销</a></li>
								<li>|</li>
								<li><a href="">消息通知</a></li>
							</ul>
						</c:if>
					</div>
					<div class="clear"></div>
				</div>
				<div class="clear"></div>
			</div>
		</header>
	<!--end header -->
	<!-- start banner_x -->
		<div class="banner_x center">
			<a href="index.jsp" target="_blank"><div class="logo fl"></div></a>
			<a href=""><div class="ad_top fl"></div></a>
			<div class="nav fl">
				<ul>
					<li><a href="">小米手机</a></li>
					<li><a href="">红米</a></li>
					<li><a href="">平板·笔记本</a></li>
					<li><a href="">电视</a></li>
					<li><a href="">盒子·影音</a></li>
					<li><a href="">路由器</a></li>
					<li><a href="">智能硬件</a></li>
					<li><a href="">服务</a></li>
					<li><a href="">社区</a></li>
				</ul>
			</div>
			<div class="search fr">
				<form action="" method="post">
					<div class="text fl">
						<input type="text" class="shuru"  placeholder="小米6&nbsp;小米MIX现货">
					</div>
					<div class="submit fl">
						<input type="submit" class="sousuo" value="搜索"/>
					</div>
					<div class="clear"></div>
				</form>
				<div class="clear"></div>
			</div>
		</div>
<!-- end banner_x -->
<!-- self_info -->
	<div class="grzxbj">
		<div class="selfinfo center">
		<div class="lfnav fl">
			<div class="ddzx">订单中心</div>
			<div class="subddzx">
				<ul>
					<li><a href="dingdanzhongxin.jsp" >我的订单</a></li>
					<li><a href="">意外保</a></li>
					<li><a href="">团购订单</a></li>
					<li><a href="">评价晒单</a></li>
				</ul>
			</div>
			<div class="ddzx">个人中心</div>
			<div class="subddzx">
				<ul>
					<li><a href="./self_info.jsp" style="color:#ff6700;font-weight:bold;">我的个人中心</a></li>
					<li><a href="">消息通知</a></li>
					<li><a href="">收货地址</a></li>
					<li><a href="changepass.jsp">修改密码</a></li>
				</ul>
			</div>
		</div>
		<div class="rtcont fr">
			<div class="grzlbt ml40">我的资料</div>
			<div class="subgrzl ml40"><span>昵称</span><span class="username"><input name="nickname" id="editnickname" style="border:none;" type="text" placeholder="${user.getNickname()==null?"（暂无昵称点击编辑）":user.getNickname()}"/></span></div>
			<div class="subgrzl ml40"><span>手机号</span><span class="phone"><input name="phone" id="editphone" style="border:none;" type="text" placeholder="${user.getPhone()==null?"（暂无手机号点击编辑）":user.getPhone()}"/></span></div>
			<div class="subgrzl ml40"><span>个性签名</span><span class="signature"><input name="signature" id="editsignature" style="border:none;" type="text" placeholder="${user.getSignature()==null?"（暂无签名点击编辑）":user.getSignature()}"/></span></div>
			<div class="subgrzl ml40"><span>我的爱好</span><span class="hobby"><input name="hobby" id="edithobby" style="border:none;" type="text" placeholder="${user.getHobby()==null||user.getHobby()==""?"（暂无爱好点击编辑）":user.getHobby()}"/></span></div>
			<div class="subgrzl ml40"><span>收货地址</span><span class="address"><input name="address" id="editaddress" style="border:none;" type="text" placeholder="${user.getAddress()==null?"（暂无地址点击编辑）":user.getAddress()}"/></span></div>
			<div class="right fr"><input style="border:none;" class="submit" type="button" name="submit" onclick="editUser()" value="保存并提交"/></div>
		</div>
		<div class="clear">
		</div>
	</div>

<!-- self_info -->

		<footer class="mt20 center">			
			<div class="mt20">小米商城|MIUI|米聊|多看书城|小米路由器|视频电话|小米天猫店|小米淘宝直营店|小米网盟|小米移动|隐私政策|Select Region</div>
			<div>©mi.com 京ICP证110507号 京ICP备10046444号 京公网安备11010802020134号 京网文[2014]0059-0009号</div> 
			<div>违法和不良信息举报电话：185-0130-1238，本网站所列数据，除特殊说明，所有数据均出自我司实验室测试</div>
		</footer>
	</body>
</html>