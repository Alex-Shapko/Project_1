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

        Число обращений к странице: <%= ++x %>

        <c:set var="myName" value="Alex"/>
        <h1>${myName}</h1>


        <%Main.initData();%>
        <%! ArrayList<Guitar> guitarsView = new ArrayList<Guitar>();%>
        <%guitarsView = Main.getGuitars();%>
        <%g=guitarsView.size();%>

        Гитара:<%=Main.getGuitarById(1).getName()%>

        <h1>Список гитар:</h1>

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
                        <form name="myform" onsubmit="return OnSubmitForm();">
                            <input type="button" value=<%=ig%> name="button" onClick='submitForm(this)' >
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </table>

        <% ((List)request.getAttribute("list")).clear(); %>
        <% ig=0; %>

        <script type="text/javascript">
            function submitForm(x)
            {
                for (var j=1; j<=<%=g%>; j++){
                    if(x.value == 2) {
                        <% ig=4; %>
                    }
                    if(x.value == 1) {
                        <% ig=0; %>
                    }
                }


                if(document.pressed == 'Insert')
                {
                    document.myform.action ="Approve/insertform.jsp";
                }
                else
                if(document.pressed == 'Delete')
                {
                    document.myform.action ="Approve/deleteform.jsp";
                }
                else
                if(document.pressed == 'Update')
                {
                    document.myform.action="Approve/modifyform.jsp"
                }
                return true;
            }
        </script>




        <h1>Корзина:</h1>


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

    </body>
</html>
