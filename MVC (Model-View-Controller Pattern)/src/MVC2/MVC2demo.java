package MVC2;

import javax.swing.text.View;
import java.util.ArrayList;
import java.util.List;

public class MVC2demo {

    static Model database()
    {
        List<Type> modelList = new ArrayList<Type>();

        modelList.add(new Type("100","user1"));
        modelList.add(new Type("101","user2"));
        modelList.add(new Type("102","user3"));

        Model model= new Model();
        model.setModelList(modelList);
        return model;
    }

    static List<Type> databaseModelList()
    {
        List<Type> modelList = new ArrayList<Type>();

        modelList.add(new Type("10","user10"));
        modelList.add(new Type("11","user11"));
        modelList.add(new Type("12","user12"));
        return modelList;
    }

    public static void main(String[] args) {

        Model model = database();

        ViewModel viewModel = new ViewModel();

        ModelController modelController = new ModelController(model,viewModel);

        modelController.Display();

        // set model
        modelController.setModelList(databaseModelList());

        modelController.Display();

    }


}
