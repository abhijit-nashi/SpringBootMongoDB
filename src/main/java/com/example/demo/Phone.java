package com.example.demo;

import org.springframework.stereotype.Component;

@Component("pp")
public class Phone {

    private int pid;
    private String pname;
    public int getPid() {
        return pid;
    }
    public void setPid(int pid) {
        this.pid = pid;
    }
    public String getPname() {
        return pname;
    }
    public void setPname(String pname) {
        this.pname = pname;
    }
    public void display()
    {
        System.out.println("Its Phone class");
    }
    
}
