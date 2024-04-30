package calculator.model;

import java.util.ArrayList;
import java.util.Stack;

import calculator.observer.Observer;
import calculator.observer.Subject;

public class CalculatorModel implements Subject {
	private ArrayList<Observer> observers;

	private double number;
	private double previousNumber;
	private String currentTypeOfOperation;
	private double memory;
	private static String expression;

	public CalculatorModel() {
		observers = new ArrayList<>();
		number = 0;
		previousNumber = 0;
		currentTypeOfOperation = "";
		memory = 0;
		expression = "";
	}

	public static double evaluateExpression() {
		Stack<Double> values = new Stack<>();
		Stack<Character> operators = new Stack<>();

		for (int i = 0; i < expression.length(); i++) {
			char c = expression.charAt(i);

			if (Character.isDigit(c)) {
				StringBuilder sb = new StringBuilder();
				sb.append(c);
				while (i + 1 < expression.length() && Character.isDigit(expression.charAt(i + 1))) {
					sb.append(expression.charAt(++i));
				}
				values.push(Double.parseDouble(sb.toString()));
			} else if (c == '(') {
				operators.push(c);
			} else if (c == ')') {
				while (operators.peek() != '(') {
					values.push(applyOperator(values.pop(), values.pop(), operators.pop()));
				}
				operators.pop(); // Discard the '('
			} else if (isOperator(c)) {
				while (!operators.empty() && precedence(operators.peek()) >= precedence(c)) {
					values.push(applyOperator(values.pop(), values.pop(), operators.pop()));
				}
				operators.push(c);
			}
		}

		while (!operators.empty()) {
			values.push(applyOperator(values.pop(), values.pop(), operators.pop()));
		}

		return values.pop();
	}

	// Helper Methods for evaluateExpression()
	private static boolean isOperator(char c) {
		return c == '+' || c == '-' || c == '*' || c == '/';
	}

	private static int precedence(char operator) {
		if (operator == '+' || operator == '-')
			return 1;
		else if (operator == '*' || operator == '/')
			return 2;
		else
			return 0;
	}

	private static double applyOperator(double num1, double num2, char operator) {
		switch (operator) {
		case '+':
			return num1 + num2;
		case '-':
			return num2 - num1;
		case '*':
			return num1 * num2;
		case '/':
			if (num2 == 0)
				throw new ArithmeticException("Division by zero");
			else
			return num2 / num1;
		default:
			return 0;
		}
	}

	public String addToExpression(String buttonText) {
		String addOn = "";
		addOn = this.getExpression() + buttonText;
		this.setExpression(addOn);
		return addOn;
	}

	public String getExpression() {
		return expression;
	}

	public void setExpression(String expression) {
		this.expression = expression;
	}

	public double getNumber() {
		return number;
	}

	public void setNumber(double number) {
		this.number = number;
		notifyObservers();
	}

	public String getCurrentTypeOfOperation() {
		return currentTypeOfOperation;
	}

	public void setCurrentTypeOfOperation(String currentTypeOfOperation) {
		this.currentTypeOfOperation = currentTypeOfOperation;
	}

	public double getPreviousNumber() {
		return previousNumber;
	}

	public void setPreviousNumber(double previousNumber) {
		this.previousNumber = previousNumber;
	}

	public void addToMemory(double value) {
		memory += value;
	}

	public void subtractFromMemory(double value) {
		memory -= value;
	}

	public double recallMemory() {
		return memory;
	}

	public void clearMemory() {
		memory = 0;
	}

	@Override
	public void registerObserver(Observer o) {
		observers.add(o);
	}

	@Override
	public void unregisterObserver(Observer o) {
		observers.remove(o);
	}

	@Override
	public void notifyObservers() {
		this.observers.forEach(Observer::update);
	}
}
