package com.ystu.web_first.servlets;

import com.ystu.web_first.Model.Customer;
import com.ystu.web_first.Model.Data;
import com.ystu.web_first.Model.Order;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AccountsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        req.setAttribute("todo", "10");

        req.getRequestDispatcher("/login.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        req.setAttribute("todo", "10");

        String name = req.getParameter("name");
        String pass = req.getParameter("pass");

        Data.getInstance().getCustomerByLogPas(name, pass).getId();

        req.getRequestDispatcher("/login.jsp").forward(req, resp);
    }

}
