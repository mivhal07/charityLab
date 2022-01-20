<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="pl">
<head>
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <meta http-equiv="X-UA-Compatible" content="ie=edge" />
  <title>Document</title>
  <link rel="stylesheet" href="/resources/charity/css/style.css" />
</head>
<body>
<jsp:include page="/WEB-INF/views/headers/headerNormal.jsp"/>

<section class="login-page">
  <h2>Załóż konto</h2>
  <form:form method="post" modelAttribute="user">
    <div class="form-group">
      <form:input path="email" type="email" name="email" placeholder="E-mail"/>
    </div>
    <div class="form-group">
      <form:input path="username" type="text" name="username" placeholder="Nazwa użytkownika"/>
    </div>
    <div class="form-group">
      <form:input path="password" type="password" name="password" placeholder="Hasło"/>
    </div><div class="form-group">
    <form:input path="name" type="text" name="name" placeholder="Imię i nazwisko"/>
  </div>

    <div class="form-group form-group--buttons">
      <a href="login.html" class="btn btn--without-border">Zaloguj się</a>
      <form:button class="btn" type="submit">Załóż konto</form:button>
    </div>
  </form:form>
</section>

<jsp:include page="/WEB-INF/views/footer.jsp"/>
<script src="/resources/charity/js/app.js"/>
</body>
</html>