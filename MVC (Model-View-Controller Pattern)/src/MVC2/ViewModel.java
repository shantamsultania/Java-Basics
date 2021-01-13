package MVC2;

import java.util.List;

public class ViewModel {

    public void printModelData(List<Type> modeList)
    {
        for (Type type : modeList)
        {
            System.out.println(type.getId()+"  : "+type.getName());
        }
        System.out.println("_______________________________");
        System.out.println();
    }
}
