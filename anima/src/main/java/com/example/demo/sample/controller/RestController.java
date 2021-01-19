package com.example.demo.sample.controller;

import com.example.demo.sample.model.products;
import io.github.biezhi.anima.Anima;
import io.github.biezhi.anima.core.AnimaQuery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

import static io.github.biezhi.anima.Anima.*;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    // Logging

     Logger slj4jLogger = LoggerFactory.getLogger(RestController.class);


    // GET
    // get all products

    @RequestMapping(method = RequestMethod.GET, value = "/product")
    public List<products> getAllProduct() {
       try{
           List<products> product = Anima.select().from(products.class).all();
           return product;
       }catch (Exception e)
       {
           slj4jLogger.error("data was not received");
           return null;
       }
    }

    // GET
    // get one product

    @RequestMapping(method = RequestMethod.GET, value = "/product/{id}")
    public AnimaQuery<products> getProduct(@PathVariable String id) {
       try{
           AnimaQuery<products> product = select().from(products.class).where("id == ", id);
           return product;
       }catch (Exception e)
       {
           slj4jLogger.error("data was not received");
           return null;
       }
    }

    // POST
    // add Product

    @RequestMapping(method = RequestMethod.POST, value = "/product")
    public Integer addProduct(@RequestBody products prod) {
        try {
            save(new products(prod.getName()));
            return 200;
        } catch (Exception e) {
            return 404;
        }
    }

    // UPDATE(PUT)
    // update the product

    @RequestMapping(method = RequestMethod.PUT, value = "/product/{id}")
    public Integer updateProduct(@RequestBody products prod, @PathVariable int id) {
        try {

            Anima.update().from(products.class).set("name", prod.getName()).where("id", id).execute();
            return 200;
        }catch (Exception e)
        {
            slj4jLogger.error("data was not Updated "+e);
            return 404;
        }
    }

    // DELETE
    // delete the product

    @RequestMapping(method = RequestMethod.DELETE, value = "/product/{id}")
    public Integer deleteProduct(@PathVariable int id) {
        try {
            Anima.delete().from(products.class).where("id", id).execute();
            return 200;
        }catch (Exception e)
        {
            slj4jLogger.error("data was not Deleted "+e);
            return 404;
        }
    }




}
