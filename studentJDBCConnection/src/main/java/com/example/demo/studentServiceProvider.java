package com.example.demo;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class studentServiceProvider {

    public studentServiceHandler studentServiceHandler = new studentServiceHandler();


    // GET
    // Create Table

    @RequestMapping("/create")
    public String create()
    {
        return studentServiceHandler.create();
    }

    // POST
    // Insert data in Table

    @RequestMapping(method = RequestMethod.POST , value = "/insert")
    public String insert(@RequestBody student student)
    {
        return studentServiceHandler.insert(student);
    }

    // PUT
    // Update data in table

    @RequestMapping(method = RequestMethod.PUT,value = "/update/{id}")
    public String update(@RequestBody student stu,@PathVariable String id)
    {
        return studentServiceHandler.update(stu,id);
    }

    // GET
    // GET ALL DATA

    @RequestMapping("/sql/all")
    public List<student> getAll()
    {
        return studentServiceHandler.getAll();
    }

    @RequestMapping(method = RequestMethod.DELETE,value = "/delete/{id}")
    public String delete(@PathVariable String id)
    {
        return studentServiceHandler.delete(id);
    }




}
