package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
//@Scope("prototype")
public class Student {

    private int id;
    private String name;
    @Autowired
    @Qualifier("pp")
    private Phone p;
    public Phone getP() {
        return p;
    }
    public void setP(Phone p) {
        this.p = p;
    }
    public int getId() {
        return id;
    }
    public Student() {
        System.out.println("Object created");
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void show(){
        System.out.println("Student class");
        p.display();
    }
    
    
}
