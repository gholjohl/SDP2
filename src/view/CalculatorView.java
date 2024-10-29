package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class CalculatorView {
    private JFrame frame;
    private JTextField firstNumberField;
    private JTextField secondNumberField;
    private JTextArea resultArea;

    public CalculatorView() {
        frame = new JFrame("Калькулятор");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new FlowLayout());

        firstNumberField = new JTextField(10);
        secondNumberField = new JTextField(10);
        resultArea = new JTextArea(5, 20);
        resultArea.setEditable(false);

        frame.add(firstNumberField);
        frame.add(secondNumberField);
        frame.add(createButtonPanel());
        frame.add(new JScrollPane(resultArea));

        frame.setVisible(true);
    }

    private JPanel createButtonPanel() {
        JPanel panel = new JPanel();
        String[] operations = {"+", "-", "*", "/"};
        for (String op : operations) {
            JButton button = new JButton(op);
            panel.add(button);
        }
        return panel;
    }

    public String getFirstNumber() {
        return firstNumberField.getText();
    }

    public String getSecondNumber() {
        return secondNumberField.getText();
    }

    public void setResult(String result) {
        resultArea.setText(result);
    }

    public void addOperationListener(ActionListener listener) {
        for (Component component : frame.getContentPane().getComponents()) {
            if (component instanceof JPanel) {
                for (Component btn : ((JPanel) component).getComponents()) {
                    if (btn instanceof JButton) {
                        ((JButton) btn).addActionListener(listener);
                    }
                }
            }
        }
    }
}
