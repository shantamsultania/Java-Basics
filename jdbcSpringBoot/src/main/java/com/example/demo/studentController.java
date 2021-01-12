package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.ResultSet;
import java.sql.SQLClientInfoException;
import java.sql.SQLException;
import java.util.List;

@RestController
public class studentController {

    @Autowired
    JdbcTemplate jdbc;

    @RequestMapping("/create")
    public String create() {
        try {
            String sql = "create table students.springboot(id VARCHAR(255),name Varchar (255))";
            jdbc.execute(sql);
            return "table created";
        }catch (Exception e)
        {
            return e.getMessage();
        }
    }

    @RequestMapping("/read")
    public List<student> read()
    {
        try {
            String sql = "SELECT * FROM students.springboot;";
            return jdbc.query(sql, new RowMapper<student>() {
                @Override
                public student mapRow(ResultSet rs, int rowNum) throws SQLException {
                    student stu = new student();
                    stu.setId(rs.getString(1));
                    stu.setName(rs.getString(2));
                    return stu;
                }
            });
        }
        catch (Exception e )
        {
            return null;
        }
    }


    @RequestMapping("/insert")
    public String insert() {
        try {
            String sql = "insert into students.springboot (id,name) values(\"101\",\"Spring boot trial\")";
            jdbc.execute(sql);
            return "data inserted";
        }catch (Exception e)
        {
            return e.getMessage();
        }
    }

    @RequestMapping("/update")
    public String update() {
        try {
            String sql = "update students.springboot set id ='111' where id = '101' ";
            jdbc.execute(sql);
            return "data inserted";
        }catch (Exception e)
        {
            return e.getMessage();
        }
    }



}
