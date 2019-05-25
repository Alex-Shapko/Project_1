package com.ystu.web_first.servlets;

import com.ystu.web_first.Model.Data;
import com.ystu.web_first.Model.Order;
import com.ystu.web_first.spring.SpringConfigContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jerde on 07.04.2017.
 */
public class HelloServlet extends HttpServlet {

    ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfigContext.class);
    List<Long> ArrayIdGtr = new ArrayList<Long>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        //req.setAttribute("todo", "10");

        List list = context.getBean(List.class);
        req.setAttribute("list", list);
        Data.getInstance().setBuy(false);
        req.getRequestDispatcher("/index.jsp").forward(req, resp);

    }


   /* @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        req.setAttribute("todo", "10");

        List list = context.getBean(Main.getGuitars().getClass());
        req.setAttribute("list", list);

        req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }*/

   @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //resp.setContentType("text/html");
        //req.setAttribute("todo", "10");

        List list = context.getBean(List.class);
        req.setAttribute("list", list);

        ArrayList<Order> or = new ArrayList<Order>();
        String name = req.getParameter("button");


        ArrayIdGtr.add(Long.parseLong(name));

        //Long [] ArrayIdGtrLong = null;
        //ArrayIdGtrLong=ArrayIdGtr.toArray(new Long [ArrayIdGtr.size()]);



        or.add(new Order(1,12,12,ArrayIdGtr));
        //or.add(new Order(1,12,12,new long[]{Long.parseLong(name)}));
        Data.getInstance().setOrders(or);
        Data.getInstance().setBuy(true);
        req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }

}
