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
												<font size="3"> <strong>用户列表</strong></font>
												<button type="button" class="btn btn-primary float-right" data-toggle="modal" data-target="#addUserModel" style="margin: 5px;">
													新增+
												</button>
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
													<#list userList as user>
														<tr>
															<td>${user.username}</td>
															<td>${user.nikename  }</td>
															<td>${user.email  }</td>
															<td>${user.phone }</td>
															<td>${user.addr!}</td>
															<td>${user.sex  }</td>
															<td>${user.image! }</td>
															<td>${user.status  }</td>
															<td>${user.createTime?string('YYYY-mm-DD')  }</td>
															<td>${user.remark! }</td>
															<td> <button class="btn btn-info " type="button"><i class="fa fa-paste"></i> 更新</button>
																<button class="btn btn-warning " type="button"   data-toggle="modal" data-target="#isConfirm" onclick="valueR(${user.userId})" ><i class="fa fa-warning"></i> <span class="bold">删除</span></button>
														</tr>
													</#list>
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
		<div class="modal inmodal"  id="isConfirm" tabindex="-1" role="dialog" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content animated fadeIn">
					<div class="modal-header">
						<h3>确定删除吗?</h3>
					</div>
					<div class="modal-body " >
						<form action="/role/delete" id="deleteRole">
							<input type="hidden" name="userId" value="" id="vvR" >
							<div style="margin-right: 0px;float: right">
								<button type="button" class="btn btn-primary" data-dismiss="modal">取消</button>
								<button type="submit" class="btn btn-primary" data-dismiss="modal" onclick="deletePage()">确认</button>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>

		<!------------>
		<div class="modal inmodal" id="addUserModel" tabindex="-1" role="dialog" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content animated fadeIn">
					<div class="modal-header">
						新增角色
					</div>
					<div class="modal-body">
						<form id="userAdd" action="${request.contextPath}/user/add" method="post">
							<div class="form-group">
								<label>昵称</label>
								<input name="nikename"  class="form-control" placeholder="昵称" style="width: 30%;"></p>
							</div>
							<div class="form-group">
								<label>用户名</label>
								<input name="username"  class="form-control" placeholder="用户名" style="width: 30%;">
							</div>
							<div class="form-group">
								<label>登录密码</label>
								<input name="password"  type="password" class="form-control" placeholder="用户类型" style="width: 30%;">
							</div>
							<div class="form-group">
								<label>地址</label>
								<input name="addr"  class="form-control" placeholder="地址" style="width: 30%;">
							</div>
							<div class="form-group">
								<label>邮箱</label>
								<input name="email"  class="form-control" placeholder="邮箱" style="width: 30%;">
							</div>
							<div class="form-group">
								<label>电话</label>
								<input name="phone"  class="form-control" placeholder="电话" style="width: 30%;">
							</div>
							<div class="form-group">
								<label>性别</label>
								<select class="form-control" name="sex" style="width: 30%;">
									<option value="0">男</option>
									<option value="1">女</option>
									<option value="2">保密</option>
								</select>
							</div>
							<div class="form-group">
								<label>头像</label>
								<input name="img" class="form-control" placeholder="头像" style="width: 30%;">
							</div>
							<div class="form-group">
								<label>状态</label>
								<select class="form-control" name="status" style="width: 30%;">
									<option value="1">开启</option>
									<option value="0">停用</option>
								</select>
							</div>
							<div class="form-group">
								<label>备注</label>
								<textarea name="remark" class="form-control" rows="3" style="width: 60%;"></textarea>
							</div>
							<button type="submit" class="btn btn-primary" data-dismiss="modal" onclick="roleSubmit()">确认</button>
						</form>

					</div>

				</div>
			</div>
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
		<script>
			$(document).ready(function() {

				$('.footable').footable();
				$('.footable2').footable();

			});


			function userSubmit() {
				$("#userAdd").submit();
			}
			function deletePage() {
				$("#deleteRole").submit();
			}

			function valueR(ID) {
				var id = $("#vR").val();
				$("#vvR").attr("value",ID);
			}
		</script>

	</body>
</html>
