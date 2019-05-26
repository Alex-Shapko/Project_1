package com.ystu.web_first.Model;

import com.ystu.web_first.Main;

import java.util.ArrayList;
import java.util.Arrays;

public class Data {
    private static Data data = null;

    public static Data getInstance() {
        if(data == null) {
            data = new Data();
        }
        return data;
    }

    private Data() {
        initData();
    }

    ArrayList<Guitar> guitars = new ArrayList<Guitar>();
    ArrayList<Customer> customers = new ArrayList<Customer>();
    ArrayList<Employee> employees = new ArrayList<Employee>();
    ArrayList<Order> orders = new ArrayList<Order>();
    boolean Buy;

    public  boolean isBuy() {
        return Buy;
    }

    public void setBuy(boolean buy) {
        Buy = buy;
    }

    public  void setOrders(ArrayList<Order> orders) {
        this.orders = orders;
    }

    //получить гитары
    public  ArrayList<Guitar> getGuitars() {
        return guitars;
    }

    //получить гитару по номеру
    public  Guitar getGuitarById(long id) {
        for (Guitar guitar : guitars){
            if (guitar.getId() == id){
                return guitar;
            }
        }
        return null;
    }


    /*public  Order getOrderById(long id) {
        Order current = null;
        for (Order or : orders){
            if (or.getId() == id){
                current = or;
                break;
            }
        }
        return current;
    }*/

    //получить заказ по номеру
    public  Order getOrderById(long id) {
        for (Order or : orders){
            if (or.getId() == id){
                return or;
            }
        }
        return null;
    }

    public void initData()
    {
        employees.add(new Employee(1,"Alex","qwerty", 22));
        customers.add(new Customer(1,"AlexS","1234", 22));
        customers.add(new Customer(1,"ArtemK","0987", 23));

        guitars.add(new Guitar(1,"Epiphone LP-100","Black",20000, GuitarType.Electric_guitar));
        guitars.add(new Guitar(2,"Fender Stratocaster","White",60000, GuitarType.Electric_guitar));
        guitars.add(new Guitar(3,"Fender Precision","Red",63000, GuitarType.Bass));
        guitars.add(new Guitar(4,"Takamine","Sunburst",40000, GuitarType.Acoustic));

        orders.add(new Order(3,1,1, Arrays.asList(1l)));
    }

}
