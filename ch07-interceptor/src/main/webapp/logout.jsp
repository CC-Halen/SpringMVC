<%--
  Created by IntelliJ IDEA.
  User: cdw
  Date: 2021/11/27
  Time: 21:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>logout</title>
</head>
<body>
注销操作：
<%
    session.removeAttribute("username");
%>
</body>
</html>
