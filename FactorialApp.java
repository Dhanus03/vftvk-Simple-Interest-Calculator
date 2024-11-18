import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FactorialApp extends JFrame implements ActionListener {
    private JTextField inputField;
    private JButton calculateButton;
    private JLabel resultLabel;

    public FactorialApp() {
        setTitle("Factorial Calculator");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JLabel promptLabel = new JLabel("Enter a number:");
        promptLabel.setBounds(30, 30, 100, 25);
        add(promptLabel);

        inputField = new JTextField();
        inputField.setBounds(130, 30, 100, 25);
        add(inputField);

        calculateButton = new JButton("Calculate");
        calculateButton.setBounds(80, 70, 120, 25);
        calculateButton.addActionListener(this);
        add(calculateButton);

        resultLabel = new JLabel("Factorial:");
        resultLabel.setBounds(30, 110, 240, 25);
        add(resultLabel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            int number = Integer.parseInt(inputField.getText());
            long factorial = calculateFactorial(number);
            resultLabel.setText("Factorial: " + factorial);
        } catch (NumberFormatException ex) {
            resultLabel.setText("Please enter a valid integer.");
        } catch (IllegalArgumentException ex) {
            resultLabel.setText(ex.getMessage());
        }
    }

    private long calculateFactorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Factorial is not defined for negative numbers.");
        }
        long result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            FactorialApp app = new FactorialApp();
            app.setVisible(true);
        });
    }
}
