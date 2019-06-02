<%@ page import="java.util.List" %>
<%@ page import="java.util.Date" %>
<%@ page import="com.ystu.web_first.Model.*" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.ystu.web_first.Main" %>
<%@ page import="com.ystu.web_first.servlets.HelloServlet" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page pageEncoding="UTF-8" %>
<html>
    <meta charset="utf-8" />
    <body>
        <h2>Авторизация</h2>

        <%! private int x = 0;%>
        Число обращений к странице: <%= ++x %>

        <form id=<%=ig%> name="LoginShop" method="get">
        <p>Логин:<input type="text" name="login" /></p>
        <p>Пароль:<input type="password" name="pass" /></p>
        <p><input type="submit" name="submit" value="Вход" /></p>
        </form>

    </body>
</html>
