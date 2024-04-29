package calculator.model;

import java.util.ArrayList;

import calculator.observer.Observer;
import calculator.observer.Subject;

public class CalculatorModel implements Subject {
    private ArrayList<Observer> observers;

    private double number;
    private double previousNumber;
    private String currentTypeOfOperation;
    private double memory;

    public CalculatorModel () {
        observers = new ArrayList<>();
        number = 0;
        previousNumber = 0;
        currentTypeOfOperation = "";
        memory = 0;
    }

    public void addDigit (float digit) {
        setNumber((getNumber() * 10) + digit);
    }

    public Double makeOperation () {
        Double result = 0.0;
        switch (this.currentTypeOfOperation) {
            case "+":
                result = this.getPreviousNumber() + this.getNumber();
                break;
            case "-":
                result = this.getPreviousNumber() - this.getNumber();
                break;
            case "x":
                result = this.getPreviousNumber() * this.getNumber();
                break;
            case "/":
                if (this.getNumber() == 0) {
                    throw new ArithmeticException("Division by zero");
                }else {
                result = this.getPreviousNumber() / this.getNumber();}
                break;
            case "x²":
                result = Math.pow(this.getNumber(), 2);
                break;
            case "√":
            	if (this.getNumber() < 0) {
                    throw new ArithmeticException("Square root of negative number");
                }else {
                result = Math.sqrt(this.getNumber());}
                break;
        }
        return result;
    }

    public double getNumber () {
        return number;
    }

    public void setNumber (double number) {
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
    public void registerObserver (Observer o) {
        observers.add(o);
    }

    @Override
    public void unregisterObserver (Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        this.observers.forEach(Observer::update);
    }
}
