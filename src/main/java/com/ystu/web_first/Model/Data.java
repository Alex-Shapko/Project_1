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

    //получить покупателя по логину и паролю
    public  Customer getCustomerByLogPas(String log, String pass) {
        for (Customer cusLP : customers){
            if ((cusLP.getName().equals(log)) && (cusLP.getPass().equals(pass)) ){
                return cusLP;
            }
        }
        return null;
    }

    //получить id покупателя по логину и паролю
    public  long getIdCustomerByLogPas(String log, String pass) {
        for (Customer cusLP : customers){
            if ((cusLP.getName().equals(log)) && (cusLP.getPass().equals(pass)) ){
                return cusLP.getId();
            }
        }
        return 0;
    }

    //проверка на правильность логина и пароля
    public  boolean getLogin(String log, String pass) {
        for (Customer cusLP : customers){
            if ((cusLP.getName().equals(log)) && (cusLP.getPass().equals(pass))){
                return false;
            }
        }
        return true;
    }

    //получить гитары
    public  ArrayList<Guitar> getGuitars() {
        return guitars;
    }

    //получить гитару по ее номеру
    public  Guitar getGuitarById(long id) {
        for (Guitar guitar : guitars){
            if (guitar.getId() == id){
                return guitar;
            }
        }
        return null;
    }

    //установить заказ
    public  void setOrders(ArrayList<Order> orders) {
        this.orders = orders;
    }

    //получить заказ по его номеру
    public  Order getOrderById(long id) {
        for (Order or : orders){
            if (or.getId() == id){
                return or;
            }
        }
        return new Order();
    }

    //получить заказ по id прользователя
    public  Order getOrderByCustomer(long idCust) {
        for (Order or : orders){
            if (or.getCustomer_id() == idCust){
                return or;
            }
        }
        return new Order();
    }


    public void initData()
    {
        employees.add(new Employee(1,"Alex","qwerty", 22));
        customers.add(new Customer(1,"AlexS","1234", 22));
        customers.add(new Customer(2,"ArtemK","0987", 23));

        guitars.add(new Guitar(1,"Epiphone LP-100","Black",20000, GuitarType.Electric_guitar));
        guitars.add(new Guitar(2,"Fender Stratocaster","White",60000, GuitarType.Electric_guitar));
        guitars.add(new Guitar(3,"Fender Precision","Red",63000, GuitarType.Bass));
        guitars.add(new Guitar(4,"Takamine","Sunburst",40000, GuitarType.Acoustic));

       // orders.add(new Order(3,1,1, Arrays.asList(1l)));
    }

}
