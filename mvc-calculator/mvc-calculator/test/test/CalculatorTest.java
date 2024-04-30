package test;

import static org.junit.Assert.*;

import java.awt.event.ActionEvent;

import org.junit.Before;
import org.junit.Test;

import calculator.controller.CalculatorController;
import calculator.model.CalculatorModel;
import calculator.view.CalculatorView;

public class CalculatorTest {
    
    private CalculatorModel model;
    private CalculatorView view;
    private CalculatorController controller;
    
    @Before
    public void setUp() {
        view = new CalculatorView();
        model = new CalculatorModel();
        controller = new CalculatorController(view, model);
    }

    /*
     * Model Functionality
     */
    
    /*
     * Basic Operations
     */
    @Test
    public void testAdd() {
    	model.setExpression("1+1=");
    	double result = 0;
    	result = model.evaluateExpression();
    	assertEquals(2, result, 0.0f);
    }
    
    @Test
    public void testSubtract() {
    	model.setExpression("5-4=");
    	double result = 0;
    	result = model.evaluateExpression();
    	assertEquals(1, result, 0.0f);
    }

    @Test
    public void testMultiply() {
    	model.setExpression("1*3=");
    	double result = 0;
    	result = model.evaluateExpression();
    	assertEquals(3, result, 0.0f);
    }
    
    @Test
    public void testDivide() {
    	model.setExpression("10/2=");
    	double result = 0;
    	result = model.evaluateExpression();
    	assertEquals(5, result, 0.0f);
    }
    
    @Test
    public void testSqrt() {
    	model.setExpression("144√=");
    	double result = 0;
    	result = model.evaluateExpression();
    	assertEquals(12, result, 0.0f);
    }
    
    @Test
    public void testSquare() {
    	model.setExpression("8²=");
    	double result = 0;
    	result = model.evaluateExpression();
    	assertEquals(64, result, 0.0f);
    }
    
    /*
     * Memory Functions
     */
    
    
}




