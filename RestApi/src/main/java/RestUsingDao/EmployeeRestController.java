package RestUsingDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeRestController {

    private EmployeeService employeeService;


    @Autowired
    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @RequestMapping(value = "/emp",method = RequestMethod.GET)
    public ResponseEntity<List<EmployeeModel>> getAll()
    {
        System.out.println(employeeService.findAllEmployees().size());
        return new ResponseEntity<List<EmployeeModel>>(employeeService.findAllEmployees(), HttpStatus.OK);
    }

    @RequestMapping(value = "/emp", method = RequestMethod.POST)
    public EmployeeModel addTransaction(@RequestBody EmployeeModel theTransaction){

        return (employeeService.addEmployee(theTransaction));
    }

}
