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
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>

<body style="margin: 25px">
<h4>${msg} form</h4>
<c:if test="${msg == 'Update'}">
<form action="../restaurants/${restaurant.id}" method="post" enctype="multipart/form-data">
    </c:if>
    <c:if test="${msg == 'Add'}">
    <form action="../restaurant" method="post" enctype="multipart/form-data">
        </c:if>
        <form>
            <div class="form-group" style="">
                <label for="name">Name</label>
                <input type="text" class="form-control" name="name" value="${restaurant.name}" id="name"
                       placeholder="Enter name">
            </div>
            <div class="form-group">
                <label for="street">Street</label>
                <input type="text" class="form-control" id="street" name="address.street"
                       value="${restaurant.address.street}" placeholder="Enter street">
            </div>
            <div class="form-group">
                <label for="city">City</label>
                <input type="text" class="form-control" id="city" name="address.city"
                       value="${restaurant.address.city}"
                       placeholder="Enter city">
            </div>
            <div class="form-group">
                <label for="state">State</label>
                <input type="text" class="form-control" id="state" name="address.state"
                       value="${restaurant.address.state}"
                       placeholder="Enter state">
            </div>
            <div class="form-group">
                <label for="zipCode">Zip Code</label>
                <input type="text" class="form-control" name="address.zipCode" value="${restaurant.address.zipCode}"
                       id="zipCode"
                       placeholder="Enter zipCode">
            </div>
            <div class="form-group">
                <label for="pickUpFileAttachment">Please upload an image</label>
                <input type="file" class="form-control" name="attachFileObj" id="pickUpFileAttachment"
                size="1024">
            </div>
            <button type="submit" class="btn btn-primary">${msg}</button>
        </form>
    </form>

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