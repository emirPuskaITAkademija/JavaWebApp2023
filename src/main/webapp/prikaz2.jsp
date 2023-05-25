<%--
  Created by IntelliJ IDEA.
  User: Grupa 1
  Date: 5/25/2023
  Time: 6:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Prikaz</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
<h3 style="text-align: center; margin: 10px;">${poruka}</h3>
<br>
<table class="table">
    <thead>
    <tr>
        <th scope="col">#</th>
        <th scope="col">First Name</th>
        <th scope="col">Last Name</th>
        <th scope="col">Username</th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <th scope="row">1</th>
        <td>${user.name}</td>
        <td>${user.surname}</td>
        <td>${user.username}</td>
    </tr>
    </tbody>
</table>
<a href="promjena.jsp">Promjenite korisničke podataka</a>
</body>
</html>
