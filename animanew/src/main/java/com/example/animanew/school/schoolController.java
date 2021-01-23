package com.example.animanew.school;

import com.example.animanew.school.model.Student;
import com.example.animanew.school.model.Teacher;
import io.github.biezhi.anima.Anima;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@Slf4j
public class schoolController {


    TeacherDao teacherDao;

    schoolController()
    {
        teacherDao = new TeacherDao();

    }
    // Student

    // Add Student (POST)
    @RequestMapping(method = RequestMethod.POST, value = "/students1")
    public ResponseEntity<Student> addStudent(@RequestBody Student stu) {
        try {
            Anima.save(new Student(stu.getSName(), stu.getSSection()));
            log.info("Student added Successfully");
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return new ResponseEntity<>(stu, HttpStatus.OK);
    }


    // Get Student (GET)
    @RequestMapping(method = RequestMethod.GET, value = "/students1")
    public ResponseEntity<List<Student>> getAllStudents() {
        List<Student> studentList = new ArrayList<>();

        try {
            studentList = Anima.select().from(Student.class).all();
            log.info("data received");

        } catch (Exception e) {
            log.error("data was not received");

        }
        return new ResponseEntity<>(studentList, HttpStatus.OK);

    }


    // Update Student (UPDATE)


    @RequestMapping(method = RequestMethod.PUT, value = "/students1/{id}")
    public ResponseEntity<Student> updateStudents(@RequestBody Student stu, @PathVariable int id) {
        try {

            Anima.update().from(Student.class).set("sname", stu.getSName()).where("sid", id).execute();
            log.info("data Updated");
        } catch (Exception e) {
            log.error("data was not Updated " + e);

        }

        return new ResponseEntity<>(stu, HttpStatus.OK);

    }


    // Delete Student (DELETE)

    @RequestMapping(method = RequestMethod.DELETE, value = "/students1/{id}")
    public ResponseEntity<String> deleteStudents(@PathVariable int id) {
        try {
            Anima.delete().from(Student.class).where("sid", id).execute();
            log.info("data Deleted");

        } catch (Exception e) {
            log.error("data was not Deleted " + e);
        }
        return new ResponseEntity<>("data Deleted ", HttpStatus.OK);

    }


    ////////
    ////////
    // Teachers
    ////////
    ////////


    // Add Teacher (POST)

    @RequestMapping(method = RequestMethod.POST, value = "/teacher")
    public ResponseEntity<Teacher> addTeacher(@RequestBody Teacher teacher) {
        try {
            Anima.save(teacher);
            log.info("Teacher added Successfully");
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return new ResponseEntity<>(teacher, HttpStatus.OK);


    }


    // Get Teacher (GET)

    @RequestMapping(method = RequestMethod.GET, value = "/teacher")
    public ResponseEntity<List<Teacher>> getAllTeachers() {
        List<Teacher> teacherList = new ArrayList<>();
        try {
            teacherList = Anima.select().from(Teacher.class).all();
            log.info("data received");
        } catch (Exception e) {
            log.error(e.getMessage());

        }
        return new ResponseEntity<>(teacherList, HttpStatus.OK);

    }


    // Update Teacher (UPDATE)

    @RequestMapping(method = RequestMethod.PUT, value = "/teacher/{id}")
    public ResponseEntity<Teacher> updateTeachers(@RequestBody Teacher teach, @PathVariable int id) {
        try {

            Anima.update().from(Teacher.class).set("tname", teach.getTName()).where("tid", id).execute();
            log.info("data updated");
        } catch (Exception e) {
            log.error("data was not Updated " + e);
        }
        return new ResponseEntity<>(teach, HttpStatus.OK);
    }

    // Delete Teacher (DELETE)
    @RequestMapping(method = RequestMethod.DELETE, value = "/teacher/{id}")
    public ResponseEntity<String> deleteTeacher(@PathVariable int id) {
        try {
            Anima.delete().from(Teacher.class).where("tid", id).execute();
            log.info("data deleted");
        } catch (Exception e) {
            log.error("data was not Deleted " + e);

        }
        return new ResponseEntity<>("Teacher Deleted", HttpStatus.OK);

    }

    // Joins

    // Inner Join

    @RequestMapping(method = RequestMethod.GET, value = "/innerJoin/{id}")
    public ResponseEntity<Teacher> innerJoin(@PathVariable int id) {

        Teacher teacher = new Teacher("null","null");
        try {

            teacher = teacherDao.getTeacherSectionById(id);
            log.info("data received");
        } catch (Exception e) {
            log.error("data was not received " + e.getMessage());
        }
        return new ResponseEntity<>(teacher, HttpStatus.OK);

    }


    @RequestMapping(method = RequestMethod.GET, value = "/filterById/{id}")
    public ResponseEntity<Teacher> filterById(@PathVariable int id) {
        Teacher teacher = new Teacher("null","null");
        try {

            teacher = teacherDao.getTeacherById(id);

        } catch (Exception e) {
            log.error(e.getMessage());

        }
        return new ResponseEntity<>(teacher,HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/filterBySidAndSName/{id}/{name}")
    public ResponseEntity<List<Student>> filterBySidAndSName(@PathVariable int id, String name) {

        List<Student> studentList = new ArrayList<>();

        try {
            studentList = teacherDao.getStudentByIdAndName(id,name);

        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return new ResponseEntity<>(studentList,HttpStatus.OK);
    }


}
