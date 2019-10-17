<!--
*
*  INSPINIA - Responsive Admin Theme
*  version 2.8
*
-->

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/html">

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
		
		<!-- DataTables CSS -->
		<link href="../../../static/js/datatables/datatables-plugins/dataTables.bootstrap.css" rel="stylesheet">
		
		<!-- DataTables Responsive CSS -->
		<link href="../../../static/js/datatables/datatables-responsive/dataTables.responsive.css" rel="stylesheet">

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
										<!---->
										<div style="width: 100%">	<p><h3>菜单列表</h3>
											<button type="button" class="btn btn-primary float-right" data-toggle="modal" data-target="#myModal4" style="margin: 5px;">
												新增+
											</button></p>
										</div>
										<div class="table-responsive">

											<table class="table table-striped table-bordered table-hover" id="treetable" style="width: 100%">
												<thead>
												<tr>
													<th></th>
													<th>名称</th>
													<th>链接</th>
													<th>类型</th>
													<th>排序</th>
													<th>权限</th>
													<th>备注</th>
												</tr>
												</thead>
												<tbody>

												</tbody>
											</table>
										
										</div>
										<!---->
										
										
									</div>
								</div>
							</div>
						</div>
					</nav>
				</div>
			<#include "../footer.ftl"/>

		</div>
<!---->
		<div class="modal inmodal" id="myModal4" tabindex="-1" role="dialog" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content animated fadeIn">
					<div class="modal-header">
						新增角色
					</div>
					<div class="modal-body">
						<form id="menuAdd" action="/menu/add" method="post">
							<div class="form-group">
								<label>Menu名称</label>
								<input name="menuName"  class="form-control" placeholder="名称" style="width: 30%;"></p>
							</div>
							<div class="form-group">
								<label>链接</label>
								<input name="url"  class="form-control" placeholder="链接" style="width: 30%;">
							</div>
							<div class="form-group">
								<label>上级菜单</label>
								<select name="parentId" class="form-control m-b" style="width: 30%;" id="getParent">
									<option value="">--请选择---</option>

									<#if Session["allMenuList"]?exists>

										<#list Session["allMenuList"] as menu>
											<option value="${menu.menuId}" >${menu.menuName}</option>
											<#list menu.children as mm>
												<option value="${mm.menuId}">${mm.menuName}</option>
											</#list>
										</#list>
									</#if>
								</select>
							</div>

							<div class="form-group">
								<label>类型</label>
								<input  type="radio" value="0" name="menuType"> 菜单</input>
								<input  type="radio" value="1" name="menuType"> 按钮</input>

							</div>
							<div class="form-group">
								<label>权限字符串</label>
								<input name="perms"  class="form-control" placeholder="权限字符串" style="width: 30%;">
							</div>
							<div class="form-group">
								<label>备注</label>
								<textarea name="remark" class="form-control" rows="3" style="width: 60%;"></textarea>
							</div>

							<button type="submit" class="btn btn-primary" data-dismiss="modal" onclick="menuSubmit()">确认</button>
						</form>

					</div>

				</div>
			</div>
		</div>
		<!---->



		<!-- Mainly scripts -->
		<#--<script src="../../../static/js/jquery-3.1.1.min.js"></script>-->
		<script src="../../../static/js/jquery.js" ></script>
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
		
		<!-- DataTables JavaScript -->
		<script src="../../../static/js/datatables/datatables/js/jquery.dataTables.min.js"></script>
		<script src="../../../static/js/datatables/datatables-plugins/dataTables.bootstrap.min.js"></script>
		<script src="../../../static/js/datatables/datatables-responsive/dataTables.responsive.js"></script>
		<script src="../../../static/js/datatables/dataTables.treeGrid.js"></script>


	</body>
	<script type="text/javascript">

		$(function() {

			var table = $('#treetable').DataTable({
				/**
				 l - Length changing 改变每页显示多少条数据的控件
				 f - Filtering input 即时搜索框控件
				 t - The Table 表格本身
				 i - Information 表格相关信息控件
				 p - Pagination 分页控件
				 r - pRocessing 加载等待显示信息
				 **/
				"dom": "tr",
				"ordering": false, //禁用排序
				"processing": true,
				"serverSide": true,
				"ajax": {
					"url": "${request.contextPath}/menu/getMenuTableData"
				},
				'treeGrid': {
					'left': 15,
					'expandAll': true, //是否默认展开 true 是
					'expandIcon': '<span class="fa fa-angle-right"> </span>',
					'collapseIcon': '<span class="fa fa-angle-down"> </span>'
				},

				"columns": [{
					className: 'treegrid-control',
					data: function(item) {
						if (item.children.length > 0) {
							return '<span class="fa fa-angle-right"></span>';
						}
						return '';
					}
				},
					{
						"data": "menuName"
					},
					{
						data:function(item) {
							if(null == item.url) {
								return null;
							}
							return item.url;
						}
					},

					{
						data: function(item) {
							if ("1"=== item.menuType) {
								return "菜单";
							}
							if ("0"=== item.menuType) {
								return "按钮";
							}
							return  null;
						}

					},
					{
						data: function(item) {
							var n = '';
							if(null == item.sort){
								n = "无";
							} else{
								n = ""+item.sort;
							}


							var html = '<input name="menuSort" type="text" value="' + n + '" class="form-control sorts" style ="width:70px;margin:0;padding:0;text-align:center;" > ';
							html = html + '<input name="menuSortId" type="hidden" value="' + item.menuId + '">';
							return html;
						}
					},
					{
						data:function(item){
							if(null == item.perms) {
								return null;
							}
							return item.perms
						}
					},

	{
                            data: function(item) {
                                if (item.status ==1) {
									var html = '<input name="menuSort" type="text" value="' + '启用'+ '" class="form-control sorts" style ="width:70px;margin:0;padding:0;text-align:center;" > ';
									html = html + '<input name="menuSortId" type="hidden" value="' + item.menuId + '">';
									return html;
                                } else {
									var html = '<input name="menuSort" type="text" value="' + '暂停使用' + '" class="form-control sorts" style ="width:70px;margin:0;padding:0;text-align:center;" > ';
									html = html + '<input name="menuSortId" type="hidden" value="' + item.menuId + '">';
									return html;
                                }
                            }
                        },
					/*{
                        data: function(item) {
                            var html = "<a onclick=\"edit('" + item.menuId + "');\" class='btn btn-success btn-xs' ><i class='fa
                            fa - edit '></i> 编辑</a> ";
                            html = html + "<a onclick=\"add('" + item.menuId + "');\" class='btn btn-primary btn-xs' ><i class='fa
                            fa - plus '></i> 添加下级菜单</a> ";
                            html = html + "<a onclick=\"deleteObject('" + item.menuId +
                                "');\" class='btn btn-danger btn-xs' ><i class='fa
                            fa - trash - o '></i> 删除</a> ";
                            return html;
                        }
                    }*/
				]
			});
		});
		function menuSubmit() {
			$("#menuAdd").submit();

		}

		$(function () {

		})
	</script>
</html>
