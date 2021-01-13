package MVC2;

import java.util.List;

public class ModelController {

    Model model;
    ViewModel viewModel;

    public ModelController(Model model,ViewModel viewModel) {
        this.model = model;
        this.viewModel = viewModel;
    }

    public void setModelList(List<Type> modelList)
    {
        model.setModelList(modelList);
    }

    public List<Type>  getModelList()
    {
        return model.getModelList();
    }

    public void Display()
    {
        viewModel.printModelData(model.getModelList());
    }




}
