<!--
*
*  INSPINIA - Responsive Admin Theme
*  version 2.8
*
-->

<!DOCTYPE html>
<html>

	<head>

		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">

		<title>Tomato Admin</title>

		<link href="../../../static/css/bootstrap.min.css" rel="stylesheet">
		<link href="../../../static/font-awesome/css/font-awesome.css" rel="stylesheet">

		<!-- Toastr style -->
		<link href="../../../static/css/plugins/toastr/toastr.min.css" rel="stylesheet">

		<!-- Gritter -->
		<link href="../../../static/js/plugins/gritter/jquery.gritter.css" rel="stylesheet">

		<link href="../../../static/css/animate.css" rel="stylesheet">
		<link href="../../../static/css/style.css" rel="stylesheet">
		<!-- FooTable -->
		<link href="../../../static/css/plugins/footable/footable.core.css" rel="stylesheet">

		<link href="../../../static/css/animate.css" rel="stylesheet">
		<link href="../../../static/css/style.css" rel="stylesheet">

	</head>

	<body>
		<div id="wrapper">
			  <#include "../asider.ftl"/>


				<div class="row border-bottom">
					<nav class="navbar navbar-static-top" role="navigation" style="margin-bottom: 0">

						<div class="col-lg-12">
							<div class="panel panel-info">
								<div class="panel-heading">
									<i class=""></i>
									<h3>欢迎使用本系统</h3>
								</div>
								<div class="panel-body">
									<div class="col-lg-12">
										<div class="ibox ">
											<div class="ibox-title">
												<font size="3"> <strong>部门列表</strong></font>
												<button type="button" class="btn btn-primary float-right" data-toggle="modal" data-target="#myModal4" style="margin: 5px;">
													新增+
												</button>
												<!-- <div class="ibox-tools">
													<a class="collapse-link">
														<i class="fa fa-chevron-up"></i>
													</a>
													<a class="dropdown-toggle" data-toggle="dropdown" href="#">
														<i class="fa fa-wrench"></i>
													</a>
													<ul class="dropdown-menu dropdown-user">
														<li><a href="#" class="dropdown-item">Config option 1</a>
														</li>
														<li><a href="#" class="dropdown-item">Config option 2</a>
														</li>
													</ul>
													<a class="close-link">
														<i class="fa fa-times"></i>
													</a>
												</div> -->
											</div>
											<div class="ibox-content">

												<table class="footable table table-stripped toggle-arrow-tiny">
													<thead>
														<tr>

															<th data-toggle="true">用户名</th>
															<th>昵称</th>
															<th>邮箱</th>
															<th>电话</th>
															<th data-hide="all">地址</th>
															<th data-hide="all">性别</th>
															<th data-hide="all">头像</th>
															<th data-hide="all">状态</th>
															<th data-hide="all">创建时间</th>
															<th data-hide="all">备注</th>
															<th>操作</th>
														</tr>
													</thead>
													<tbody>
														<tr>
															<td>拉拉</td>
															<td>Patrick Smith</td>
															<td>0800 051213</td>
															<td>Inceptos Hymenaeos Ltd</td>
															<td><span class="pie">0.52/1.561</span></td>
															<td>20%</td>
															<td>Jul 14, 2013</td>
															<td></td>
															<td></td>
															<td></td>
															<td> <button class="btn btn-info " type="button"><i class="fa fa-paste"></i> 更新</button>
																<button class="btn btn-warning " type="button"><i class="fa fa-warning"></i> <span class="bold">删除</span></button></td>
														</tr>

													</tbody>
													<tfoot>
														<tr>
															<td colspan="5">
																<ul class="pagination float-right"></ul>
															</td>
														</tr>
													</tfoot>
												</table>

											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</nav>
				</div>
			<#include "../footer.ftl"/>

		</div>

		<!-- Mainly scripts -->
		<script src="../../../static/js/jquery-3.1.1.min.js"></script>
		<script src="../../../static/js/popper.min.js"></script>
		<script src="../../../static/js/bootstrap.js"></script>
		<script src="../../../static/js/plugins/metisMenu/jquery.metisMenu.js"></script>
		<script src="../../../static/js/plugins/slimscroll/jquery.slimscroll.min.js"></script>

		<!-- Flot -->
		<script src="../../../static/js/plugins/flot/jquery.flot.js"></script>
		<script src="../../../static/js/plugins/flot/jquery.flot.tooltip.min.js"></script>
		<script src="../../../static/js/plugins/flot/jquery.flot.spline.js"></script>
		<script src="../../../static/js/plugins/flot/jquery.flot.resize.js"></script>
		<script src="../../../static/js/plugins/flot/jquery.flot.pie.js"></script>

		<!-- Peity -->
		<script src="../../../static/js/plugins/peity/jquery.peity.min.js"></script>
		<script src="../../../static/js/demo/peity-demo.js"></script>

		<!-- Custom and plugin javascript -->
		<script src="../../../static/js/inspinia.js"></script>
		<script src="../../../static/js/plugins/pace/pace.min.js"></script>

		<!-- jQuery UI -->
		<script src="../../../static/js/plugins/jquery-ui/jquery-ui.min.js"></script>

		<!-- GITTER -->
		<script src="../../../static/js/plugins/gritter/jquery.gritter.min.js"></script>

		<!-- Sparkline -->
		<script src="../../../static/js/plugins/sparkline/jquery.sparkline.min.js"></script>

		<!-- Sparkline demo data  -->
		<script src="../../../static/js/demo/sparkline-demo.js"></script>

		<!-- ChartJS-->
		<script src="../../../static/js/plugins/chartJs/Chart.min.js"></script>

		<!-- Toastr -->
		<script src="../../../static/js/plugins/toastr/toastr.min.js"></script>
		<!-- FooTable -->
		<script src="../../../static/js/plugins/footable/footable.all.min.js"></script>
		<!-- Page-Level Scripts -->
		<script>
			$(document).ready(function() {

				$('.footable').footable();
				$('.footable2').footable();

			});
		</script>

	</body>
</html>
