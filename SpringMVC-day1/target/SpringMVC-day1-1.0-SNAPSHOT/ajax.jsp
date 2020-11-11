<%--
  Created by IntelliJ IDEA.
  User: wj
  Date: 2020/7/3
  Time: 21:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@ page isELIgnored="false" %>
<head>
    <title>Title</title>
    <script src="${pageContext.request.contextPath}/js/jquery-3.4.1.min.js"></script>
    <script>
        let arr = [{
            username:'wj',
            age:22
        },{
            username: "wzx",
            age: 22
        }]

        $.ajax({
            url:'${pageContext.request.contextPath}/user/checklogin7',
            type:"post",
            data:JSON.stringify(arr),
            dataType:"json"
        })

    </script>
</head>
<body>

</body>
</html>
