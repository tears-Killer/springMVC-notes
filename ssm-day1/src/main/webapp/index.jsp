<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>主页</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<% if(session.getAttribute("user")==null){
    response.sendRedirect("login.jsp");
}%>
<body>
    <div class="container">
        <h3 class="page-header">书籍---------书籍列表</h3>
        <a href="${pageContext.request.contextPath}/book/toAddBook" class="btn btn-primary" style="float: left">新 增</a>
        <form class="form-inline" style="float: right" action="${pageContext.request.contextPath}/book/selectByName" method="post">
            <div class="form-group" >
                <label for="bname">书籍名称：</label>
                <input type="text" class="form-control" id="bname" placeholder="bookName" name="bname">
            </div>
            <button type="submit" class="btn btn-primary">Search</button>
        </form>
        <table class="table table-striped table-hover">
            <thead>
            <tr>
                <th>书名</th>
                <th>数量</th>
                <th>简介</th>
                <th>操作</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="book" items="${blist}">
            <tr>
                <td>${book.bname}</td>
                <td>${book.bcount}</td>
                <td>${book.details}</td>
                <td>
                    <a href="${pageContext.request.contextPath}/book/deleteBook?id=${book.bid}">删除</a>
                    <a href="${pageContext.request.contextPath}/book/selectBook?id=${book.bid}">修改</a>
                </td>
            </tr>
            </c:forEach>
            </tbody>
        </table>
        <div class="row clearfix">
            <div class="col-md-12 column">
                <ul class="pagination">
                    <% if(session.getAttribute("pageCount")!=null){
                        int pageCount = (int) session.getAttribute("pageCount");
                    %>
                    <li style="display:<%=pageCount - 1<1 ? "none" : ""%> " >
                        <a rel="nofollow" href="${pageContext.request.contextPath}/book/getAllBook?pageCount=<%=pageCount - 1 %>" class="one-pan-link-mark" >上一页</a>
                    </li>
                      <%
                          int count = (int) session.getAttribute("pages");
                          for(int i = 1; i <= count;i++){
                    %>
                    <li>
                        <a rel="nofollow" href="${pageContext.request.contextPath}/book/getAllBook?pageCount=<%=i %>" class="one-pan-link-mark"><%=i %></a>
                    </li>

                    <%
                    };
                    %>
                    <li style="display: <%=pageCount -0+1 > count? "none" : ""%>" >
                        <a rel="nofollow" href="${pageContext.request.contextPath}/book/getAllBook?pageCount=<%=pageCount + 1 %>" class="one-pan-link-mark" >下一页</a>
                    </li>
                    <%
                        };

                    %>
                </ul>
            </div>
        </div>
    </div>
</body>
</html>
