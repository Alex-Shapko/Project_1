package com.ystu.web_first.servlets;

import com.ystu.web_first.Model.Customer;
import com.ystu.web_first.Model.Data;
import com.ystu.web_first.Model.Order;

import com.ystu.web_first.spring.SpringConfigContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AccountsServlet extends HttpServlet {

    Long IdCust = null;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nameLog = req.getParameter("login");
        String pass = req.getParameter("pass");
        IdCust = Data.getInstance().getIdCustomerByLogPas(nameLog,pass);

        Long id =  (Long) req.getSession().getAttribute("idUser");
        if (id != null) {
            resp.sendRedirect("hello");
        }
        else {
            if (!Data.getInstance().getLogin(nameLog, pass)) {
                req.getSession().setAttribute("idUser",IdCust);
                getServletContext().getRequestDispatcher("/index.jsp").forward(req,resp);
            }
            else {
                req.getRequestDispatcher("/login.jsp").forward(req, resp);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //resp.sendRedirect("/hello");
        resp.setContentType("text/html");
        //req.setAttribute("todo", "10");
    }

}
