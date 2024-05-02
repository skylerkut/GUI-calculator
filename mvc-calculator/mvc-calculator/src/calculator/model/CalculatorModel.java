package calculator.model;

import java.util.ArrayList;
import java.util.Stack;

import calculator.observer.Observer;
import calculator.observer.Subject;

public class CalculatorModel implements Subject {
	private ArrayList<Observer> observers;

	private double memory;
	private static String expression;

	public CalculatorModel() {
		observers = new ArrayList<>();
		memory = 0;
		expression = "";
	}

	public static double evaluateExpression() {
        Stack<Double> values = new Stack<>();
        Stack<Character> operators = new Stack<>();

        StringBuilder currentNumber = new StringBuilder();

        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);

            if (Character.isDigit(c) || c == '.') {
                currentNumber.append(c);
            } else {
                if (currentNumber.length() > 0) {
                    values.push(Double.parseDouble(currentNumber.toString()));
                    currentNumber = new StringBuilder();
                }

                if (c == '(') {
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
        }

        if (currentNumber.length() > 0) {
            values.push(Double.parseDouble(currentNumber.toString()));
        }

        while (!operators.empty()) {
        	Character currOperator = operators.peek();
			if(currOperator == '√' || currOperator == '²') {
				values.push(applyOperator(values.pop(), operators.pop()));
			}
			else
            values.push(applyOperator(values.pop(), values.pop(), operators.pop()));
        }
        
        // Final check for parenthesis multiplcation cases 
        double result = values.pop();
        while (!values.empty()) {
            result *= values.pop();
        }

        return result;
    }


	// Helper Methods for evaluateExpression()
	private static boolean isOperator(char c) {
		return c == '+' || c == '-' || c == '*' || c == '/' || c == '²' || c == '√';
	}

	private static int precedence(char operator) {
		if (operator == '+' || operator == '-')
			return 1;
		else if (operator == '*' || operator == '/')
			return 2;
		else if (operator == '²' || operator == '√')
			return 3;
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
		case '√':
			return Math.sqrt(num1);
		case '²':
			return Math.pow(num1, 2);
		default:
			return 0;
		}
	}
	
	private static double applyOperator(double num1, char operator) {
		switch (operator) {
		case '√':
			return Math.sqrt(num1);
		case '²':
			return Math.pow(num1, 2);
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
		CalculatorModel.expression = expression;
		notifyObservers();
	}

	public void addMemory(double value) {
		memory += value;
	}

	public void subMemory(double value) {
		memory -= value;
	}

	public double recallMemory() {
		return memory;
	}

	public void clearMemory() {
		memory = 0;
	}

	/*
	 * Observer API functions
	 */
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
