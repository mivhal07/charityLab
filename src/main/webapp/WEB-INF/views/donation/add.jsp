<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: michal
  Date: 13.01.2022
  Time: 17:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>
    </title>
</head>
<body>

<form:form modelAttribute="donation" method="post">
    <label for="kategorie">Wybierz kategorię rzeczy do oddania</label><br/>
    <form:checkboxes path="categories"
                     items="${categories}" id="kategorie"/><br/><br/>
    <form:errors path="categories"/>
<%--    <label for="instytucje">Do której instytucji mają iść dary</label><br/>--%>
    <form:select id="instytucje" path="institution" items="${institutions}" itemValue="id" itemLabel="name"/><br/><br/>
    <form:errors path="institution"/>
    <label for="zipCode">Kod pocztowy</label><br/>
    <form:input path="zipCode" placeholder="kod pocztowy" id="zipCode"/><br/><br/>
    <form:errors path="zipCode"/>
    <label for="street">Ulica</label><br/>
    <form:input path="street" placeholder="ulica" id="street"/><br/><br/>
    <form:errors path="street"/>
    <label for="city">Miasto</label><br/>
    <form:input path="city" placeholder="miasto" id="city"/><br/><br/>
    <form:errors path="city"/>
    <label for="quantity">Ilość Worków 60l</label><br/>
    <form:input path="quantity" placeholder="ilość worków" id="quantity"/><br/><br/>
    <form:errors path="quantity"/>
    <label for="wiadomość">Wiadomość dla kuriera</label><br/>
    <form:textarea path="pickUpComment" placeholder="dla kuriera" id="wiadomość"/><br/><br/>
    <form:errors path="pickUpComment"/>
    <label for="pickUpDate">Data odbioru</label><br/>
    <form:input type="date" path="pickUpDate" placeholder="data odioru" id="pickUpDate"/><br/><br/>
    <form:errors path="pickUpDate"/>
    <label for="czas">Czas odbioru</label><br/>
    <form:input type="time" path="pickUpTime" placeholder="czas odbioru" id="czas"/><br/><br/>
    <form:errors path="pickUpTime"/>
    <input type="submit" value="Zapisz">
</form:form>

</body>
</html>
