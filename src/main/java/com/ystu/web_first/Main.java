package com.ystu.web_first;

import com.ystu.web_first.Model.*;

import java.util.ArrayList;

public class Main {

    static ArrayList<Guitar> guitars = new ArrayList<Guitar>();
    static ArrayList<Customer> customers = new ArrayList<Customer>();
    static ArrayList<Employee> employees = new ArrayList<Employee>();
    static ArrayList<Order> orders = new ArrayList<Order>();


    public static void main(String[] args)
    {
        employees.add(new Employee(1,"Шапко Алексей",22));

        customers.add(new Customer(1,"Артем Кузин",23));

        guitars.add(new Guitar(1,"Ipiphone LP-100","Black",20000, GuitarType.Electric_guitar));
        guitars.add(new Guitar(2,"Fender Stratocaster","White",60000, GuitarType.Electric_guitar));
        guitars.add(new Guitar(3,"Fender Precision","Red",63000, GuitarType.Bass));
        guitars.add(new Guitar(4,"Takamine","Sunburst",40000, GuitarType.Acoustic));

        orders.add(new Order(1,1,1,new long[]{1}));

    }

}
