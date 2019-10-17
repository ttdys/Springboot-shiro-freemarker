
<html>

	<head>

		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">

		<title>INSPINIA | Dashboard</title>

		<link href="../static/css/bootstrap.min.css" rel="stylesheet">
		<link href="../static/font-awesome/css/font-awesome.css" rel="stylesheet">

		<!-- Toastr style -->
		<link href="../static/css/plugins/toastr/toastr.min.css" rel="stylesheet">

		<!-- Gritter -->
		<link href="../static/js/plugins/gritter/jquery.gritter.css" rel="stylesheet">

		<link href="../static/css/animate.css" rel="stylesheet">
		<link href="../static/css/style.css" rel="stylesheet">




	</head>

	<body>
		<div id="wrapper">
			<#include "asider.ftl" >
			<#--<#if Session["aa"]?exists>
				${Session["aa"]}

			</#if>
			<#if Session["myMenu"]?exists>
				优质
			</#if>-->
			<#--<#list Session["myMenu"]?exists as menu>
				${menu.text}

			</#list>-->
			<!--内容开始-->
			<div class="row">
				<div class="col-lg-12">
					<div class="panel panel-info">
						<div class="panel-heading">
							<i class=""></i> 欢迎使用本系统
							<@shiro.principal property="username" />
						</div>
						<div class="panel-body">
							<p>本项目使用 springboot,shiro,redis,freemarker构建</p>
						</div>
					</div>
				</div>
			</div>
				<!--内容结束-->
			<#include "footer.ftl">
			</div>
			
			
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
			$(document).ready(function() {
				setTimeout(function() {
					toastr.options = {
						closeButton: true,
						progressBar: true,
						showMethod: 'slideDown',
						timeOut: 4000
					};
					toastr.success('', '欢迎使用Tomato Admin');

				}, 1300);

			});
		</script>
		<script>
			$(function () {
				$('#side-menu').metisMenu('dispose');
				$.post("/user/menuList","",function (data) {
					var m = "";
					var n ="";
					var o ="";
					var obj = eval( "(" + data + ")" );//转换后的JSON对象

					for (var i =0; i<obj.length; i++){

						if(obj[i].parentId===0) {
							var m1 = '<li><a href="#"><i class="fa fa-sitemap"></i> <span class="nav-label">'+obj[i].text +'</span><span class="fa arrow"></span></a>';

							var id = obj[i].menuId;
							var  liobj = obj[i].nodes;
							if(liobj.length>0) {
								var m2 ='<ul class="nav nav-second-level collapse">';
								for(var j=0;j<liobj.length;j++) {
									if(id ===liobj[j].parentId){
										var m3 ='<li><a href="'+liobj[j].href+'">'+liobj[j].text+'</a></li>';
										n = n+m3;
									}
								}
								o = o+m2+n + '</ul>';
							}

							var m4 ='</li>';
							m = m1 + o+ m4;

						}

						$("#myMenuTree").after(m);
						m = "";
						n = "";
						o = "";
					}

				});
				$('#side-menu').metisMenu();
			})
			$.load(function () {
				$('#side-menu').metisMenu();
			});

		</script>

	</body>
</html>
