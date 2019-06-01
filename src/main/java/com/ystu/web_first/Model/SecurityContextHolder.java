package com.ystu.web_first.Model;


public class SecurityContextHolder {
    private static final ThreadLocal<Customer> threadLocalScope = new  ThreadLocal<Customer>();

    public final static Customer getLoggedUser() {
        return threadLocalScope.get();
    }

    
    public final static void setLoggedUser(Customer user) {
        threadLocalScope.set(user);
    }
}
