package MVCApiDemo;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MVCrestApiController {

    static EmployeeModel database()
    {
        List<Employee> modelList = new ArrayList<Employee>();

        modelList.add(new Employee("100","user1"));
        modelList.add(new Employee("101","user2"));
        modelList.add(new Employee("102","user3"));

        EmployeeModel model= new EmployeeModel();
        model.setModelList(modelList);
        return model;
    }

    EmployeeModel employeeModel = database();
    employeeViewModel employeeViewModel = new employeeViewModel();
    employeeModelController employeeModelController = new employeeModelController(employeeModel,employeeViewModel);

    @RequestMapping("/connectionMVC")
    public void displayModel()
    {
        employeeModelController.Display();
    }

    // GET
    // GET ALL
    @RequestMapping("/mvc")
    public List<Employee> getAllEmployees()
    {
        return employeeModelController.getModelList();
    }

    // GET
    // GET ONE
    // todo

    // POST
    // Add employee

    @RequestMapping(method = RequestMethod.POST,value = "/mvc")
    public void addEmployee(@RequestBody Employee emp)
    {
        employeeModelController.add(emp);
    }

    // PUT
    // Update

    @RequestMapping(method = RequestMethod.PUT,value = "/mvc")
    public void update(@RequestBody Employee emp)
    {
        employeeModelController.update(emp);
    }

    // DELETE
    // DELETE A EMPLOYEE on based of ID

    @RequestMapping(method = RequestMethod.DELETE,value = "/mvc/{id}")
    public void delete(@PathVariable String id)
    {
        employeeModelController.delete(id);
    }






}
