<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>用户注册</title>
    <link rel="stylesheet" type="text/css" href="./css/styles.css">

</head>
<body>
<div class="wrapper">
<form class="form" id="registrationForm" action="./logincheck.action" method="post">
    <!--只有当所有的验证功能都通过之后，才会执行action功能-->
    <label for="username">用户名:</label>
    <input type="text" id="username" name="username" required>

    <label for="password">密码:</label>
    <input type="password" id="password" name="password" required>

    <label for="confirmPassword">确认密码:</label>
    <input type="password" id="confirmPassword" name="confirmPassword" required>

    <button type="submit">注册</button>
</form>
</div>
<script type="text/javascript" src="./js/jquery-2.1.1.min.js"></script>
<script type="text/javascript" src="./js/jquery.validate.min.js"></script>
<script type="text/javascript"
        src="./js/localization/messages_zh.js"></script>
<script>
    // 使用 jQuery Validate 插件进行前端验证
    $(document).ready(function () {
        $("#registrationForm").validate({
            rules: {
                username: {
                    required: true,
                    minlength: 3
                },
                password: {
                    required: true,
                    minlength: 6
                },
                confirmPassword: {
                    required: true,
                    equalTo: "#password"
                }
            },
            messages: {
                username: {
                    required: "请输入用户名",
                    minlength: "用户名至少包含3个字符"
                },
                password: {
                    required: "请输入密码",
                    minlength: "密码至少包含6个字符"
                },
                confirmPassword: {
                    required: "请确认密码",
                    equalTo: "两次输入的密码不一致"
                }
            },
            errorElement: "span",
            errorPlacement: function (error, element) {             //element: 页面重的input error:message中设置的
                error.addClass("ivalid-feedback");
                error.insertAfter(element);                        //在页面对应的元素后面紧挨着插入错误消息

            },

        });
    });
</script>
</body>


