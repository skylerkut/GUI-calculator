package calculator.controller;

import javax.swing.*;

import calculator.model.CalculatorModel;
import calculator.observer.Observer;
import calculator.view.CalculatorView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class CalculatorController implements Observer {
	private final CalculatorView view;
	private final CalculatorModel model;

	public CalculatorController(CalculatorView view, CalculatorModel model) {
		this.view = view;
		this.model = model;

		this.view.addCalculationListener(new CalculateListener());
		this.view.addOperationListener(new EqualsListener());
		this.model.registerObserver(this);
	}

	private class CalculateListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String numberUserPressed = ((JButton) e.getSource()).getText();

			// Add user input to string
			model.addToExpression(numberUserPressed);
			// Display button pressed
			view.setResult(model.getExpression());
		}
	}

	// Change to equals listener to end the string?
	private class EqualsListener implements ActionListener {
		@Override
        public void actionPerformed(ActionEvent e) {
            String operationPressed = ((JButton)e.getSource()).getText();

            //
            switch(operationPressed) {
            	case "=":
            		double resultNum = model.evaluateExpression();
            		String result = "" + resultNum;
               
            		//Move current expression up to previous expressions display
            		view.setCurrentExpressionTxt(model.getExpression() + "= ");
            		//Display equation result
            		view.setResult(result);  
            		//TODO: handle if previous input was an equal or another operation
               		break;
            	case "C":
            		view.setResult("");
            		view.setCurrentExpressionTxt("");
            		break;

 
            	default: break;
            }
        }
	}

	@Override
	public void update() {
	}
}
