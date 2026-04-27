import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class GUICalculator extends JFrame implements ActionListener {
    JTextField num1Field, num2Field;
    JComboBox<String> operationBox;
    JButton calculateButton;
    JLabel resultLabel;
    GUICalculator() {
        setTitle("GUI Calculator");
        setSize(400, 250);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        num1Field = new JTextField(10);
        num2Field = new JTextField(10);
        String[] operations = {"+", "-", "*", "/"};
        operationBox = new JComboBox<>(operations);
        calculateButton = new JButton("Calculate");
        resultLabel = new JLabel("Result: ");
        calculateButton.addActionListener(this);
        add(new JLabel("Enter first number:"));
        add(num1Field);
        add(new JLabel("Enter second number:"));
        add(num2Field);
        add(new JLabel("Select operation:"));
        add(operationBox);
        add(calculateButton);
        add(resultLabel);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e) {
        String n1 = num1Field.getText();
        String n2 = num2Field.getText();
        if (n1.trim().isEmpty() || n2.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Error: Please enter both numbers!");
            return;
        }
        try {
            double num1 = Double.parseDouble(n1);
            double num2 = Double.parseDouble(n2);
            String op = (String) operationBox.getSelectedItem();
            double result = 0;
            if (op.equals("+")) {
                result = num1 + num2;
            } else if (op.equals("-")) {
                result = num1 - num2;
            } else if (op.equals("*")) {
                result = num1 * num2;
            } else if (op.equals("/")) {
                if (num2 == 0) {
                    JOptionPane.showMessageDialog(this, "Error: Division by zero is not allowed!");
                    return;
                }
                result = num1 / num2;
            }
            resultLabel.setText("Result: " + result);

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Error: Please enter valid numbers!");
        }
    }
    public static void main(String[] args) {
        new GUICalculator();
    }
}