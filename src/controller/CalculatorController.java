package controller;

import model.CalculatorModel;
import view.CalculatorView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorController {
    private CalculatorModel model;
    private CalculatorView view;

    public CalculatorController(CalculatorModel model, CalculatorView view) {
        this.model = model;
        this.view = view;

        this.view.addOperationListener(new OperationListener());
    }

    class OperationListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                double firstNumber = Double.parseDouble(view.getFirstNumber());
                double secondNumber = Double.parseDouble(view.getSecondNumber());
                double result = 0;

                switch (e.getActionCommand()) {
                    case "+":
                        result = model.add(firstNumber, secondNumber);
                        break;
                    case "-":
                        result = model.subtract(firstNumber, secondNumber);
                        break;
                    case "*":
                        result = model.multiply(firstNumber, secondNumber);
                        break;
                    case "/":
                        result = model.divide(firstNumber, secondNumber);
                        break;
                }
                view.setResult(String.valueOf(result));
            } catch (NumberFormatException ex) {
                view.setResult("Ошибка: некорректный ввод");
            } catch (ArithmeticException ex) {
                view.setResult(ex.getMessage());
            }
        }
    }
}
