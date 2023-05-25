<%--
  Created by IntelliJ IDEA.
  User: Grupa 1
  Date: 5/15/2023
  Time: 6:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- DIREKTIVA -->
<%@ page errorPage="error.jsp" %>

<!-- DEKLARACIJA -->
<%!
    int a;
    int b;
    int razlika;
    String prvi;
    String drugi;
%>

<!-- SKRIPLETE -->
<%
    prvi = request.getParameter("prvi");
    drugi = request.getParameter("drugi");
    a = Integer.parseInt(prvi);
    b = Integer.parseInt(drugi);
    razlika = a - b;
%>
<html>
<head>
    <title>Rezulat JSP</title>
</head>
<body bgcolor="<%if(razlika<0){%>blue<%}else if(razlika>0){%>green<%}else{%>red<%}%>">
    <h2>
        Razlika je "<%=razlika%>"
    </h2>
</body>
</html>
