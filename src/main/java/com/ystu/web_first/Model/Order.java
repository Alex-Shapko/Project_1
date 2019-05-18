package com.ystu.web_first.Model;

public class Order {
    private long id;
    private long customer_id;
    private long employee_id;
    private long[]guitars;

    public Order(long id, long customer_id, long employee_id, long[] guitars) {
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

    public long[] getGuitars() {
        return guitars;
    }

    public void setGuitars(long[] guitars) {
        this.guitars = guitars;
    }
}
