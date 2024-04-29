package test;

import static org.junit.Assert.*;
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

    @Test
    public void testBasicFunctionality() {
        // Test basic math operations
        assertEquals("2", performOperationAndGetResult("1+1="));
        assertEquals("4", performOperationAndGetResult("2*2="));
        assertEquals("5", performOperationAndGetResult("7-2="));
        assertEquals("3", performOperationAndGetResult("6/2="));
    }

    @Test
    public void testAdvancedOperations() {
        // Test square and square root operations
        assertEquals("25.0", performOperationAndGetResult("5x²="));
        assertEquals("5.0", performOperationAndGetResult("25√="));
    }

//    @Test
//    public void testMemoryFunctionality() {
//        // Test memory operations
//        performOperationAndGetResult("5+3=");
//        view.clickMemoryAddButton();
//        performOperationAndGetResult("M-Clear");
//        performOperationAndGetResult("M-Recall");
//        assertEquals("8.0", view.getDisplayText());
//        view.clickMemoryClearButton();
//        performOperationAndGetResult("M-Recall");
//        assertEquals("0.0", view.getDisplayText());
//    }

//    @Test
//    public void testDeleteFunctionality() {
//        // Test delete functionality
//        performOperationAndGetResult("1234.5");
//        view.clickDeleteButton();
//        assertEquals("1234.", view.getDisplayText());
//        view.clickDeleteButton();
//        assertEquals("1234", view.getDisplayText());
//        view.clickDeleteButton();
//        assertEquals("123", view.getDisplayText());
//    }

    @Test
    public void testDivisionByZero() {
        // Test division by zero
        assertEquals("Error", performOperationAndGetResult("5/0="));
    }

    private String performOperationAndGetResult(String operation) {
        for (char c : operation.toCharArray()) {
            if (Character.isDigit(c) || c == '.') {
                view.clickDigitButton(Character.toString(c));
            } else {
                view.clickOperationButton(Character.toString(c));
            }
        }
        return view.getDisplayText();
    }
}

