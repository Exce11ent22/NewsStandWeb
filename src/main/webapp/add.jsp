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

<jsp:include page="patterns/navbar.jsp" />

<h1>ACCEPTANCE OF GOODS</h1>

<div>
  <c:forEach items="${types}" var="type">
    <a class="btn btn-warning mb-3" href="${pageContext.request.contextPath}/add?type=${type.getTypeNumber()}">Add ${type.getItemClass().getSimpleName()}</a>
  </c:forEach>

  <c:if test="${type != null}" >
    <h3>Adding ${type.getItemClass().getSimpleName()}</h3>
  </c:if>

  <c:if test="${form != null}">
    <form action="${pageContext.request.contextPath}/add" method="post">
      <%= (String) request.getAttribute("form") %>
      <input type="number" name="amount" placeholder="How match?" required><br>
      <input class="btn btn-success" type="submit" value="Add">
    </form>
  </c:if>
</div>

</body>
</html>
