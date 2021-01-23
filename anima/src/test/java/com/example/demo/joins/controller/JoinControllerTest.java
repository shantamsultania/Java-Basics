package com.example.demo.joins.controller;

import com.example.demo.BaseTest;
import com.example.demo.joins.models.TeacherDao;
import com.example.demo.joins.models.student;
import com.example.demo.joins.models.teacher;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class JoinControllerTest extends BaseTest {

    private  JoinController joinController;
    // Student
    @Test
    public void addStudent()
    {
        mysql();
        List<student> studentList = new ArrayList<student>(Arrays.asList(
                new student("demo1","cse1"),
                new student("demo2","cse2"),
                new student("demo3","cse3"),
                new student("demo1","cse5"),
                new student("demo4","cse4")));
//        Anima.saveBatch(studentList);
            for (student stu : studentList)
            {
                joinController.addStudent(stu);
            }
    }
    @Test
    public void GetStudents()
    {
        mysql();
        assertNotNull(joinController.getAllStudents(),"null value received");

        List<student> studentList = joinController.getAllStudents();
        for (student stu : studentList)
        {
            System.out.println(stu.getSId()+" : "+stu.getSName()+" : "+stu.getSSection());
        }
    }
    @Test
    public void UpdateStudent()
    {
        mysql();
        assertEquals(200,joinController.updateStudents(new student("updated","cse2"),2));
    }
    @Test
    public void DeleteStudent()
    {
        mysql();
        assertEquals(200,joinController.deleteStudents(2));
    }

    // Teacher

    @Test
    public void addTeacher()
    {
        mysql();

        List<teacher> teacherList = new ArrayList<>(
          Arrays.asList(
                  new teacher("teacher1","cse1"),
                  new teacher("teacher2","cse2"),
                  new teacher("teacher3","cse3"))
        );
        for (teacher te : teacherList)
        {
            joinController.addTeacher(te);
        }
    }
    @Test
    public void GetTeachers()
    {
        mysql();

        assertNotNull(joinController.getAllTeachers(),"null value received ");
        List<teacher> teacherList = joinController.getAllTeachers();
        for (teacher teacher : teacherList)
        {
            System.out.println(teacher.getTId()+" : "+teacher.getTName()+" : "+teacher.getTSection());
        }
    }

    @Test
    public void UpdateTeacher()
    {
        mysql();
        assertEquals(200,joinController.updateTeachers(new teacher("updated teacher","cse2"),2));
    }

    @Test
    public void DeleteTeacher()
    {
        mysql();
        assertEquals(200,joinController.deleteStudents(2));
    }


    // Joins

    @Test
    public void innerJoin()
    {
        mysql();
        assertNotNull(joinController.innerJoin(100),"please enter a valid id ");
        teacher teacher = joinController.innerJoin(101);
        System.out.println();
            System.out.println(teacher.getTId()+" : "+teacher.getTName()+" : "+teacher.getTSection());

    }

    @Test
    public void filterById()
    {
        mysql();
        assertNotNull(joinController.filterById(100),"please enter a valid id ");
        teacher teacher = joinController.filterById(100);
        System.out.println(teacher.getTId()+" : "+teacher.getTName()+" : "+teacher.getTSection());

    }

    @Test
    public void filterBySidAndSName()
    {
        mysql();

        assertNotNull(joinController.filterBySidAndSName(100),"please enter a valid id ");
       List<student> studentList =  joinController.filterBySidAndSName(102);

       for (student stu : studentList)
       {
           System.out.println(stu.getSId()+" : "+stu.getSName()+" : "+stu.getSSection());
       }
    }

}