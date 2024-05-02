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

	private class EqualsListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String operationPressed = ((JButton) e.getSource()).getText();

			switch (operationPressed) {
			case "=":
				double resultNum = model.evaluateExpression();
				String result = "" + resultNum;
				// Move current expression up to previous expressions display
				view.setCurrentExpressionTxt(model.getExpression() + "= ");
				// Display equation result
				view.setResult(result);
				break;
			case "C":
				view.setResult("");
				view.setCurrentExpressionTxt("");
				model.setExpression("");
				break;
			case "M+":
				String isOutput = view.getCurrentExpressionTxt();
				if(!isOutput.contains("=")) {
					view.setResult("Invalid");
				}
				String mem = view.getResult();
				if (!mem.contains("+") && !mem.contains("-") && !mem.contains("*") && !mem.contains("/")
						&& !mem.contains("²") && !mem.contains("√")) {
					try {
						double number = Double.parseDouble(mem);
						if (number < 0)
							view.setResult("Invalid");
						else
							model.addMemory(number);
					} catch (NumberFormatException e1) {
						view.setResult("Invalid");
					}
				}
				break;
			case "M-":
				isOutput = view.getCurrentExpressionTxt();
				if(!isOutput.contains("=")) {
					view.setResult("Invalid");
				}
				String memSub = view.getResult();
				if (!memSub.contains("+") && !memSub.contains("-") && !memSub.contains("*") && !memSub.contains("/")
						&& !memSub.contains("²") && !memSub.contains("√")) {
					try {
						double number = Double.parseDouble(memSub);
						if (number < 0)
							view.setResult("Invalid");
						else
							model.subMemory(number);
					} catch (NumberFormatException e1) {
						view.setResult("Invalid");
					}
				}
			case "MR":
				Double memRecall = model.recallMemory();
				String currInputs = view.getResult();
				view.setResult("" + currInputs + memRecall);
				break;
			case "MC": 
				model.clearMemory();
			default:
				break;
			}
		}
	}

	@Override
	public void update() {
	}
}
