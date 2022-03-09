<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
	<head>
		<meta charset="UTF-8">
        <meta name="author" content="order by dede58.com"/>
		<title>小米商城-个人中心</title>
		<link rel="stylesheet" type="text/css" href="resource/css/style.css">
	</head>
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
					<div class="gouwuche fr"><a href="">我的订单</a></div>
					<div class="fr">
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
					<li><a href="" style="color:#ff6700;font-weight:bold;">我的订单</a></li>
					<li><a href="">意外保</a></li>
					<li><a href="">团购订单</a></li>
					<li><a href="">评价晒单</a></li>
				</ul>
			</div>
			<div class="ddzx">个人中心</div>
			<div class="subddzx">
				<ul>
					<li><a href="self_info.jsp">我的个人中心</a></li>
					<li><a href="">消息通知</a></li>
					<li><a href="">收货地址</a></li>
					<li><a href="changepass.jsp">修改密码</a></li>
				</ul>
			</div>
		</div>
		<div class="rtcont fr">
			<div class="ddzxbt">交易订单</div>
			<div class="ddxq">
				<div class="ddspt fl"><img src="resource/image/gwc_xiaomi6.jpg" alt=""></div>
				<div class="ddbh fl">订单号:1705205643098724</div>
				<div class="ztxx fr">
					<ul>
						<li>已发货</li>
						<li>￥2499.00</li>
						<li>2017/05/20 13:30</li>
						<li><a href="">订单详情></a></li>
						<div class="clear"></div>
					</ul>
				</div>
				<div class="clear"></div>
			</div>
			<div class="ddxq">
				<div class="ddspt fl"><img src="resource/image/liebiao_hongmin4_dd.jpg" alt=""></div>
				<div class="ddbh fl">订单号:170526435444865</div>
				<div class="ztxx fr">
					<ul>
						<li>已发货</li>
						<li>￥1999.00</li>
						<li>2017/05/26 14:02</li>
						<li><a href="">订单详情></a></li>
						<div class="clear"></div>
					</ul>
				</div>
				<div class="clear"></div>
			</div>
		</div>
		<div class="clear"></div>
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