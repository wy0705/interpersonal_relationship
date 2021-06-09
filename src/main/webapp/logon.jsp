<html lang="en">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <meta charset="UTF-8">
    <title>登录</title>
    <script>

        $(function () {
            $("#submit").on('click', function () {
                $.ajax({
                    url: "/logon",
                    type: 'POST',
                    data: {'username': $("#username").val(),'id':$("#id").val(), 'password': $("#password").val()},
                    success: function (data) {
                        alert(data);
                    }
                });
            })
        });

    </script>
</head>
<body>
<h2>注册</h2>
用户名<input id="username" type="text"/>
年龄<input id="id" type="text">
密码<input id="password" type="password"/>
<input id="submit" type="submit" value="注册"/>
</body>
</html>
