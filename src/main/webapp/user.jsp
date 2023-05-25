<%--
  Created by IntelliJ IDEA.
  User: Grupa 1
  Date: 5/15/2023
  Time: 8:02 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Form</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
<h3>Unesite podatke o osobi</h3>
<form action="prikaz.jsp" method="post" style="padding: 50px;">
    <div class="row">
        <div class="col">
            <input type="text" class="form-control" placeholder="Name..." name="name">
        </div>
        <div class="col">
            <input type="text" class="form-control" placeholder="Surname..." name="surname">
        </div>
    </div>
    <div class="row">
        <div class="col">
            <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp"
                   placeholder="Enter email..." name="email">
        </div>
        <div class="col">
            <input type="text" class="form-control" placeholder="Phone.." name="phone">
        </div>
    </div>
    <div class="row">
        <div class="col">
            <input type="text" class="form-control" placeholder="Addresss..." name="address">
        </div>
        <div class="col">
            <input type="text" class="form-control" placeholder="Profession..." name="profession">
        </div>
    </div>
    <button type="submit" class="btn btn-primary">Submit</button>
</form>
</body>
</html>
