<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>NewsStand Options</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
  <style>
  </style>
</head>
<body class="container">
<h1>NewsStand Application</h1>
<form class="mb-3" action="catalog">
  <input class="btn btn-secondary" type="submit" value="Catalog">
</form>
<form class="mb-3" action="add">
  <input class="btn btn-secondary" type="submit" value="Add Item">
</form>
<form class="mb-3" action="sell">
  <input class="btn btn-secondary" type="submit" value="Sell Item">
</form>
</body>
</html>
