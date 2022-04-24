<%--
  Created by IntelliJ IDEA.
  User: 16231
  Date: 2022/4/23
  Time: 16:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    request.getRequestDispatcher("mainPage.jsp").forward(request,response);
%>
</body>
</html>
