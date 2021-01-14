package RestUsingDao;

import java.util.List;

public interface EmployeeService {

    public List<EmployeeModel> findAllEmployees();

    public EmployeeModel findEmployeeById(String id);

    public EmployeeModel addEmployee(EmployeeModel emp);
//
//    public void updateEmployee(EmployeeModel emp);
//
//    public void deleteEmployee(String id);


}
