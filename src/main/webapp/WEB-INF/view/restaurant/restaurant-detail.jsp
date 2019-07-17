<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>${msg} a Restaurant</title>
    <script type="text/javascript">
        $(document).ready(function () {
            $("#fileUploadErr").hide();

            // Hide The Error Message When The Attachment Btn Is Clicked.
            $('#pickUpFileAttachment').click(function (eObj) {
                $("#fileUploadErr").hide();
            });

            // Validating Whether The Attachment Is Uploaded Or Not.
            $('#fileUploadBtn').click(function (eObj) {
                var file = $("#pickUpFileAttachment").map(function () {
                    return $(this).val().trim() ? true : false;
                }).get();
                if (file.includes(true)) {
                    // Do Nothing...!
                } else {
                    $("#fileUploadErr").css({'color': 'red', 'font-weight': 'bold'}).show();
                    eObj.preventDefault();
                }
            });
        });
    </script>
</head>

<body>
<c:if test="${msg == 'Update'}">
<form action="../restaurants/${restaurant.id}" method="post" enctype="multipart/form-data">
    </c:if>
    <c:if test="${msg == 'Add'}">
    <form action="../restaurant" method="post" enctype="multipart/form-data">
        </c:if>
        <table>
            <tr>
                <td>Name:</td>
                <td><input type="text" name="name" value="${restaurant.name}"/></td>
            </tr>
            <tr>
                <td>Street:</td>
                <td><input type="text" name="address.street" value="${restaurant.address.street}"/></td>
            </tr>
            <tr>
                <td>City:</td>
                <td><input type="text" name="address.city" value="${restaurant.address.city}"/></td>
            </tr>
            <tr>
                <td>State:</td>
                <td><input type="text" name="address.state" value="${restaurant.address.state}"/></td>
            </tr>
            <tr>
                <td>Zip Code:</td>
                <td><input type="text" name="address.zipCode" value="${restaurant.address.zipCode}"/></td>
            </tr>
            <tr>
                <td>Attachment:</td>
                <td>
                    <input id="pickUpFileAttachment" type="file" name="attachFileObj" size="60"/>
                    <span id="fileUploadErr">Please Upload A Picture!</span>
                </td>
            </tr>
        </table>
        <input type="submit" value="${msg}"/>
    </form>
    <c:if test="${msg == 'Update'}">
    <form action="delete?id=${restaurant.id}" method="post">
        <br>
        <button type="submit">Delete</button>
    </form>
    </c:if>
</body>

</html>