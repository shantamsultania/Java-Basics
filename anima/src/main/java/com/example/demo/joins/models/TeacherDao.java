package com.example.demo.joins.models;

import io.github.biezhi.anima.Anima;
import io.github.biezhi.anima.core.Joins;
import java.util.List;

public class TeacherDao {

    TeacherDao()
    {

    }

    public teacher getTeacherBySection(int id) {
        // orderInfo = select().from(OrderInfo.class)
        //        .join(
        //            Joins.with(User.class).as(OrderInfo::getUser)
        //                 .on(OrderInfo::getUid, User::getId)
        //        ).byId(3);
        teacher teacherList;
        teacherList = Anima.select().from(teacher.class)
                .join(
                        Joins.with(student.class).as(teacher::getTName)
                        .on(teacher::getTId,student::getSId)
                ).byId(id);

        return teacherList;
    }

    public teacher getTeacherById(int id) {
        return Anima.select().from(teacher.class).byId(id);
    }


    public List<student> getStudentByIdAndName(int id) {
        return Anima.select().from(student.class).where("sid=?", id).where("sName", "demo1").all();
    }
}
