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
        <%! private int ig = 0;%>
        <%! private int g = 0;%>
        <%! private List<Long> GtrOrd;%>

        Число обращений к странице: <%= ++x %>
        <%Data.getInstance();%>


        <form id=<%=ig%> name="LoginShop" method="post">
        <p>Логин:<input type="text" name="name" /></p>
        <p>Пароль:<input type="password" name="pass" /></p>
        <p><input type="submit" name="submit" value="Вход" /></p>
        </form>

    </body>
</html>