package com.example.demo.joins.controller;

import com.example.demo.joins.models.TeacherDao;
import com.example.demo.joins.models.student;
import com.example.demo.joins.models.teacher;
import io.github.biezhi.anima.Anima;
import io.github.biezhi.anima.core.Joins;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class JoinController {

    Logger slf4jLogger = LoggerFactory.getLogger(JoinController.class);


    private  TeacherDao teacherDao = new TeacherDao();


    // Student

    // Add Student (POST)
    @RequestMapping(method = RequestMethod.POST,value = "/students")
    public Integer addStudent(@RequestBody student stu)
    {
        try {
            Anima.save(new student(stu.getSName(),stu.getSSection()));
            slf4jLogger.info("Student added Successfully");
            return 200;
        }catch (Exception e)
        {
            slf4jLogger.error(e.getMessage());
            return 404;
        }


    }


    // Get Student (GET)
    @RequestMapping(method = RequestMethod.GET, value = "/students")
    public List<student> getAllStudents() {
        try{
            List<student> studentList = Anima.select().from(student.class).all();
            return studentList;
        }catch (Exception e)
        {
            slf4jLogger.error("data was not received");
            return null;
        }
    }


    // Update Student (UPDATE)


    @RequestMapping(method = RequestMethod.PUT, value = "/students/{id}")
    public Integer updateStudents(@RequestBody student stu, @PathVariable int id) {
        try {

            Anima.update().from(student.class).set("sname", stu.getSName()).where("sid", id).execute();
            return 200;
        }catch (Exception e)
        {
           slf4jLogger.error("data was not Updated "+e);
            return 404;
        }
    }


    // Delete Student (DELETE)

    @RequestMapping(method = RequestMethod.DELETE, value = "/students/{id}")
    public Integer deleteStudents(@PathVariable int id) {
        try {
            Anima.delete().from(student.class).where("sid", id).execute();
            return 200;
        }catch (Exception e)
        {
           slf4jLogger.error("data was not Deleted "+e);
            return 404;
        }
    }



    ////////
    ////////
    // Teachers
    ////////
    ////////



    // Add Teacher (POST)

    @RequestMapping(method = RequestMethod.POST, value = "/teacher")
    public Integer addTeacher(@RequestBody teacher teacher) {
        try {
            Anima.save(teacher);
            slf4jLogger.info("Student added Successfully");
            return 200;
        }catch (Exception e)
        {
            slf4jLogger.error(e.getMessage());
            return 404;
        }
    }



    // Get Teacher (GET)

    @RequestMapping(method = RequestMethod.GET, value = "/teacher")
    public List<teacher> getAllTeachers() {
        try {
            List<teacher> teacherList = Anima.select().from(teacher.class).all();
            return teacherList;
        }catch (Exception e)
        {
            slf4jLogger.error(e.getMessage());
            return null;
        }
    }



    // Update Teacher (UPDATE)

    @RequestMapping(method = RequestMethod.PUT, value = "/teacher/{id}")
    public Integer updateTeachers(@RequestBody teacher teach , @PathVariable int id) {
        try {

            Anima.update().from(teacher.class).set("tname", teach.getTName()).where("tid", id).execute();
            return 200;
        }catch (Exception e)
        {
            slf4jLogger.error("data was not Updated "+e);
            return 404;
        }
    }

    // Delete Teacher (DELETE)
    @RequestMapping(method = RequestMethod.DELETE, value = "/teacher/{id}")
    public Integer deleteTeacher(@PathVariable int id) {
        try {
            Anima.delete().from(teacher.class).where("tid", id).execute();
            return 200;
        }catch (Exception e)
        {
            slf4jLogger.error("data was not Deleted "+e);
            return 404;
        }
    }

    // Joins

    // Inner Join

    @RequestMapping(method = RequestMethod.GET , value = "/innerJoin")
    public List<teacher> innerJoin(@PathVariable int id) {
        try
        {

            List<teacher> teacherList = teacherDao.getTeacherBySection(id);
            return teacherList;
        }
        catch (Exception e)
        {
            return null;
        }
    }


    @RequestMapping(method = RequestMethod.GET, value = "/filterById/{id}")
    public teacher filterById(@PathVariable int id) {
        try {

            teacher teacher = teacherDao.getTeacherById(id);
            return teacher;
        }catch (Exception e)
        {
            slf4jLogger.error(e.getMessage());
            return null;
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "/filterBySidAndSName/{id}")
    public List<student> filterBySidAndSName(@PathVariable int id) {
        try {
            List<student> studentList = teacherDao.getStudentByIdAndName(id);
            return studentList;

        }catch (Exception e)
        {
            slf4jLogger.error(e.getMessage());
            return null;
        }
    }




}
