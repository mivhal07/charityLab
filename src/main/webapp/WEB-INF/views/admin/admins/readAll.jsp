<%--
  Created by IntelliJ IDEA.
  User: michal
  Date: 21.01.2022
  Time: 14:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Dokument</title>
</head>
<body>
<a href="/admin/admins/add" class="btn btn--without-border">Dodaj admina</a><br>

<table>
    <tbody>
    <tr>
        <td>Imię i nazwisko</td>
        <td>Nazwa użytkownika</td>
        <td>E-mail</td>
        <td>Hasło</td>
        <td>Akcja</td>
        <br/>
    </tr>
    <br/>
    <c:forEach items="${admins}" var="institution">
        <tr>
            <td>${institution.name}</td>
            <td>${institution.username}</td>
            <td>${institution.email}</td>
            <td>${institution.password}</td>
            <td>
                <a href="/admin/institutions/update/${institution.id}" class="btn">Edytuj</a>
                <a href="/admin/institutions/delete/${institution.id}" class="btn">Usuń</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
