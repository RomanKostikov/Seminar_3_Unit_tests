package classwork.task001;


import classwork.task001.controllers.CalculatorController;
import classwork.task001.models.CalculatorModel;
import classwork.task001.views.CalculatorView;

public class CalculatorApp {
    public static void main(String[] args) {
        CalculatorModel model = new CalculatorModel();
        CalculatorView view = new CalculatorView();
        CalculatorController controller = new CalculatorController(model, view);

        controller.run();
    }
}
