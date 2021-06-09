<html lang="en">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <meta charset="UTF-8">
    <title>添加关系</title>
    <script>

        $(function () {
            $("#submit").on('click', function () {
                $.ajax({
                    url: "/findrelation",
                    type: 'POST',
                    data: {'mid': $("#mid").val(), 'sid': $("#sid").val()},
                    success: function (data) {
                        alert(data);
                    }
                });
            })
        });

    </script>
</head>
<body>
<h2>查找人物关系</h2>
人物一id<input id="mid" type="text"/>
人物二id<input id="sid" type="text"/>
<input id="submit" type="submit" value="查找"/>
</body>
</html>
