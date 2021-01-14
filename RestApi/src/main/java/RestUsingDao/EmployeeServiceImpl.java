package RestUsingDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.transaction.Transactional;
import java.util.List;

public class EmployeeServiceImpl implements EmployeeService{

    EmployeeDao employeeDao;

    @Autowired
    public EmployeeServiceImpl(@Qualifier("EmployeeDaoImpl") EmployeeDao employeeDao)
    {
        this.employeeDao = employeeDao;
    }

    @Override
    @Transactional
    public List<EmployeeModel> findAllEmployees() {
        return employeeDao.getAllEmployees();
    }

    @Override
    @Transactional
    public EmployeeModel findEmployeeById(String id) {
        return employeeDao.getEmployeeById(id);
    }

    @Override
    @Transactional
    public EmployeeModel addEmployee(EmployeeModel emp) {
        return employeeDao.addEmployee(emp);
    }
}
