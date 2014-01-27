<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<div class="navbar navbar-inverse navbar-fixed-top" id="navbar">
    <div style="margin-top: 15px; text-align: center" class="list-inline">

        <li><a href="/">main</a></li>
        <security:authorize ifNotGranted="ROLE_USER, ROLE_ADMIN">
            <li><a href="/anonymous/register">registration</a></li>
            <li><a href="/anonymous/login">login</a></li>
        </security:authorize>
        <security:authorize ifAnyGranted="ROLE_USER, ROLE_ADMIN">
            <li><a href="/user/profile"><security:authentication property="principal.username"/></a></li>
            <li><a href="<c:url value="j_spring_security_logout"/>">logout</a></li>
        </security:authorize>
    </div>
</div>
