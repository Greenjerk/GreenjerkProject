<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<div class="container">

    <form name='f' action="<c:url value='j_spring_security_check'/>"
          class="form-narrow form-horizontal" method='POST'>

        <h2>login</h2>

        <c:if test="${not empty error}">
            <div class="errorblock">
                caused
                    ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
            </div>
        </c:if>

        <div class="form-group">
            <h5>username</h5>
                <div class="col-lg-10">
            <input type='text' name='j_username' value='' class="form-control">
                    </div>
        </div>

        <div class="form-group">
           password
                <div class="col-lg-10">
            <input type='password' name='j_password' class="form-control"/>
                    </div>
        </div>

        <input name="submit" type="submit" class="btn btn-default"
               value="login"/>

    </form>
</div>
