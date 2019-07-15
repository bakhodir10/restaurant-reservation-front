<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <title>Restaurants</title>
</head>

<body>

<h5 style="align-items: center">Find your table for any occasion</h5>

<form class="form-inline">
    <div class="form-group mb-2">
        <input type="date" class="form-control-plaintext" id="date">
    </div>
    <div class="form-group mx-sm-3 mb-2">
        <input type="password" class="form-control" id="inputPassword2" placeholder="Password">
        <label>
            <select>
                <option>6:00</option>
                <option>6:30</option>
                <option>7:00</option>
                <option>7:30</option>
                <option>8:00</option>
                <option>8:30</option>
                <option>9:00</option>
                <option>9:30</option>
                <option>10:00</option>
            </select>
        </label>
    </div>
    <button type="submit" class="btn btn-primary mb-2">Confirm identity</button>
</form>
<%--	<h1>Cars currently in the shop</h1>--%>
<%--	<table>--%>
<%--		<c:forEach var="car" items="${cars}">--%>
<%--			<tr>--%>
<%--				<td>${car.make}</td>--%>
<%--				<td>${car.model}</td>--%>
<%--				<td>${car.year}</td>--%>
<%--				<td>${car.color}</td>--%>
<%--				<td><a href="cars/${car.id}">edit</a></td>--%>
<%--			</tr>--%>
<%--		</c:forEach>--%>
<%--	</table>--%>

<%--	<a href="/cars/add"> Add a Car</a>--%>

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
