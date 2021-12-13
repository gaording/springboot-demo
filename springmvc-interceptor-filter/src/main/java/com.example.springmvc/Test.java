package com.example.springmvc;

public class Test {
    private transient String test;
    private String test1;

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }

    public String getTest1() {
        return test1;
    }

    public void setTest1(String test1) {
        this.test1 = test1;
    }

    public Test(String test) {
        this.test = test;
        this.test1 = test;
    }
}