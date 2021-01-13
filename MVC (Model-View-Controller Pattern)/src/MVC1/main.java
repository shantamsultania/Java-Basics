package MVC1;

public class main {

    public static void main(String[] args) {

        model model = database();

        view view = new view();

        controller controller = new controller(model,view);

        // get MVC1.view from database
        controller.getViewData();


        // set or update  MVC1.model data
        controller.setName("user zero");

        controller.getViewData();


    }
    static model database()
    {
        model model = new model();
        model.setId("100");
        model.setName("user 100");
        return model;
    }

}
