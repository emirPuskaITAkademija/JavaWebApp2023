<%--
  Created by IntelliJ IDEA.
  User: Grupa 1
  Date: 5/15/2023
  Time: 7:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isErrorPage="true" %>
<html>
<head>
    <title>Error Page</title>
</head>
<body>
<h2>Greška !</h2>
<h3><%=exception.getMessage()%></h3>
</body>
</html>
