import java.util.List;

public interface studentDao {
    
        public List<student> getAllStudents();
        public student getStudent(String id);
        public void updateStudent(student stu);
        public void deleteStudent(student stu);
        public void addStudent(student stu);

}
