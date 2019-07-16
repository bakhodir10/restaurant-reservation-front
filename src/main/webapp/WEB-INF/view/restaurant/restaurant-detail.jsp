<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>${msg} a Restaurant</title>
</head>

<body>
<c:if test="${msg == 'Update'}">
<form action="../restaurants/${restaurant.id}" method="post">
    </c:if>
    <c:if test="${msg == 'Add'}">
    <form action="../restaurant" method="post">
        </c:if>
        <table>
            <tr>
                <td>Name:</td>
                <td><input type="text" name="name" value="${restaurant.name}"/></td>
            </tr>
        </table>
        <input type="submit" value="${msg}"/>
    </form>
    <c:if test="${msg == 'Update'}">
    <form action="delete?id=${restaurant.id}" method="post">
        <button type="submit">Delete</button>
    </form>
    </c:if>
</body>

</html>