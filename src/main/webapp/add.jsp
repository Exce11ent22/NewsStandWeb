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
  <title>Add Items</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
  <style>
  </style>
</head>
<body class="container">
<h1>ACCEPTANCE OF GOODS</h1>

<div>
  <c:forEach items="${types}" var="type">
    <a class="btn btn-primary mb-3" href="${pageContext.request.contextPath}/add?type=${type.getTypeNumber()}">Add ${type.getItemClass().getSimpleName()}</a><br>
  </c:forEach>
</div>

<form class="mb-3" action="${pageContext.request.contextPath}/">
  <input class="btn btn-warning" type="submit" value="Back">
</form>
</body>
</html>
