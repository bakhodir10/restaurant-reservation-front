<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Restaurant list</title>
</head>

<body>
<h1>All list of restaurants</h1>
<table>
    <c:forEach var="restaurant" items="${restaurants}">
        <tr>
            <td>Name: ${restaurant.name}</td>
            <td>Address: ${restaurant.address.street} ${restaurant.address.city}
                    ${restaurant.address.state} ${restaurant.address.zipCode}
            </td>

            <td><a href="restaurants/${restaurant.id}">edit</a></td>
        </tr>
    </c:forEach>
</table>

<a href="/admin/restaurant/add"> Add a restaurant</a>
</body>

</html>