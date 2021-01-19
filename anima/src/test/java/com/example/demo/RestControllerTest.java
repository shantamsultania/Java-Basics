package com.example.demo;

import com.example.demo.sample.controller.RestController;
import com.example.demo.sample.model.products;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RestControllerTest extends BaseTest{

    private RestController restController = new RestController();


    @Test
    public void getAllProducts()
    {
        mysql();
        List<products> act = restController.getAllProduct();
        if(act.isEmpty())
        {
            System.out.println("Empty  checks ");
        }
        System.out.println("--------------------");
        System.out.println("Products List :");
        System.out.println("--------------------");
        for (products products : act)
        {
            System.out.println("Id : "+products.getId()+" Name : "+products.getName());
        }
        System.out.println("--------------------");
    }
    @Test
    public void addProduct()
    {
        mysql();
        products products = new products("demo2");
        Integer result = restController.addProduct(products);
        assertEquals(200,result);
        getAllProducts();
    }

    @Test
    public void updateProduct()
    {
        mysql();
        products products = new products("updated product");
        Integer result = restController.updateProduct(products,1);
        assertEquals(200,result);
        getAllProducts();
    }
    @Test
    public void deleteProduct()
    {
        mysql();
        Integer result = restController.deleteProduct(3);
        assertEquals(200,result);
        getAllProducts();
    }






}