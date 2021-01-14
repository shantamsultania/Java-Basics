package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {


    @Autowired
    JdbcTemplate jdbcTemplate;

    HomeDao homeDao = new HomeDaoImpl();

    @RequestMapping("/rest")
    public void CreateTable()
    {
        homeDao.CreateTableHome();
    }

    @RequestMapping(method = RequestMethod.POST,value = "/rest")
    public void addHome()
    {
        homeDao.addHome();
    }



}
