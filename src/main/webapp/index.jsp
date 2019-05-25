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
        <h2>Hello World!</h2>

        <%! private int x = 0;%>
        <%! private int ig = 0;%>
        <%! private int g = 0;%>
        <%! private long [] GtrOrd;%>
        <%--! private boolean open = false;--%>
        <%--! private boolean buy = false;--%>

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
                            <input id="btn" type="submit" value=<%=ig%> name="button";/>
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </table>

        <% ((List)request.getAttribute("list")).clear(); %>
        <% ig=0; %>



        <h1>Корзина:</h1>
        <% if (Main.isBuy()==true) { %>
        <%=Main.getOrderById(1).getCustomer_id()%>
        <% GtrOrd = Main.getOrderById(1).getGuitars(); %>
        <table>
            <!-- here should go some titles... -->
            <col width="150" valign="top">
            <col width="100" valign="top">
            <col width="100" valign="top">
            <col width="100" valign="top">
            <tr>
                <th>Наименование</th>
                <th>Цвет</th>
                <th>Цена</th>
                <th>Тип</th>
        <%for (int j=0; j<GtrOrd.length; j++){ %>
            <tr>
                <td align="center">
                    <%=Main.getGuitarById((GtrOrd[j])).getName()%>
                </td>
                <td align="center">
                    <%=Main.getGuitarById((GtrOrd[j])).getColor()%>
                </td>
                <td align="center">
                    <%=Main.getGuitarById((GtrOrd[j])).getPrice()%>
                </td>
                <td align="center">
                    <%=Main.getGuitarById((GtrOrd[j])).getType()%>
                </td>
            </tr>
        <% } %>
        </table>
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






    </body>
</html>
