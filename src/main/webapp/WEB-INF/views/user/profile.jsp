<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script type="text/javascript">
    $(document).ready(function () {
        // Handler for .ready() called.
        $('#changeAvatar').click(function () {
            $('#fileInput').click();
        });

        $("#fileInput").change(function () {
            $("#fileForm").submit();
        });
    });
</script>

<div class="container">

    <form:form method="post" action="/user/profile" commandName="userForm"
               class="form-narrow form-horizontal">

        <h4>profile</h4>

        <div class="form-group">
            <form:label path="email">email</form:label>
            <form:errors path="email" cssClass="label-danger">email_error</form:errors>
            <div class="col-lg-10">
                <form:input path="email" cssClass="form-control"/>
            </div>
        </div>

        <div class="form-group">
            <form:label path="password">password</form:label>
            <form:errors path="password">password_error</form:errors>
            <div class="col-lg-10">
                <form:password path="password" cssClass="form-control"/>
            </div>
        </div>

        <div class="form-group">
            <form:label path="confirmPassword">confirm_password</form:label>
            <form:errors path="confirmPassword">re_password_error</form:errors>
            <div class="col-lg-10">
                <form:password path="confirmPassword" cssClass="form-control"/>
            </div>
        </div>
        <input type="submit" class="btn btn-default"
               value="save"/>

    </form:form>


</div>

