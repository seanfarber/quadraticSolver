/**
 *  Sean Farber December 4, 2016
 *  Find roots with quadratic equation
 *  2 reals, 1 real, or 2 imaginary.
 *  Display results in JTextField
 */

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.text.DecimalFormat;

public class QuadraticSolver extends JFrame {

	private JPanel panel1;		// display quadratic formula
	private JPanel panel2;		// for coefficient 1
	private JPanel panel3;		// for coefficient 2
	private JPanel panel4;		// for coefficient 3
	private JPanel panel5;		// for button
	private JPanel panel6; 		// for number of roots info
	private JPanel panel7;		// for solution
	private JLabel message1;	// for formula
	private JLabel message2;	// for coefficient 1
	private JLabel message3;	// for coefficient 2
	private JLabel message4;	// for coefficient 3
	
	private JTextField coefficient1;
	private JTextField coefficient2;
	private JTextField coefficient3;
	private JTextField numRoots;	// number of roots in text field
	private JTextField roots;		// roots
	
	private JButton solveButton;	// Solve button
	
	private final int WINDOW_WIDTH = 300;
	private final int WINDOW_HEIGHT = 600;
	
	/**
	 * Constructor
	 */
	
	public QuadraticSolver() {
		
		// Set window title
		setTitle("Find the roots");
		
		// Set window size
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		
		// Set close button
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Set layout
		setLayout(new GridLayout(7, 1));
		
		// build the panels
		buildPanels();
		
		// addPanels 
		add(panel1);
		add(panel2);
		add(panel3);
		add(panel4);
		add(panel5);
		add(panel6);
		add(panel7);
		
		setVisible(true);
		
	}
	
	/**
	 * buildPanels method
	 */
	
	private void buildPanels() {
		
		// panel 1
		panel1 = new JPanel();
		message1 = new JLabel("Find the roots of ax^2 + bx + c");
		panel1.add(message1);
		
		// panel 2
		panel2 = new JPanel();
		message2 = new JLabel("Enter the first coefficient");
		coefficient1 = new JTextField(5);
		panel2.add(message2);
		panel2.add(coefficient1);
		
		// panel 3
		panel3 = new JPanel();
		message3 = new JLabel("Enter the second coefficient");
		coefficient2 = new JTextField(5);
		panel3.add(message3);
		panel3.add(coefficient2);
		
		// panel 4
		panel4 = new JPanel();
		message4 = new JLabel("Enter the third coefficient");
		coefficient3 = new JTextField(5);
		panel4.add(message4);
		panel4.add(coefficient3);
		
		// panel 5
		panel5 = new JPanel();
		solveButton = new JButton("Solve");
		solveButton.addActionListener(new SolveButtonListener());
		panel5.add(solveButton);
		
		// panel6
		panel6 = new JPanel();
		numRoots = new JTextField(20);
		numRoots.setText("Answer Line 1");
		panel6.add(numRoots);
		
		// panel7
		panel7 = new JPanel();
		roots = new JTextField(20);
		roots.setText("Answer Line 2");
		panel7.add(roots);
		
	}
	
	/**
	 * ActionListener class for solveButton
	 */
	
	private class SolveButtonListener implements ActionListener {
		
		/**
		 * The actionPerformed method executes when the 
		 * solve button is pushed. 
		 * Finds roots of quadratic equation.
		 */
		
		public void actionPerformed(ActionEvent e) {
			
			String input;		// for text field input
			Double a;		// coefficient 1 etc
			Double b;
			Double c;
			
			input = coefficient1.getText();
			a = Double.parseDouble(input);
			input = coefficient2.getText();
			b = Double.parseDouble(input);
			input = coefficient3.getText();
			c = Double.parseDouble(input);
			
			Double discriminant = b * b - 4 * a * c;
			
			Double root1;
			Double root2;
			Double imaginary;
			DecimalFormat d3 = new DecimalFormat("#.000");

			if (discriminant > 0) {
				
				root1 = (-b + Math.sqrt(discriminant)) / (2 * a);
				root2 = (-b - Math.sqrt(discriminant)) / (2 * a);
				
				
				numRoots.setText("There are two real roots"); 
				roots.setText("Root 1: "+(d3.format(root1)) + " Root 2: " + d3.format(root2));
				
			}
			
			else if (discriminant == 0) {
				
				root1 = (-b + Math.sqrt(discriminant)) / (2 * a);
				root2 = (-b - Math.sqrt(discriminant)) / (2 * a);
				
				numRoots.setText("There is only one real root");
				roots.setText("Root 1: " + d3.format(root1));
				
			}
			
			else {
				
				root1 = -b / (2 * a);
				imaginary = Math.sqrt(-1 * discriminant) / (2 * a);
				root2 = -b / (2 * a);
				
				numRoots.setText("There are two imaginary roots");
				roots.setText(d3.format(root1) + " + " + d3.format(imaginary) + "i" +
							  " and " +
							  d3.format(root2) + " - " + d3.format(imaginary) + "i");
				
			}
			
		}
	}
	
	/**
	 * main method
	 */
	
	public static void main(String[] args) {
		
		new QuadraticSolver();
	}
	
}
