import java.util.ArrayList;
import java.util.List;

public class studentDaoImpl implements studentDao{

    List<student> studentList;

    studentDaoImpl()
    {
        studentList = new ArrayList<student>();
        studentList.add(new student("100","student 1 ","cse1"));
        studentList.add(new student("101","student 2 ","cse2"));
        studentList.add(new student("102","student 3 ","cse3"));
    }

    @Override
    public List<student> getAllStudents() {
        return studentList;
    }

    @Override
    public student getStudent(String id) {

        for (student stu : studentList)
        {
            if (stu.getId().equals(id))
            {
                return stu;
            }
        }

        return new student("404","no user with that id","found");

    }

    @Override
    public void updateStudent(student stu) {
        int i=0;
        for (student stud : studentList)
        {
            if (stud.getId().equals(stu.getId()))
            {
                studentList.set(i,stu);
                return;
            }
            else
            {
                i++;
            }
        }
        if (i == studentList.size())
        {
            System.out.println("not student with present ");
        }
    }

    @Override
    public void deleteStudent(student stu) {
        int i=0;
        for (student stud : studentList)
        {
            if (stud.getId().equals(stu.getId()))
            {
                studentList.remove(i);
                return;
            }
            else
            {
                i++;
            }
        }
        if (i == studentList.size())
        {
            System.out.println("not student with present ");
        }
    }

    @Override
    public void addStudent(student stu) {
        studentList.add(stu);
    }
}
