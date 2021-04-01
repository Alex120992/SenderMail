<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="ru">
<head>
    <title>Home Page</title>
    <meta charset="UTF-8">
</head>
<body>
<form action="sendmail">
    <input type="text" name="name" placeholder="Введите Ваше имя">
<%--    <input type="email" name="mail" placeholder="Введите Вашу почту">--%>
    <br>
    <textarea name="message" cols="10" maxlength="30" placeholder="Введите сообщение"></textarea>
    <br>
    <input type="reset" value="Сброс">
    <input type="submit" name="submit" value="Отправить">
</form>
</body>
</html>

