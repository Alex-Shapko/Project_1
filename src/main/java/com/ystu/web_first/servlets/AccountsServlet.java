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
        //resp.setContentType("text/html");
        //req.setAttribute("todo", "10");

       // req.getRequestDispatcher("/login.jsp").forward(req, resp);

        String nameLog = req.getParameter("login");
        String pass = req.getParameter("pass");
        String forward="";
        IdCust = Data.getInstance().getIdCustomerByLogPas(nameLog,pass);

        //long idd = Data.getInstance().getCustomerByLogPas(nameLog, pass).getId();
        if (!Data.getInstance().getLogin(nameLog, pass)) {
            forward = "hello";
            req.getSession().setAttribute("idUser",IdCust);
            getServletContext().getRequestDispatcher("/index.jsp").forward(req,resp);
        }
        else {
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //resp.sendRedirect("/hello");
        resp.setContentType("text/html");
        //req.setAttribute("todo", "10");

//        String nameLog = req.getParameter("login");
//        String pass = req.getParameter("pass");
//        String forward="";
//        IdCust = Data.getInstance().getIdCustomerByLogPas(nameLog,pass);
//
//        //long idd = Data.getInstance().getCustomerByLogPas(nameLog, pass).getId();
//        if (!Data.getInstance().getLogin(nameLog, pass)) {
//            //req.getRequestDispatcher("/index.jsp").forward(req, resp);
//            forward = "hello";
//            req.getSession().setAttribute("idUser",IdCust);
//            //RequestDispatcher view = req.getRequestDispatcher(forward);
//            //view.forward(req, resp);
//            //RequestDispatcher view = req.getRequestDispatcher(forward);
//            //view.include(req, resp);
//
//            //resp.sendRedirect(forward);
//        }
//        else {
//            req.getRequestDispatcher("/login.jsp").forward(req, resp);
//        }
    }

}
