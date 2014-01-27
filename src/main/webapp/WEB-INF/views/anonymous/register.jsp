<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<div class="container">

    <form:form method="post" action="/anonymous/register" commandName="registerForm"
               class="form-narrow form-horizontal">

        <h2>registration</h2>

        <div class="form-group">
            <form:label path="username">username</form:label>
            <form:errors path="username">username_error</form:errors>
            <div class="col-lg-10">
                <form:input path="username" cssClass="form-control"/>
            </div>
        </div>

        <div class="form-group">
            <form:label path="email">email</form:label>
            <form:errors path="email">email_error</form:errors>
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
        <input type="submit" class="btn btn-success"
               value="add_user"/>
    </form:form>

</div>
