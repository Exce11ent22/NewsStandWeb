<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Ivan Krikunov
  Date: 11.12.2021
  Time: 20:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Sell Item</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
  <style>
  </style>
</head>

<body class="container">

<jsp:include page="patterns/navbar.jsp" />

<h1>SALE OF GOODS</h1>

<div>
  <table class="table">
    <tr>
      <th>ID</th>
      <th>Class</th>
      <th>Title</th>
      <th>Author</th>
      <th>Publishing House</th>
      <th>Number</th>
      <th>Number of Pages</th>
      <th>Release Date</th>
      <th></th>
    </tr>
    <c:forEach items="${items}" var="item">

      <tr>
        <th>${item.id}</th>
        <td>${item.getClass().getSimpleName()}</td>
        <td>${item.title}</td>
        <td>${item.author}</td>
        <td>${item.publishingHouse}</td>
        <td>${item.number}</td>
        <td>${item.numberOfPages}</td>
        <td>${item.releaseDate.getTime().toString().split(" ")[1]} ${item.releaseDate.getTime().toString().split(" ")[2]} ${item.releaseDate.getTime().toString().split(" ")[5]}</td>
        <td><a class="btn btn-danger" href="${pageContext.request.contextPath}/sell?id=${item.id}">Продать</a></td>
      </tr>
    </c:forEach>
  </table>
</div>

</body>
</html>
