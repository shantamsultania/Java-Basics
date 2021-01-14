package RestUsingDao;

import java.util.List;

public interface EmployeeDao {

    public List<EmployeeModel> getAllEmployees();

    public EmployeeModel getEmployeeById(String id);

    public EmployeeModel addEmployee(EmployeeModel emp);
//
//    public void updateEmployee(EmployeeModel emp);
//
//    public void deleteEmployee(String id);
}
