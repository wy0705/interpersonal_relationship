<html lang="en">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <meta charset="UTF-8">
    <title>选择页面</title>
    <script src="${pageContext.request.contextPath}/js/jquery.js"></script>
    <script>
        function jump1() {
            window.location.herf="addrelation.jsp";
        }
        function jump2() {
            window.location.herf="addCourse.html";
        }

    </script>
</head>
<body>
<h2>选择功能</h2>
<input type="button" value="添加人物关系" onclick="jump1()"/>
<input type="button" value="查找人物关系" onclick="jump2()"/>
</body>
</html>