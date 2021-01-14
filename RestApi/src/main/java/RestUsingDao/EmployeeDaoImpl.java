package RestUsingDao;

import MVCApiDemo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

//import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import java.util.List;
@Repository
public class EmployeeDaoImpl implements EmployeeDao{

    private EntityManager entityManager;

    @Autowired
    public EmployeeDaoImpl(EntityManager entityManager)
    {
        this.entityManager = entityManager;
    }


    // get all transactions from the List
    @Override
    public List<EmployeeModel> getAllEmployees() {
        try {
            Query theQuery = (Query) entityManager.createQuery("from employee");
            List<EmployeeModel> employeeModelsList = theQuery.getResultList();
            return employeeModelsList;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public EmployeeModel getEmployeeById(String id) {
        try {
            EmployeeModel employeeModel = entityManager.find(EmployeeModel.class,id);
            return employeeModel;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public EmployeeModel addEmployee(EmployeeModel emp) {

        try {

            EmployeeModel employeeModel = entityManager.merge(emp);
            emp.setId(employeeModel.getId());
            return employeeModel;


        } catch (Exception e) {
            return null;
        }
    }
}
