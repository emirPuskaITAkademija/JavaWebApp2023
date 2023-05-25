<%--
  Created by IntelliJ IDEA.
  User: Grupa 1
  Date: 5/25/2023
  Time: 6:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
<h3 style="text-align: center; padding: 50px;">Welcome</h3>
<form action="login-servlet" method="post" style="padding: 50px;">
    <div class="row">
        <div class="col">
            <input type="text" class="form-control" placeholder="Name..." name="username">
        </div>
        <div class="col">
            <input type="password" class="form-control" placeholder="Password..." name="password">
        </div>
    </div>
    <button style="margin-top: 20px; margin-bottom: 20px;" type="submit" class="btn btn-primary btn-lg btn-block">Login</button>
    <div>
        <p style="color:red; font-size: large; font-family: Arial;">${poruka!=null?poruka:""}</p>
    </div>
</form>
</body>
</html>
