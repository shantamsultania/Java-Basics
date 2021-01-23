package com.example.demo.joins.controller;

import com.example.demo.joins.models.TeacherDao;
import com.example.demo.joins.models.student;
import com.example.demo.joins.models.teacher;
import io.github.biezhi.anima.Anima;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class JoinController {

    JoinController()
    {

    }

    private TeacherDao teacherDao;


    // Student

    // Add Student (POST)
    @RequestMapping(method = RequestMethod.POST, value = "/students")
    public Integer addStudent(@RequestBody student stu) {
        try {
            Anima.save(new student(stu.getSName(), stu.getSSection()));
            log.info("Student added Successfully");
            return 200;
        } catch (Exception e) {

            log.error(e.getMessage());
            return 404;
        }


    }


    // Get Student (GET)
    @RequestMapping(method = RequestMethod.GET, value = "/students")
    public List<student> getAllStudents() {
        try {
            List<student> studentList = Anima.select().from(student.class).all();
            log.info("data received");
            return studentList;
        } catch (Exception e) {
            log.error("data was not received");
            return null;
        }
    }


    // Update Student (UPDATE)


    @RequestMapping(method = RequestMethod.PUT, value = "/students/{id}")
    public Integer updateStudents(@RequestBody student stu, @PathVariable int id) {
        try {

            Anima.update().from(student.class).set("sname", stu.getSName()).where("sid", id).execute();
            log.info("data Updated");
            return 200;
        } catch (Exception e) {
            log.error("data was not Updated " + e);
            return 404;
        }
    }


    // Delete Student (DELETE)

    @RequestMapping(method = RequestMethod.DELETE, value = "/students/{id}")
    public Integer deleteStudents(@PathVariable int id) {
        try {
            Anima.delete().from(student.class).where("sid", id).execute();
            log.info("data Deleted");
            return 200;
        } catch (Exception e) {
            log.error("data was not Deleted " + e);
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
            log.info("Teacher added Successfully");
            return 200;
        } catch (Exception e) {
            log.error(e.getMessage());
            return 404;
        }
    }


    // Get Teacher (GET)

    @RequestMapping(method = RequestMethod.GET, value = "/teacher")
    public List<teacher> getAllTeachers() {
        try {
            List<teacher> teacherList = Anima.select().from(teacher.class).all();
            log.info("data received");
            return teacherList;
        } catch (Exception e) {
            log.error(e.getMessage());
            return null;
        }
    }


    // Update Teacher (UPDATE)

    @RequestMapping(method = RequestMethod.PUT, value = "/teacher/{id}")
    public Integer updateTeachers(@RequestBody teacher teach, @PathVariable int id) {
        try {

            Anima.update().from(teacher.class).set("tname", teach.getTName()).where("tid", id).execute();
            log.info("data updated");
            return 200;
        } catch (Exception e) {
            log.error("data was not Updated " + e);
            return 404;
        }
    }

    // Delete Teacher (DELETE)
    @RequestMapping(method = RequestMethod.DELETE, value = "/teacher/{id}")
    public Integer deleteTeacher(@PathVariable int id) {
        try {
            Anima.delete().from(teacher.class).where("tid", id).execute();
            log.info("data deleted");
            return 200;
        } catch (Exception e) {
            log.error("data was not Deleted " + e);
            return 404;
        }
    }

    // Joins

    // Inner Join

    @RequestMapping(method = RequestMethod.GET, value = "/innerJoin/{id}")
    public teacher innerJoin(@PathVariable int id) {
        try {

            teacher teacherList = teacherDao.getTeacherBySection(id);
            log.info("data received");
            return teacherList;
        } catch (Exception e) {
            log.error("data was not received " + e.getMessage());

            return null;
        }
    }


    @RequestMapping(method = RequestMethod.GET, value = "/filterById/{id}")
    public teacher filterById(@PathVariable int id) {
        try {

            teacher teacher = teacherDao.getTeacherById(id);
            return teacher;
        } catch (Exception e) {
            log.error(e.getMessage());
            return null;
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "/filterBySidAndSName/{id}")
    public List<student> filterBySidAndSName(@PathVariable int id) {
        try {
            List<student> studentList = teacherDao.getStudentByIdAndName(id);
            return studentList;

        } catch (Exception e) {
            log.error(e.getMessage());
            return null;
        }
    }


}
