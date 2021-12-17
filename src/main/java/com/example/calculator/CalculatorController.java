package com.example.calculator;

import javafx.fxml.FXML;
import javafx.scene.text.Text;

public class CalculatorController {
    enum Operator {
        NULL,
        Plus,
        Minus,
        Multiplication,
        Division,
        Power,
        Sqrt,
        Square,
        Negation
    }

    private boolean needsReset;
    private Operator operator = Operator.NULL;
    private double memory;
    private double current;

    @FXML
    private Text display;

    private void show(double d) {
        if (isInteger(d)) {
            display.setText(Long.toString((long)d));
        } else {
            display.setText(Double.toString(d));
        }
    }

    boolean isInteger(double d){
        if(d > Long.MAX_VALUE || d < Long.MIN_VALUE){
            return true;
        } else return (long) d == d;
    }

    private void push(char c) {
        if (needsReset) {
            display.setText(String.valueOf(c));
            needsReset = false;
        } else {
            display.setText(display.getText() + c);
        }

        current = Double.parseDouble(display.getText());
    }

    // Numbers input
    @FXML
    protected void Button0() {
        push('0');
    }

    @FXML
    protected void Button1() {
        push('1');
    }

    @FXML
    protected void Button2() {
        push('2');
    }

    @FXML
    protected void Button3() {
        push('3');
    }

    @FXML
    protected void Button4() {
        push('4');
    }

    @FXML
    protected void Button5() {
        push('5');
    }

    @FXML
    protected void Button6() {
        push('6');
    }

    @FXML
    protected void Button7() {
        push('7');
    }

    @FXML
    protected void Button8() {
        push('8');
    }

    @FXML
    protected void Button9() {
        push('9');
    }

    @FXML
    protected void ButtonPoint() {
        push('.');
    }

    // Control
    @FXML
    protected void ButtonClear() {
        memory = 0;
        current = 0;
        operator = Operator.NULL;
        display.setText("");
    }

    @FXML
    protected void ButtonCE() {
        display.setText("");
        current = 0;
    }

    @FXML
    protected void Buttonequal() {
        switch (operator) {
            case NULL:
            case Sqrt:
            case Square:
            case Negation:
                memory = current;
                break;
            case Plus:
                memory = memory + current;
                break;
            case Minus:
                memory = memory - current;
                break;
            case Multiplication:
                memory = memory * current;
                break;
            case Division:
                memory = memory / current;
                break;
            case Power:
                memory = Math.pow(memory, current);
                break;
        }

        show(memory);
        needsReset = true;
    }

    // Binary Operators
    @FXML
    protected void ButtonPlus() {
        operator = Operator.Plus;
        memory = current;
        current = 0;
        display.setText("");
    }

    @FXML
    protected void ButtonMinus() {
        operator = Operator.Minus;
        memory = current;
        current = 0;
        display.setText("");
    }

    @FXML
    protected void ButtonMultiplication() {
        operator = Operator.Multiplication;
        memory = current;
        current = 0;
        display.setText("");
    }

    @FXML
    protected void ButtonDivision() {
        operator = Operator.Division;
        memory = current;
        current = 0;
        display.setText("");
    }

    @FXML
    protected void ButtonPower() {
        operator = Operator.Power;
        memory = current;
        current = 0;
        display.setText("");
    }

    // Unary Operators
    @FXML
    protected void Buttonsqrt() {
        operator = Operator.Sqrt;
        current = Math.sqrt(current);
        show(current);
    }

    @FXML
    protected void ButtonSquare() {
        operator = Operator.Square;
        current = current * current;
        show(current);
    }

    @FXML
    protected void ButtonNegation() {
        operator = Operator.Negation;
        current = -current;
        show(current);
    }
}