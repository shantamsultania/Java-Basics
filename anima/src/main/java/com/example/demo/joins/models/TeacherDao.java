package com.example.demo.joins.models;

import io.github.biezhi.anima.Anima;
import io.github.biezhi.anima.core.Joins;

import java.util.Collections;
import java.util.List;

public class TeacherDao {

    public List<teacher> getTeacherBySection(int id) {
        List<teacher> teacherList;
        teacherList = Collections.singletonList(Anima.select().from(teacher.class)
                .join(
                        Joins.with(student.class).as(teacher::getTSection)
                                .on(teacher::getTSection, student::getSSection)
                ).byId(id));
        return teacherList;
    }

    public teacher getTeacherById(int id) {
        return Anima.select().from(teacher.class).byId(id);
    }

    public student getStudentById(int id) {
        return Anima.select().from(student.class).byId(id);
    }

    public List<student> getStudentByIdAndName(int id) {
        return Anima.select().from(student.class).where("sid=?", id).where("sName", "demo1").all();
    }
}
