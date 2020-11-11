<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/9/14 0014
  Time: 9:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
</head>
<body>
    <form action="/login" method="post">
        <p>账号:<input type="text" name="username"></p>
        <p>密码:<input type="password" name="password"></p>
        <input type="submit" value="登录">
    </form>
</body>
</html>
