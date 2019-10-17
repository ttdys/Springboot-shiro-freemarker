<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">

		<link href="../static/css/bootstrap.min.css" rel="stylesheet">
		<link href="../static/font-awesome/css/font-awesome.css" rel="stylesheet">
		<link href="../static/css/bootstrap.min.css" rel="stylesheet">
		<link href="../static/font-awesome/css/font-awesome.css" rel="stylesheet">
		<link href="../static/css/animate.css" rel="stylesheet">
		<link href="../static/css/style.css" rel="stylesheet">

		<link href="../static/css/plugins/toastr/toastr.min.css" rel="stylesheet">


		<link href="../static/js/plugins/gritter/jquery.gritter.css" rel="stylesheet">

		<link href="../static/css/animate.css" rel="stylesheet">
		<link href="../static/css/style.css" rel="stylesheet">
	</head>
	<body>
	<nav class="navbar-default navbar-static-side" role="navigation">
		<div class="sidebar-collapse">
			<ul class="nav metismenu" id="side-menu">
				<li class="nav-header">
					<div class="dropdown profile-element">
						<img alt="image" class="rounded-circle" src="img/profile_small.jpg"/>
						<a data-toggle="dropdown" class="dropdown-toggle" href="#">
							<span class="block m-t-xs font-bold">TomatoAdmin</span>
							<span class="text-muted text-xs block">Art Director <b class="caret"></b></span>
						</a>
						<ul class="dropdown-menu animated fadeInRight m-t-xs">
							<li><a class="dropdown-item" href="profile.html">个人信息</a></li>
							<li><a class="dropdown-item" href="mailbox.html">设置</a></li>
							<li class="dropdown-divider"></li>
							<li><a class="dropdown-item" href="/logout">退出</a></li>
						</ul>
					</div>
					<div class="logo-element">
						Tomato
					</div>
				</li>

				<!-- start menu-->
				<#--  <li>
                      <a href="#"><i class="fa fa-sitemap"></i> <span class="nav-label">Menu Levels </span><span class="fa arrow"></span></a>
                      <ul class="nav nav-second-level collapse">
                          <li>
                              <a href="#">Third Level <span class="fa arrow"></span></a>
                          </li>
                          <li><a href="#">Second Level Item</a></li>
                          <li><a href="#">Second Level Item</a></li>
                          <li><a href="#">Second Level Item</a></li>
                      </ul>
                  </li>-->
				<li id="myMenuTree">

				</li>


				<!--end menu-->




			</ul>

		</div>
	</nav>

	<div id="page-wrapper" class="gray-bg">
		<div class="row border-bottom">
			<nav class="navbar navbar-static-top" role="navigation" style="margin-bottom: 0">
				<div class="navbar-header">
					<a class="navbar-minimalize minimalize-styl-2 btn btn-primary " href="#"><i class="fa fa-bars"></i> </a>
					<form role="search" class="navbar-form-custom" action="search_results.html">
						<div class="form-group">
							<input type="text" placeholder="Search for something..." class="form-control" name="top-search" id="top-search">
						</div>
					</form>
				</div>
				<ul class="nav navbar-top-links navbar-right">
					<li>
						<span class="m-r-sm text-muted welcome-message">欢迎使用Tomato系统</span>
					</li>
					<li class="dropdown">
						<a class="dropdown-toggle count-info" data-toggle="dropdown" href="#">
							<i class="fa fa-envelope"></i>  <span class="label label-warning">16</span>
						</a>
						<ul class="dropdown-menu dropdown-messages">
							<li>
								<div class="dropdown-messages-box">
									<a class="dropdown-item float-left" href="profile.html">
										<img alt="image" class="rounded-circle" src="img/a7.jpg">
									</a>
									<div class="media-body">
										<small class="float-right">46h ago</small>
										<strong>Mike Loreipsum</strong> started following <strong>Monica Smith</strong>. <br>
										<small class="text-muted">3 days ago at 7:58 pm - 10.06.2014</small>
									</div>
								</div>
							</li>
							<li class="dropdown-divider"></li>
							<li>
								<div class="dropdown-messages-box">
									<a class="dropdown-item float-left" href="profile.html">
										<img alt="image" class="rounded-circle" src="img/a4.jpg">
									</a>
									<div class="media-body ">
										<small class="float-right text-navy">5h ago</small>
										<strong>Chris Johnatan Overtunk</strong> started following <strong>Monica Smith</strong>. <br>
										<small class="text-muted">Yesterday 1:21 pm - 11.06.2014</small>
									</div>
								</div>
							</li>
							<li class="dropdown-divider"></li>
							<li>
								<div class="dropdown-messages-box">
									<a class="dropdown-item float-left" href="profile.html">
										<img alt="image" class="rounded-circle" src="img/profile.jpg">
									</a>
									<div class="media-body ">
										<small class="float-right">23h ago</small>
										<strong>Monica Smith</strong> love <strong>Kim Smith</strong>. <br>
										<small class="text-muted">2 days ago at 2:30 am - 11.06.2014</small>
									</div>
								</div>
							</li>
							<li class="dropdown-divider"></li>
							<li>
								<div class="text-center link-block">
									<a href="mailbox.html" class="dropdown-item">
										<i class="fa fa-envelope"></i> <strong>Read All Messages</strong>
									</a>
								</div>
							</li>
						</ul>
					</li>
					<li class="dropdown">
						<a class="dropdown-toggle count-info" data-toggle="dropdown" href="#">
							<i class="fa fa-bell"></i>  <span class="label label-primary">8</span>
						</a>
						<ul class="dropdown-menu dropdown-alerts">
							<li>
								<a href="mailbox.html" class="dropdown-item">
									<div>
										<i class="fa fa-envelope fa-fw"></i> You have 16 messages
										<span class="float-right text-muted small">4 minutes ago</span>
									</div>
								</a>
							</li>
							<li class="dropdown-divider"></li>
							<li>
								<a href="profile.html" class="dropdown-item">
									<div>
										<i class="fa fa-twitter fa-fw"></i> 3 New Followers
										<span class="float-right text-muted small">12 minutes ago</span>
									</div>
								</a>
							</li>
							<li class="dropdown-divider"></li>
							<li>
								<a href="grid_options.html" class="dropdown-item">
									<div>
										<i class="fa fa-upload fa-fw"></i> Server Rebooted
										<span class="float-right text-muted small">4 minutes ago</span>
									</div>
								</a>
							</li>
							<li class="dropdown-divider"></li>
							<li>
								<div class="text-center link-block">
									<a href="notifications.html" class="dropdown-item">
										<strong>See All Alerts</strong>
										<i class="fa fa-angle-right"></i>
									</a>
								</div>
							</li>
						</ul>
					</li>


					<li>
						<a href="${request.contextPath}/logout">
							<i class="fa fa-sign-out"></i> 退出
						</a>
					</li>
				</ul>

			</nav>
		<#--</div>-->
		</div>

	<!-- Mainly scripts -->
	<script src="../static/js/jquery-3.1.1.min.js"></script>
	<script src="../static/js/popper.min.js"></script>
	<script src="../static/js/bootstrap.js"></script>
	<script src="../static/js/plugins/metisMenu/jquery.metisMenu.js"></script>
	<script src="../static/js/plugins/slimscroll/jquery.slimscroll.min.js"></script>

	<!-- Flot -->
	<script src="../static/js/plugins/flot/jquery.flot.js"></script>
	<script src="../static/js/plugins/flot/jquery.flot.tooltip.min.js"></script>
	<script src="../static/js/plugins/flot/jquery.flot.spline.js"></script>
	<script src="../static/js/plugins/flot/jquery.flot.resize.js"></script>
	<script src="../static/js/plugins/flot/jquery.flot.pie.js"></script>

	<!-- Peity -->
	<script src="../static/js/plugins/peity/jquery.peity.min.js"></script>
	<script src="../static/js/demo/peity-demo.js"></script>

	<!-- Custom and plugin javascript -->
	<script src="../static/js/inspinia.js"></script>
	<script src="../static/js/plugins/pace/pace.min.js"></script>

	<!-- jQuery UI -->
	<script src="../static/js/plugins/jquery-ui/jquery-ui.min.js"></script>

	<!-- GITTER -->
	<script src="../static/js/plugins/gritter/jquery.gritter.min.js"></script>

	<!-- Sparkline -->
	<script src="../static/js/plugins/sparkline/jquery.sparkline.min.js"></script>

	<!-- Sparkline demo data  -->
	<script src="../static/js/demo/sparkline-demo.js"></script>

	<!-- ChartJS-->
	<script src="../static/js/plugins/chartJs/Chart.min.js"></script>

	<!-- Toastr -->
	<script src="../static/js/plugins/toastr/toastr.min.js"></script>



	<script>
		$(function () {
			$.post("/user/menuList","",function (data) {
				var m = "";
				var n ="";
				var obj = eval( "(" + data + ")" );//转换后的JSON对象

				for (var i =0; i<obj.length; i++){

					if(obj[i].parentId===0) {
						var m1 = '<li><a href="#"><i class="fa fa-sitemap"></i> <span class="nav-label">'+obj[i].text+'</span><span class="fa arrow"></span></a>';
						var m2 ='<ul class="nav nav-second-level collapse">';
						var id = obj[i].menuId;
						var  liobj = obj[i].nodes;
						for(var j=0;j<liobj.length;j++) {
							if(id ===liobj[j].parentId){
								var m3 ='<li><a href="'+liobj[j].href+'">'+liobj[j].text+'</a></li>';
								n = n+m3;
							}
						}
						var m4 ='</ul></li>';
						m = m1 + m2 + n + m4;

					}
					$("#myMenuTree").after(m);
				}

			});
		})



	</script>
	</body>
</html>
