package com.example.demo;

import io.github.biezhi.anima.Anima;
import io.github.biezhi.anima.core.AnimaQuery;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

import static io.github.biezhi.anima.Anima.*;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    // get Product
    @RequestMapping(method = RequestMethod.GET, value = "/product")
    public List<products> getAllProduct() {
        List<products> product = Anima.select().from(products.class).all();
        return product;
    }

    // get Product
    @RequestMapping(method = RequestMethod.GET, value = "/product/{id}")
    public AnimaQuery<products> getProduct(@PathVariable String id) {
        AnimaQuery<products> product = select().from(products.class).where("id == ", id);
        return product;
    }

    // add Product
    @RequestMapping(method = RequestMethod.POST, value = "/product")
    public String addProduct(@RequestBody products prod) {
        try {
            save(new products(prod.getName()));
            return "product added";
        } catch (Exception e) {
            return "product not added "+e;
        }
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/product/{id}")
    public String updateProduct(@RequestBody  products prod, @PathVariable int id) {

        Anima.update().from(products.class).set("name", prod.getName()).where("id", id).execute();
        return "product updated";
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/product/{id}")
    public String deleteProduct(@RequestBody products prod, @PathVariable int id) {
        Anima.delete().from(products.class).where("id", id).execute();
        return "product deleted";
    }
}
