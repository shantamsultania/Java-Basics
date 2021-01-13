package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class studentServiceHandler {

    @Autowired
    JdbcTemplate jdbc;

    @Autowired
    DataSource dataSource;
    // GET
    public List<student> getAll()
    {
        try {
            String sql = "SELECT * FROM students.studentApi;";
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

    // GET
    public String create()
    {
        try {
            String sql = "create table students.spring(id VARCHAR(255),name Varchar (255))";
            jdbc.execute(sql);
            return "table created";
        }catch (Exception e)
        {
            return "not";
        }
    }

    // POST
    public String insert(student stu)
    {
        String id = stu.getId();
        String name = stu.getName();
        String status = stu.getStatus();
        String section = stu.getSection();
        String sql = "insert into students.studentApi (id,name,section,status) values(/"+id+"/,/"+name+"/,/"+section+"/,/"+status+")";
        jdbc.execute(sql);
        return "Data Inserted";
    }

    // update
    public String update(student stu,String ide)
    {
        try {
            String sql = "update students.studentApi set id=/"+stu.getId()+"/,"+ "name=/"+stu.getName()+"/,section =/+"+stu.getSection()+"/, status =/"+stu.getStatus()+"/, where id = /"+ide+"/";
            jdbc.execute(sql);
            return "Data updated";
        }catch (Exception e)
        {
            return "not ";
        }
    }

    // delete
    public String delete(String id)
    {
        try {
            String sql = "DELETE from students.studentApi where id = /"+id+"/";
            jdbc.execute(sql);
            return "Data Deleted";
        }
        catch (Exception e)
        {
            return e.getMessage();
        }
    }

}
