<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Ivan Krikunov
  Date: 13.12.2021
  Time: 19:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Title</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body class="container">

<form action="${pageContext.request.contextPath}/add">
  <input class="btn btn-warning" type="submit" value="Back">
</form>

<form action="${pageContext.request.contextPath}/add" method="post">
  <%= (String) request.getAttribute("form") %>
  <input type="number" name="amount" placeholder="How match?" required><br>
  <input class="btn btn-success" type="submit" value="Add">
</form>

</body>
</html>
