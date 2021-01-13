package MVCApiDemo;

import java.util.List;

public class employeeModelController {

    EmployeeModel employeeModel;
    employeeViewModel employeeViewModel;

    public employeeModelController(EmployeeModel employeeModel, MVCApiDemo.employeeViewModel employeeViewModel) {
        this.employeeModel = employeeModel;
        this.employeeViewModel = employeeViewModel;
    }


    public void setModelList(List<Employee> employeeList)
    {
        employeeModel.setModelList(employeeList);
    }

    public List<Employee>  getModelList()
    {

        return employeeModel.getModelList();
    }

    public void add(Employee employee)
    {
        List<Employee> employeeList = getModelList();
        employeeList.add(employee);
        setModelList(employeeList);
    }

    public void update(Employee emp)
    {
        List<Employee> employeeList = getModelList();
        int i=0;
        for (Employee employee : employeeList)
        {
            if (employee.getId().equals(emp.getId()))
            {
                employeeList.set(i,emp);
                setModelList(employeeList);
            }
            else
            {
                i++;
            }
        }
    }

    public void delete(String id)
    {
        List<Employee> employeeList = getModelList();
        int i=0;
        for (Employee employee : employeeList)
        {
            if (employee.getId().equals(id))
            {
                employeeList.remove(i);
                setModelList(employeeList);
            }
            else
            {
                i++;
            }
        }
    }


    public void Display()
    {
        employeeViewModel.printModelData(employeeModel.getModelList());
    }





}

