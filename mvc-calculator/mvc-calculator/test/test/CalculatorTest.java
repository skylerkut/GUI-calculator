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
     * Basic Operations Doubles
     */
    @Test
    public void testAdd2() {
    	model.setExpression("1.1+1.3=");
    	double result = 0;
    	result = model.evaluateExpression();
    	assertEquals(2.4, result, 0.01f);
    }
    
    @Test
    public void testSubtract2() {
    	model.setExpression("5.6-4.9=");
    	double result = 0;
    	result = model.evaluateExpression();
    	assertEquals(0.7, result, 0.01f);
    }

    @Test
    public void testMultiply2() {
    	model.setExpression("1.4*3.7=");
    	double result = 0;
    	result = model.evaluateExpression();
    	assertEquals(5.18, result, 0.01f);
    }
    
    @Test
    public void testDivide2() {
    	model.setExpression("10.8/2.2=");
    	double result = 0;
    	result = model.evaluateExpression();
    	assertEquals(4.9, result, 0.01f);
    }
    
    @Test
    public void testSqrt2() {
    	model.setExpression("144.77√=");
    	double result = 0;
    	result = model.evaluateExpression();
    	assertEquals(12.032, result, 0.01f);
    }
    
    @Test
    public void testSquare2() {
    	model.setExpression("8.65²=");
    	double result = 0;
    	result = model.evaluateExpression();
    	assertEquals(74.8225, result, 0.01f);
    }
    
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




