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

    public CalculatorController (CalculatorView view, CalculatorModel model) {
        this.view = view;
        this.model = model;

        this.view.addCalculationListener(new CalculateListener());
        this.view.addOperationListener(new EqualsListener());
        this.model.registerObserver(this);
    }

    private class CalculateListener implements ActionListener {
    	@Override
        public void actionPerformed (ActionEvent e) {
            String numberUserPressed = ((JButton)e.getSource()).getText();
            model.addToExpression(numberUserPressed);
            
            //Move current number up
            String moveNum = view.getResult();
            view.addToCurrExpression(moveNum);
            //Display button pressed
            view.setResult(numberUserPressed);           
        }
    }

    //Change to equals listener to end the string?
    private class EqualsListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String operationPressed = ((JButton)e.getSource()).getText();

            if (Objects.equals(operationPressed, "=")) {
               double result = model.evaluateExpression();
               
            } else {
                model.setCurrentTypeOfOperation(operationPressed);
                model.setPreviousNumber(model.getNumber());
                model.setNumber(0);
            }
        }
    }

    @Override
    public void update() {
    }
}
