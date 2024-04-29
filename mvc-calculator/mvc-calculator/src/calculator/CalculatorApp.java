package calculator;

import calculator.controller.CalculatorController;
import calculator.model.CalculatorModel;
import calculator.view.CalculatorView;

public class CalculatorApp {
    public static void main(String[] args) {
    	
    	//Instantiate calculator mvc modules
        CalculatorView view = new CalculatorView();
        CalculatorModel model = new CalculatorModel();
        CalculatorController controller = new CalculatorController(view, model);
        
        controller.update();
    }
}
