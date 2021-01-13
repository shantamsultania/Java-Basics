import java.util.List;

public class mainClass {

    public static void main(String[] args) {

        studentDao studentDao = new studentDaoImpl();
        System.out.println();
        // create or insert
        System.out.println("Insert:");
        studentDao.addStudent(new student("103","student 4","cse4"));
        printOne(studentDao.getStudent("103"));

        // print all
        System.out.println("Read:");
         printAll(studentDao.getAllStudents());

        // update
        System.out.println("Update:");
        student newstudent = new student("100","shan tam","cse5");
        studentDao.updateStudent(newstudent);

        // get one
        printOne(studentDao.getStudent("100"));

        // delete
        System.out.println("Delete:");
        studentDao.deleteStudent(newstudent);
        printAll(studentDao.getAllStudents());
    }

    static  void printAll(List<student> studentList)
    {
        for (student stu : studentList)
        {
            System.out.println(stu.getId()+" : "+stu.getName()+" : "+stu.getSection()+" ;");
        }
        System.out.println();
    }

    static void printOne(student stu)
    {
        System.out.println(stu.getId()+" : "+stu.getName()+" : "+stu.getSection()+" ;");
        System.out.println();
    }
}
