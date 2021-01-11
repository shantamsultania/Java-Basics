package StudentApi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class studenthandller {

    List<student> studentList = new ArrayList<student>(Arrays.asList(
       new student("100","shantam"),
       new student("101","Shubham")
    ));

    public List<student> getStudentList()
    {
        return studentList;
    }


    public void addStudent(student stu)
    {
        studentList.add(stu);
    }

    public student getStudent(String id)
    {
        for (student student : studentList)
        {
            if (student.getId().equals(id))
            {
                return student;
            }
        }
        return new student("404","no student found with that id");
    }


    public void updateStudent(student stu,String id)
    {
        int i=0;
        for (student student : studentList)
        {
            if (student.getId().equals(id))
            {
               studentList.set(i,stu);
               return;
            }
            i++;
        }
        studentList.set(i-1,stu);

    }

    public void deleteStudent(String id)
    {

        for (student student : studentList)
        {
            if (student.getId().equals(id))
            {
                studentList.remove(student);
                return;
            }
        }
    }

}
