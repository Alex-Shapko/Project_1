<%@ page import="java.util.List" %>
<%@ page import="java.util.Date" %>
<%@ page import="com.ystu.web_first.Model.*" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.ystu.web_first.Main" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page pageEncoding="UTF-8" %>
<html>
    <meta charset="utf-8" />
    <body>
        <h2>Hello World!</h2>

        <%! private int x = 0;%>
        <%! private int ig = 0;%>
        <%! private int g = 0;%>
        <%! private long [] GtrOrd;%>
        <%! private boolean open = false;%>
        <%! private boolean buy = false;%>

        Число обращений к странице: <%= ++x %>

        <c:set var="myName" value="Alex"/>
        <h1>${myName}</h1>


        <%Main.initData();%>
        <%! ArrayList<Guitar> guitarsView = new ArrayList<Guitar>();%>
        <%guitarsView = Main.getGuitars();%>
        <%g=guitarsView.size();%>

        Гитара:<%=Main.getGuitarById(1).getName()%>

        <h1>Список гитар:</h1>
        <% ((List)request.getAttribute("list")).clear(); %>

        <% for (int i=1; i<=g; i++) {%>
        <% ((List)request.getAttribute("list")).add (Main.getGuitarById(i)); %>
        <%}%>

        <table>
            <!-- here should go some titles... -->
            <col width="150" valign="top">
            <col width="100" valign="top">
            <col width="100" valign="top">
            <col width="100" valign="top">
            <col width="100" valign="top">
            <tr>
                <th>Наименование</th>
                <th>Цвет</th>
                <th>Цена</th>
                <th>Тип</th>
                <th>Купить</th>
            </tr>
            <c:forEach items="${list}" var="item">
                <% ++ig; %>
                <tr>
                    <td align="center">
                        ${item.name}
                    </td>
                    <td align="center">
                        ${item.color}
                    </td>
                    <td align="center">
                        ${item.price}
                    </td>
                    <td align="center">
                        ${item.type}
                    </td>
                    <td align="center">
                        <form id=<%=ig%> name="BuyGtrButton" method="post">
                            <input id="btn" type="submit" value=<%=ig%> name="button"; <% buy = true; %>/>
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </table>


        <% ((List)request.getAttribute("list")).clear(); %>
        <% ig=0; %>


        <h1>Корзина:</h1>
        <% if (buy == true) { %>
        <%=Main.getOrderById(1).getCustomer_id()%>
        <% GtrOrd = Main.getOrderById(1).getGuitars(); %>

        <%for (int j=0; j<GtrOrd.length; j++){ %>
            <%=Main.getGuitarById((GtrOrd[j])).getName()%>
        <% } %>
        <% } %>

        <c:set var="X1" value="<%=x%>"/>
        <c:if test="${X1 > 10}">
            <p>True<p>
        </c:if>
        <c:if test="${X1 < 10}">
            <p>False<p>
        </c:if>

        <br>


            <%-- ((List)request.getAttribute("list")).add(new Date()); %>
            <% ((List)request.getAttribute("list")).add (Main.getGuitarById(1).getName()); --%>



        <c:set var="num" scope="session" value="10"/>
        <c:choose>
            <c:when test="${num <= 0}">
                Если num <= 0
            </c:when>
            <c:when test="${num > 1000}">
                Если num > 1000
            </c:when>
            <c:otherwise>
                Если не одно условие не есть верно.
            </c:otherwise>
        </c:choose>

        <br>

        <c:forEach var="num" items="${list}">
            <p>${num}</p>
        </c:forEach>

        <% open = true; %>


    </body>
</html>
