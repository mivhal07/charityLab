<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: michal
  Date: 10.01.2022
  Time: 11:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<header class="header">
    <nav class="container container--70">
        <sec:authorize access="isAnonymous()">
            <ul class="nav--actions">
                <li><a href="/login" class="btn btn--small btn--without-border">Zaloguj</a></li>
                <li><a href="/register" class="btn btn--small btn--highlighted">Załóż konto</a></li>
            </ul>
        </sec:authorize>
        <sec:authorize access="hasRole('ADMIN')">
            <div class="title">
                Cześć Admin
            </div>
        </sec:authorize>
        <sec:authorize access="hasRole('USER')">
            <div class="title">
                Witaj!
            </div>
        </sec:authorize>

        <ul>
            <li><a href="/" class="btn btn--without-border">Start</a></li>
            <li><a href="/donation/add" class="btn btn--without-border">Przekaż</a></li>
            <li><a href="#" class="btn btn--without-border">O co chodzi?</a></li>
            <li><a href="#" class="btn btn--without-border">O nas</a></li>
            <li><a href="#" class="btn btn--without-border">Fundacje i organizacje</a></li>
            <li><a href="#" class="btn btn--without-border">Kontakt</a></li>
            <sec:authorize access="isAuthenticated()">
                <form action="<c:url value="/logout"/>" method="post">
                    <input class="btn btn--without-border" type="submit" value="Wyloguj"><br/><br/>
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
                </form>
            </sec:authorize>
        </ul>
    </nav>

</header>
</body>
</html>
