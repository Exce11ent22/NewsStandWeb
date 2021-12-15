<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Ivan Krikunov
  Date: 11.12.2021
  Time: 20:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Catalog</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
  <style>
  </style>
</head>
<body class="container">

<jsp:include page="patterns/navbar.jsp" />

<h1>ITEMS REPOSITORY</h1>
<div>
  <table class="table">
    <tr>
      <th>Class</th>
      <th>Title</th>
      <th>Author</th>
      <th>Publishing House</th>
      <th>Number</th>
      <th>Number of Pages</th>
      <th>Release Date</th>
      <th>Amount</th>
    </tr>
    <c:forEach items="${items}" var="item">

      <tr>
        <td>${item.getKey().getClass().getSimpleName()}</td>
        <td>${item.getKey().title}</td>
        <td>${item.getKey().author}</td>
        <td>${item.getKey().publishingHouse}</td>
        <td>${item.getKey().number}</td>
        <td>${item.getKey().numberOfPages}</td>
        <td>${item.getKey().releaseDate.getTime().toString().split(" ")[1]} ${item.getKey().releaseDate.getTime().toString().split(" ")[2]} ${item.getKey().releaseDate.getTime().toString().split(" ")[5]}</td>
        <td>${item.getValue()}</td>
      </tr>
    </c:forEach>
  </table>
</div>

</body>
</html>
