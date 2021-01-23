package com.example.animanew.school;

import com.example.animanew.school.model.Student;
import com.example.animanew.school.model.Teacher;
import io.github.biezhi.anima.Anima;
import io.github.biezhi.anima.core.Joins;

import java.util.List;

public class TeacherDao {

    TeacherDao()
    {

    }
    public Teacher getTeacherSectionById(int id) {
        // orderInfo = select().from(OrderInfo.class)
        //        .join(
        //            Joins.with(User.class).as(OrderInfo::getUser)
        //                 .on(OrderInfo::getUid, User::getId)
        //        ).byId(3);
        Teacher teacher;
        teacher = Anima.select().from(Teacher.class)
                .join(
                        Joins.with(Student.class).as(Teacher::getTName)
                                .on(Teacher::getTId,Student::getSId)
                ).byId(id);

        return teacher;
    }

    public Teacher getTeacherById(int id) {
        return Anima.select().from(Teacher.class).byId(id);
    }


    public List<Student> getStudentByIdAndName(int id,String name) {
        return Anima.select().from(Student.class).where("s_id=?", id).where("s_name",name).all();
    }


}
