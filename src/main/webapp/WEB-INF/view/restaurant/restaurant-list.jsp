<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <title>Restaurant list</title>
</head>

<body>
<h1>All list of restaurants</h1>

<div style="float: right; display: inline-block">

    <%--    <div style="display: inline-block">--%>
    <%--        <a href="/admin/dining-tables/add">--%>
    <%--            <button type="button" class="btn btn-success">Add a table</button>--%>
    <%--        </a>--%>
    <%--    </div>--%>

    <div style="display: inline-block">
        <a href="/admin/restaurant/add">
            <button type="button" class="btn btn-success">Add a restaurant</button>
        </a>
    </div>
</div>


<br>
<table class="table">
    <thead>
    <tr>
        <th scope="col">Image</th>
        <th scope="col">Restaurant Name</th>
        <th scope="col">Address</th>
        <th>Add a table</th>
        <th>Edit restaurant</th>
        <th>Delete restaurant</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="restaurant" items="${restaurants}">
        <tr>
            <td>
                <img alt="img" src="data:image/jpeg;base64,${restaurant.image.base64image}" width="200px" height="150px"/>
            </td>
            <td>${restaurant.name}</td>
            <td>${restaurant.address.street} ${restaurant.address.city}
                    ${restaurant.address.state} ${restaurant.address.zipCode}
            </td>
            <td>
                <form action="/admin/restaurants/${restaurant.id}/dining-tables" method="post">
                    <button class="btn btn-primary" type="submit">Add</button>
                </form>
            </td>

            <td>
                <a href="restaurants/${restaurant.id}">
                    <button class="btn btn-primary">Edit</button>
                </a>
            </td>

            <td>
                <form action="/admin/restaurants/delete?id=${restaurant.id}" method="post">
                    <button class="btn btn-danger" type="submit">Delete</button>
                </form>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>


<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
</body>

</html>