package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class HomeDaoImpl implements HomeDao {

    @Autowired
    JdbcTemplate jdbc;

    public HomeDaoImpl() {
        jdbc = new JdbcTemplate();
    }

    @Override
    public void CreateTableHome() {
        String sql = "create table students.home(id VARCHAR(255),name Varchar (255))";
        JdbcTemplate jdbc = new JdbcTemplate();
                jdbc.execute(sql);
    }

    @Override
    public List<String> getAllHomes() {
            return null;
    }

    @Override
    public void addHome() {
        String sql = "insert into students.home (id,name) values(\"101\",\"trial\")";
        jdbc.execute(sql);
    }
}
