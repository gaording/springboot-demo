package com.example.messageconverter.controller;

/**
 * @program: springboot-demo
 * @date: 2021/12/13
 * @author: gaorunding1
 * @description:
 **/
public class Entity {
    private String name;
    private transient String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
