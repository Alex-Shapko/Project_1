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
      initData();

    }

    public static void setOrders(ArrayList<Order> orders) {
        Main.orders = orders;
    }

    public static ArrayList<Guitar> getGuitars() {
        return guitars;
    }

    /*public static Guitar getGuitars2() {
        Guitar current = null;
        for (Guitar guitar: guitars) {
            current = guitar;
            break;
        }
        return current;
    }*/

    //получить гитару по номеру
    public static Guitar getGuitarById(long id) {
        Guitar current = null;
        for (Guitar guitar : guitars){
            if (guitar.getId() == id){
                current = guitar;
                break;
            }
        }
        return current;
    }


    public static Order getOrderById(long id) {
        Order current = null;
        for (Order or : orders){
            if (or.getId() == id){
                current = or;
                break;
            }
        }
        return current;
    }

    public static void initData()
    {
        employees.add(new Employee(1,"Шапко Алексей",22));

        customers.add(new Customer(1,"Артем Кузин",23));

        guitars.add(new Guitar(1,"Epiphone LP-100","Black",20000, GuitarType.Electric_guitar));
        guitars.add(new Guitar(2,"Fender Stratocaster","White",60000, GuitarType.Electric_guitar));
        guitars.add(new Guitar(3,"Fender Precision","Red",63000, GuitarType.Bass));
        guitars.add(new Guitar(4,"Takamine","Sunburst",40000, GuitarType.Acoustic));

        orders.add(new Order(3,1,1,new long[]{1}));
    }


}
