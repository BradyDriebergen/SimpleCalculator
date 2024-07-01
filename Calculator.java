import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator extends JFrame implements ActionListener {
    private JTextField display;
    private JPanel panel;
    private String[] buttons = {
            "7", "8", "9", "/", 
            "4", "5", "6", "*", 
            "1", "2", "3", "-", 
            "0", ".", "=", "+"
    };
    private float value1;
    private float value2;
    private char operation;

    public Calculator() {
        // Initialize the components
        display = new JTextField();
        panel = new JPanel();
        panel.setLayout(new GridLayout(4, 4, 1, 1));
        this.value1 = 0;
        this.value2 = 0;
        this.operation = ' ';

        // Creates the buttons
        for (String button : buttons) {
            JButton btn = new JButton(button);
            btn.addActionListener(this);
            panel.add(btn);
        }

        // Sets the layout
        this.setLayout(new BorderLayout());
        this.add(display, BorderLayout.NORTH);
        this.add(panel, BorderLayout.CENTER);

        // Sets the window properties
        this.setSize(300, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        // Gets action from the buttons
        String command = e.getActionCommand();
        // Logic for the calculator
        if (value1 == 0) {
            display.setText(command);
            value1 = Float.parseFloat(command);
        } else if (operation == ' ') {
            display.setText(display.getText() + " " + command);
            operation = command.charAt(0);
        } else {
            value2 = Float.parseFloat(command);
            switch (operation) {
                case '+':
                    value1 += value2;
                    break;
                case '-':
                    value1 -= value2;
                    break;
                case '*':
                    value1 *= value2;
                    break;
                case '/':
                    value1 /= value2;
                    break;
            }
            display.setText(Float.toString(value1));
            operation = ' ';
        }
    }

    public static void main(String[] args) {
        new Calculator();
    }
}