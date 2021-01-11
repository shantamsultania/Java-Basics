package StudentApi;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class studentservice {

    private studenthandller studenthandller = new studenthandller();

    // connection check
    @RequestMapping("/connect")
    public String checkConnection()
    {
        return "connection Successful";
    }

    // GET (GET ALL)
    @RequestMapping("/studentapi")
    public List<student> getall()
    {
       return studenthandller.getStudentList();
    }

    // GET (GET ONE)
    @RequestMapping("/studentapi/{id}")
    public student getStudent(@PathVariable String id)
    {
        return studenthandller.getStudent(id);
    }

    // POST (ADD ONE)
    @RequestMapping(method = RequestMethod.POST,value = "/studentapi")
    public void add(@RequestBody student stu)
    {
        studenthandller.addStudent(stu);
    }

    // UPDATE (UPDATE STUDENT ON BASED OF ID )
    @RequestMapping(method = RequestMethod.PUT,value = "/studentapi/{id}")
    public void update(@RequestBody student student,@PathVariable String id)
    {
        studenthandller.updateStudent(student,id);
    }

    // DELETE (DELETE STUDENT ON BASED OF ID )
    @RequestMapping(method =  RequestMethod.DELETE,value = "/studentapi/{id}")
    public void delete(@PathVariable String id)
    {
        studenthandller.deleteStudent(id);
    }

}
