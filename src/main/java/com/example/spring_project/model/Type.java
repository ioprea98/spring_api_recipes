package com.example.spring_project.model;

public class Type {
    private long id;
    private String name;

    public Type(){

    }

    public Type(String name) {
        this.name = name;
    }

    public Type(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
