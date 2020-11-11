<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<%@ page isELIgnored="false" %>
<body>
    <form action="${pageContext.request.contextPath}/user/checklogin6" method="post">
        <input type="text" name="ulist[0].username"/><br>
        <input type="text" name="ulist[0].age"/><br>
        <input type="text" name="ulist[1].username"/><br>
        <input type="text" name="ulist[1].age"/><br>
        <input type="submit" value="登录"/>
    </form>
</body>
</html>
