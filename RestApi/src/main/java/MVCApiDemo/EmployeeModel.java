package MVCApiDemo;

import java.util.List;

public class EmployeeModel {

    private List<Employee> employeeList ;

    EmployeeModel()
    {

    }

    public List<Employee> getModelList() {
        return employeeList;
    }

    public void setModelList(List<Employee> modelList) {
        this.employeeList = modelList;
    }


}
