package com.example.calculator;

import javafx.fxml.FXML;
import javafx.scene.control.Slider;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class CalculatorController {
    public VBox root;

    // Helpers
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
    private float memory = 0;
    private float current;

    private void show(float d) {
        if (isInteger(d)) {
            display.setText(Long.toString((long)d));
        } else {
            display.setText(Float.toString(d));
        }
    }

    boolean isInteger(float d){
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

        current = Float.parseFloat(display.getText());
    }

    public void initialize() {
        slider.valueProperty().addListener((observable, oldValue, newValue) -> {
            current = (float) (Math.floor((double)newValue * 100) / 100);
            show(current);
        });

        root.addEventHandler(KeyEvent.KEY_TYPED,(keyEvent) -> {
            switch (keyEvent.getCharacter()) {
                case "0":
                    Button0();
                    break;
                case "1":
                    Button1();
                    break;
                case "2":
                    Button2();
                    break;
                case "3":
                    Button3();
                    break;
                case "4":
                    Button4();
                    break;
                case "5":
                    Button5();
                    break;
                case "6":
                    Button6();
                    break;
                case "7":
                    Button7();
                    break;
                case "8":
                    Button8();
                    break;
                case "9":
                    Button9();
                    break;
                case "+":
                    ButtonPlus();
                    break;
                case "-":
                    ButtonMinus();
                    break;
                case "*":
                    ButtonMultiplication();
                    break;
                case "/":
                    ButtonDivision();
                    break;
                case "^":
                    ButtonPower();
                    break;
                case ".":
                    ButtonPoint();
                    break;
                case "\r":
                    Buttonequal();
                    break;
                default:
                    System.out.println(keyEvent);
                    break;
            }
        });
    }

    // FX
    @FXML
    protected Text display;

    @FXML
    protected Slider slider;

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
                memory = (float) Math.pow(memory, current);
                break;
        }

        show(memory);
        needsReset = true;
    }

    // Binary Operators
    @FXML
    protected void ButtonPlus() {
        operator = Operator.Plus;
        if (memory == 0) {
            memory = current;
        } else {
            current = memory;
        }
        display.setText("");
    }

    @FXML
    protected void ButtonMinus() {
        operator = Operator.Minus;
        if (memory == 0) {
            memory = current;
        } else {
            current = memory;
        }
        display.setText("");
    }

    @FXML
    protected void ButtonMultiplication() {
        operator = Operator.Multiplication;
        if (memory == 0) {
            memory = current;
        } else {
            current = memory;
        }
        display.setText("");
    }

    @FXML
    protected void ButtonDivision() {
        operator = Operator.Division;
        if (memory == 0) {
            memory = current;
        } else {
            current = memory;
        }
        display.setText("");
    }

    @FXML
    protected void ButtonPower() {
        operator = Operator.Power;
        if (memory == 0) {
            memory = current;
        } else {
            current = memory;
        }
        display.setText("");
    }

    // Unary Operators
    @FXML
    protected void Buttonsqrt() {
        operator = Operator.Sqrt;
        if (memory != 0) {
            current = memory;
        }
        current = (float) Math.sqrt(current);
        memory = current;
        show(current);
    }

    @FXML
    protected void ButtonSquare() {
        operator = Operator.Square;
        if (memory != 0) {
            current = memory;
        }
        current = current * current;
        memory = current;
        show(current);
    }

    @FXML
    protected void ButtonNegation() {
        operator = Operator.Negation;
        if (memory != 0) {
            current = memory;
        }
        current = -current;
        memory = current;
        show(current);
    }
}