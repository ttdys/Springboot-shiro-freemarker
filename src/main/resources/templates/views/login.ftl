<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>Tomato Admin </title>

    <link href="../static/css/bootstrap.min.css" rel="stylesheet">
    <link href="../static/font-awesome/css/font-awesome.css" rel="stylesheet">
    <link href="../static/css/plugins/iCheck/custom.css" rel="stylesheet">
    <link href="../static/css/animate.css" rel="stylesheet">
    <link href="../static/css/style.css" rel="stylesheet">
    <link href="../static/css/plugins/awesome-bootstrap-checkbox/awesome-bootstrap-checkbox.css" rel="stylesheet">

</head>

<body class="gray-bg">

<div class="loginColumns animated fadeInDown">
    <div class="row">

        <div class="col-md-6">
            <h2 class="font-bold">欢迎使用Tomato Admin</h2>

            <p>本项目采用springboot2.1.X</p>
            <p>shiro</p>
            <p>freemarker</p>
            <p>Maven</p>
            <p>IDEA</p>

        </div>
        <div class="col-md-6">
            <div class="ibox-content">
                <form class="m-t" role="form" action="${request.contextPath}/user/login" method="post">
                    <label>请登录:</label>
                    <div class="form-group">
                        <input type="text" name="username" class="form-control" placeholder="用户名" required="true">
                    </div>
                    <div class="form-group">
                        <input type="password" name="password" class="form-control" placeholder="密码" required="true">
                    </div>
                    <div class="form-group">
                        <label><input type="text" name="verifyCode" class="form-control" placeholder="验证码"
                                      style="width: 180px;float: left">
                        <img src="${request.contextPath}/page/getVerifyCode"  style="width: 120px;height: 35px;float: right"/></label>
                    </div>
                    <div class="form-group">
                        <div class="i-checks"><label> <input type="checkbox" value="rememberMe"><i></i> 记得我 </label>
                        </div>
                    </div>

                    <button type="submit" class="btn btn-primary block full-width m-b">登录</button>

                    <a href="#">
                        <small>忘记密码?</small>
                    </a>


                </form>
                <p class="m-t">
                    <small>@Copyright www.github.com/zBlueWorld 2019</small>
                </p>
            </div>
        </div>
    </div>
    <hr/>
    <div class="row">
        <div class="col-md-6">
            Copyright @zjh
        </div>
        <div class="col-md-6 text-right">
            <small>© 2019</small>
        </div>
    </div>
</div>
<!-- Mainly scripts -->
<script src="../static/js/jquery-3.1.1.min.js"></script>
<script src="../static/js/popper.min.js"></script>
<script src="../static/js/bootstrap.js"></script>
<script src="../static/js/plugins/metisMenu/jquery.metisMenu.js"></script>
<script src="../static/js/plugins/slimscroll/jquery.slimscroll.min.js"></script>

<!-- Custom and plugin javascript -->
<script src="../static/js/inspinia.js"></script>
<script src="../static/js/plugins/pace/pace.min.js"></script>

<!-- iCheck -->
<script src="../static/js/plugins/iCheck/icheck.min.js"></script>
<script>
    $(document).ready(function () {
        $('.i-checks').iCheck({
            checkboxClass: 'icheckbox_square-green',
            radioClass: 'iradio_square-green',
        });
    });
</script>
</body>

</html>
