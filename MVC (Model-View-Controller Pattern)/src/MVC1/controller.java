package MVC1;

public class controller {

    model model;
    view view;

    public controller(model model, view view) {
        this.model = model;
        this.view = view;
    }

    public String getId() {
        return model.getId();
    }

    public void setId(String id) {
        model.setId(id);
    }

    public String getName() {
        return model.getName();
    }

    public void setName(String name) {
        model.setName(name);
    }


    public void getViewData()
    {
        view.viewData(model.getId(),model.getName());
    }

}
