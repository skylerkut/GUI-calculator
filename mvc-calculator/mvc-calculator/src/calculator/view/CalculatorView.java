package calculator.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class CalculatorView extends JFrame {
    private JButton jb1, jb2, jb3, jb4, jb5, jb6, jb7, jb8, jb9, jb0, jbClear, jbAdd, jbSubstract, jbMultiply, jbDivide, jbEqual, jbSquare,
    jbSquareRoot, jbMemoryAdd, jbMemorySubtract, jbMemoryRecall, jbMemoryClear, jbDelete, jbDecimal;
    private JTextField jtfResult, jftCurrentExpressionTxt;

    public CalculatorView() {
    	
        this.setSize(400, 400);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | UnsupportedLookAndFeelException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }

        this.setTitle("Scientific Calculator");

        // Styles
        Font font = new Font("Helvetuca", Font.PLAIN, 18);

        // Layout
        JPanel jpMain = new JPanel();
        jpMain.setLayout(new GridBagLayout());

        // Grid bag layout
        GridBagConstraints gridConstraints = new GridBagConstraints();
        gridConstraints.gridx = 1;
        gridConstraints.gridy = 1;
        gridConstraints.gridwidth = 1;
        gridConstraints.gridheight = 1;
        gridConstraints.weightx = 50;
        gridConstraints.weighty = 100;
        gridConstraints.insets = new Insets(5, 5, 5, 5);
        gridConstraints.anchor = GridBagConstraints.CENTER;
        gridConstraints.fill = GridBagConstraints.BOTH;

        // Numbers
        jb1 = new JButton("1");
        jb2 = new JButton("2");
        jb3 = new JButton("3");
        jb4 = new JButton("4");
        jb5 = new JButton("5");
        jb6 = new JButton("6");
        jb7 = new JButton("7");
        jb8 = new JButton("8");
        jb9 = new JButton("9");
        jb0 = new JButton("0");

        // Operations
        jbClear = new JButton("C");
        jbAdd = new JButton("+");
        jbSubstract = new JButton("-");
        jbMultiply = new JButton("*");
        jbDivide = new JButton("/");
        jbEqual = new JButton("=");
        jbSquare = new JButton("²");
        jbSquareRoot = new JButton("√");
        
        // Memory functions
        jbMemoryAdd = new JButton("M+");
        jbMemorySubtract = new JButton("M-");
        jbMemoryRecall = new JButton("MR");
        jbMemoryClear = new JButton("MC");

        // Delete
        jbDelete = new JButton("Del");
        //Decimal
        jbDecimal = new JButton(".");

        jftCurrentExpressionTxt = new JTextField(10);
        jftCurrentExpressionTxt.setFont(font);
        jftCurrentExpressionTxt.setHorizontalAlignment(JTextField.RIGHT);
        jtfResult = new JTextField(10);
        jtfResult.setHorizontalAlignment(JTextField.RIGHT);
        jtfResult.setFont(font);

        // Results
        JPanel jpResults = new JPanel();
        jpResults.setLayout(new BorderLayout());

        jpResults.add(jftCurrentExpressionTxt, BorderLayout.NORTH);
        jpResults.add(jtfResult, BorderLayout.CENTER);

        gridConstraints.gridx = 1;
        gridConstraints.gridy = 0;
        gridConstraints.gridwidth = 5;
        jpMain.add(jpResults, gridConstraints);

        
        // Memory functions/ First row
        gridConstraints.gridwidth = 1;
        gridConstraints.gridx = 1;
        gridConstraints.gridy = 1;
        jpMain.add(jbMemoryAdd, gridConstraints);
        gridConstraints.gridx = 2;
        jpMain.add(jbMemorySubtract, gridConstraints);
        gridConstraints.gridx = 3;
        jpMain.add(jbMemoryRecall, gridConstraints);
        gridConstraints.gridx = 4;
        jpMain.add(jbMemoryClear, gridConstraints);
        
        // Second row
        gridConstraints.gridwidth = 1;
        gridConstraints.gridx = 1;
        gridConstraints.gridy = 2;
        jpMain.add(jb1, gridConstraints);
        gridConstraints.gridx = 2;
        jpMain.add(jb2, gridConstraints);
        gridConstraints.gridx = 3;
        jpMain.add(jb3, gridConstraints);
        gridConstraints.gridx = 4;
        jpMain.add(jbAdd, gridConstraints);

        // Third row
        gridConstraints.gridx = 1;
        gridConstraints.gridy = 3;
        jpMain.add(jb4, gridConstraints);
        gridConstraints.gridx = 2;
        jpMain.add(jb5, gridConstraints);
        gridConstraints.gridx = 3;
        jpMain.add(jb6, gridConstraints);
        gridConstraints.gridx = 4;
        jpMain.add(jbSubstract, gridConstraints);

        // Fourth row
        gridConstraints.gridx = 1;
        gridConstraints.gridy = 4;
        jpMain.add(jb7, gridConstraints);
        gridConstraints.gridx = 2;
        jpMain.add(jb8, gridConstraints);
        gridConstraints.gridx = 3;
        jpMain.add(jb9, gridConstraints);
        gridConstraints.gridx = 4;
        jpMain.add(jbMultiply, gridConstraints);
        
        //  Fifth row
        gridConstraints.gridx = 1;
        gridConstraints.gridy = 5;
        jpMain.add(jbDelete, gridConstraints);
        gridConstraints.gridx = 2;
        jpMain.add(jb0, gridConstraints);
        gridConstraints.gridx = 3;
        jpMain.add(jbClear, gridConstraints);
        gridConstraints.gridx = 4;
        jpMain.add(jbDivide, gridConstraints);
        
        // Operations
        gridConstraints.gridy = 6;
        gridConstraints.gridx = 1;
        jpMain.add(jbDecimal, gridConstraints);
        gridConstraints.gridx = 2;
        jpMain.add(jbSquare, gridConstraints);
        gridConstraints.gridx = 3;
        jpMain.add(jbSquareRoot, gridConstraints);

        this.add(jpMain);
        this.setVisible(true);
    }
    
	public String getCurrentExpressionTxt() {
		return jftCurrentExpressionTxt.getText();
	}

	public void setCurrentExpressionTxt(String currentExpression) {
		this.jftCurrentExpressionTxt.setText(currentExpression);
	}
	
	public void addToCurrExpression(String addInput) {
		String addOn = "";
		addOn = getCurrentExpressionTxt() + addInput;
		setCurrentExpressionTxt(addOn);
	}

	public String getResult() {
        return jtfResult.getText();
    }

    public void setResult(String result) {
        jtfResult.setText(result);
    }

    public void addCalculationListener (ActionListener listenForCalc) {
        jb0.addActionListener(listenForCalc);
        jb1.addActionListener(listenForCalc);
        jb2.addActionListener(listenForCalc);
        jb3.addActionListener(listenForCalc);
        jb4.addActionListener(listenForCalc);
        jb5.addActionListener(listenForCalc);
        jb6.addActionListener(listenForCalc);
        jb7.addActionListener(listenForCalc);
        jb8.addActionListener(listenForCalc);
        jb9.addActionListener(listenForCalc);
        jbAdd.addActionListener(listenForCalc);
        jbSubstract.addActionListener(listenForCalc);
        jbMultiply.addActionListener(listenForCalc);
        jbDivide.addActionListener(listenForCalc);
        jbSquare.addActionListener(listenForCalc);
        jbSquareRoot.addActionListener(listenForCalc);
    }

    public void addOperationListener (ActionListener listenForOperation) {
        jbEqual.addActionListener(listenForOperation);
        jbMemoryRecall.addActionListener(listenForOperation);
        jbMemoryClear.addActionListener(listenForOperation);
        jbClear.addActionListener(listenForOperation);
        jbDelete.addActionListener(listenForOperation);
        jbMemoryAdd.addActionListener(listenForOperation);
        jbMemorySubtract.addActionListener(listenForOperation);
    }
}
