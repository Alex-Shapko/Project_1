package com.ystu.web_first.Model;


public class SecurityContextHolder {
    private static final ThreadLocal<Person> threadLocalScope = new  ThreadLocal<Person>();

    public final static Person getLoggedUser() {
        return threadLocalScope.get();
    }

    public final static void setLoggedUser(Person user) {
        threadLocalScope.set(user);
    }
}
