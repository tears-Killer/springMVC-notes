<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <h3 class="page-header">书籍---------修改书籍</h3>
    <form action="${pageContext.request.contextPath}/book/updateBook" method="post">
        <input type="hidden" name="bid" value="${book.bid}">
        <div class="form-group">
            <label for="bname">书籍名称</label>
            <input type="text" class="form-control" id="bname" placeholder="bookName" name="bname" value="${book.bname}">
        </div>
        <div class="form-group">
            <label for="bcount">书籍数量</label>
            <input type="text" class="form-control" id="bcount" placeholder="bookCount" name="bcount" value="${book.bcount}">
        </div>
        <div class="form-group">
            <label for="details">简介</label>
            <input type="text" class="form-control" id="details" placeholder="details" name="details" value="${book.details}">
        </div>
        <button type="submit" class="btn btn-primary">修 改</button>
        <a href="${pageContext.request.contextPath}/book/getAllBook" class="btn btn-primary">返 回</a>
    </form>
</div>
</body>
</html>
