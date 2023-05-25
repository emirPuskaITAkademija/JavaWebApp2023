<%--
  Created by IntelliJ IDEA.
  User: Grupa 1
  Date: 5/15/2023
  Time: 8:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Prikaz Korisnika</title>
</head>
<jsp:useBean id="korisnik" class="com.simple.javawebapp2023.five.bean.User" scope="session"/>
<jsp:setProperty name="korisnik" property="*"/>
<body>
<table>
  <tr>
    <td>Ime</td>
    <td>${korisnik.name}</td>
  </tr>
  <tr>
    <td>Prezime</td>
    <td>${korisnik.surname}</td>
  </tr>
  <tr>
    <td>Email</td>
    <td>${korisnik.email}</td>
  </tr>
  <tr>
    <td>Telefon</td>
    <td>${korisnik.phone}</td>
  </tr>
  <tr>
    <td>Adresa</td>
    <td>${korisnik.address}</td>
  </tr>
  <tr>
    <td>Zanimanje</td>
    <td>${korisnik.profession}</td>
  </tr>
</table>
</body>
</html>
