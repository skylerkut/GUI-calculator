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

	// Set up the calculator model, view, and controller before each test.
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
	// Test addition operation with double numbers.
	@Test
	public void testAdd2() {
		model.setExpression("1.1+1.3=");
		double result = model.evaluateExpression();
		assertEquals(2.4, result, 0.01f);
	}

	// Test subtraction operation with double numbers.
	@Test
	public void testSubtract2() {
		model.setExpression("5.6-4.9=");
		double result = model.evaluateExpression();
		assertEquals(0.7, result, 0.01f);
	}

	// Test multiplication operation with double numbers.
	@Test
	public void testMultiply2() {
		model.setExpression("1.4*3.7=");
		double result = model.evaluateExpression();
		assertEquals(5.18, result, 0.01f);
	}

	// Test division operation with double numbers.
	@Test
	public void testDivide2() {
		model.setExpression("10.8/2.2=");
		double result = model.evaluateExpression();
		assertEquals(4.9, result, 0.01f);
	}

	// Test square root operation with double numbers.
	@Test
	public void testSqrt2() {
		model.setExpression("144.77√=");
		double result = model.evaluateExpression();
		assertEquals(12.032, result, 0.01f);
	}

	// Test square operation with double numbers.
	@Test
	public void testSquare2() {
		model.setExpression("8.65²=");
		double result = model.evaluateExpression();
		assertEquals(74.8225, result, 0.01f);
	}

	/*
	 * Basic Operations
	 */
	
	// Test addition operation with integers.
	@Test
	public void testAdd() {
		model.setExpression("1+1=");
		double result = model.evaluateExpression();
		assertEquals(2, result, 0.0f);
	}

	// Test subtraction operation with integers.
	@Test
	public void testSubtract() {
		model.setExpression("5-4=");
		double result = model.evaluateExpression();
		assertEquals(1, result, 0.0f);
	}

	// Test multiplication operation with integers.
	@Test
	public void testMultiply() {
		model.setExpression("1*3=");
		double result = model.evaluateExpression();
		assertEquals(3, result, 0.0f);
	}

	// Test division operation with integers.
	@Test
	public void testDivide() {
		model.setExpression("10/2=");
		double result = model.evaluateExpression();
		assertEquals(5, result, 0.0f);
	}

	// Test square root operation with integers.
	@Test
	public void testSqrt() {
		model.setExpression("144√=");
		double result = model.evaluateExpression();
		assertEquals(12, result, 0.0f);
	}

	// Test square operation with integers.
	@Test
	public void testSquare() {
		model.setExpression("8²=");
		double result = model.evaluateExpression();
		assertEquals(64, result, 0.0f);
	}

	/*
	 * Parenthesis tests
	 */

	// Test parentheses with addition.
	@Test
	public void testParenthesisAddition() {
		model.setExpression("(2+2)=");
		assertEquals(4.0, model.evaluateExpression(), 0.001);
	}

	// Test nested parentheses with subtraction.
	@Test
	public void testNestedParenthesisSubtraction() {
		model.setExpression("((8-3)-2)=");
		assertEquals(3.0, model.evaluateExpression(), 0.001);
	}

	// Test parentheses with multiplication.
	@Test
	public void testParenthesisMultiplication() {
		model.setExpression("(3*4)=");
		assertEquals(12.0, model.evaluateExpression(), 0.001);
	}

	// Test nested parentheses with mixed operations.
	@Test
	public void testNestedParenthesisMixedOperations() {
		model.setExpression("(2+3)*(4-1)=");
		assertEquals(15.0, model.evaluateExpression(), 0.001);
	}

	// Test parentheses with division.
	@Test
	public void testParenthesisDivision() {
		model.setExpression("(10/2)=");
		assertEquals(5.0, model.evaluateExpression(), 0.001);
	}

	// Test parentheses with square root.
	@Test
	public void testParenthesisSquareRoot() {
		model.setExpression("(√9)=");
		assertEquals(3.0, model.evaluateExpression(), 0.001);
	}

	// Test nested parentheses with power.
	@Test
	public void testNestedParenthesisPower() {
		model.setExpression("((2²)+3)=");
		assertEquals(7.0, model.evaluateExpression(), 0.001);
	}

	// Test nested parentheses with all operations.
	@Test
	public void testNestedParenthesisAllOperations() {
		model.setExpression("((2+3)*(4-1))/(√9)=");
		assertEquals(5.0, model.evaluateExpression(), 0.001);
	}

	/*
	 * Memory Functions
	 */

	@Test
	public void testMemAdd() {
		// Perform initial operation
		model.setExpression("8²=");
		double result = model.evaluateExpression();

	}
}
