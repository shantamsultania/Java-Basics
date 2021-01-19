package com.example.demo.sample.model;

import io.github.biezhi.anima.Model;

public class products extends Model {

    String id;
    String name;

    products()
    {

    }
    public products(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
