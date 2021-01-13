package MVCApiDemo;

import java.util.List;

public class employeeViewModel {

    public void printModelData(List<Employee> employeeList)
    {
        System.out.println();
        for (Employee employee : employeeList)
        {
            System.out.println(employee.getId()+"  : "+employee.getName());
        }
        System.out.println("_______________________________");
        System.out.println();
    }

}
