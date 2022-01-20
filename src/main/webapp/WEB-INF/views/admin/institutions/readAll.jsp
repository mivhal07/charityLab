<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: michal
  Date: 20.01.2022
  Time: 16:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Document</title>
</head>
<body>

<a href="/admin/institution/add" class="btn btn--without-border">Dodaj fundacje</a><br>

<table>
    <tbody>
    <tr>
        <td>Nazwa Fundacji</td>
        <td>Opis Fundacji</td>
        <td>Akcja</td>
        <br/>
    </tr>
    <br/>
    <c:forEach items="${institutions}" var="institution">
        <tr>
            <td>${institution.name}</td>
            <td>${institution.description}</td>
            <td>
                <a href="/admin/institution/update" class="btn">Edytuj</a>
                <a href="/admin/institution/delete" class="btn">Usuń</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>
