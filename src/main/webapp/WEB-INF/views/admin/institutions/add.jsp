<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: michal
  Date: 21.01.2022
  Time: 12:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Document</title>
</head>
<body>
<form:form method="post" modelAttribute="institution">
    <label>Nazwa<form:input path="name"/></label>
    <label>Opis fundacji<form:input path="description"/></label>
    <input type="submit" value="Dodaj"/>
</form:form>
</body>
</html>
