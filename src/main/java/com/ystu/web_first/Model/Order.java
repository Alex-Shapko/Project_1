package com.ystu.web_first.Model;

import java.util.List;

public class Order {
    private long id;
    private long customer_id;
    private long employee_id;
    private List<Long> guitars;

    public Order(long id, long customer_id, long employee_id, List<Long> guitars) {
        this.id = id;
        this.customer_id = customer_id;
        this.employee_id = employee_id;
        this.guitars = guitars;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(long customer_id) {
        this.customer_id = customer_id;
    }

    public long getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(long employee_id) {
        this.employee_id = employee_id;
    }

    public List<Long> getGuitars() {
        return guitars;
    }

    public void setGuitars(List<Long> guitars) {
        this.guitars = guitars;
    }
}
