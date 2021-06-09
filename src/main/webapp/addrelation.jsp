<html lang="en">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <meta charset="UTF-8">
    <title>添加关系</title>
    <script>

        $(function () {
            $("#submit").on('click', function () {
                $.ajax({
                    url: "/addrelation",
                    type: 'POST',
                    data: {'mid': $("#mid").val(), 'sid': $("#sid").val(),'relation':$("#relation").val()},
                    success: function (data) {
                        alert(data);
                    }
                });
            })
        });

    </script>
</head>
<body>
<h2>添加人物关系</h2>
人物一id<input id="mid" type="text"/>
人物二id<input id="sid" type="text"/>
关系<input id="relation" type="text"/>
<input id="submit" type="submit" value="提交"/>
</body>
</html>
