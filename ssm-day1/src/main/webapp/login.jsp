<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/login.css"/>
</head>

<body>
<form action="${pageContext.request.contextPath}/user/login" method="post">
    <div class="container">
        <h2>登 录</h2>
        <p><input type="text" name="username" placeholder="username"></p>
        <p><input type="password" name="password" placeholder="password"></p>
        <input type="submit" value="登 录">
    </div>
</form>
</body>
</html>
