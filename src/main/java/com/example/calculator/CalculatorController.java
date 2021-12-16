package com.example.calculator;

import javafx.fxml.FXML;
import javafx.scene.text.Text;

public class CalculatorController {
    @FXML
    private Text display;

    private void push(char c) {
        display.setText(display.getText() + c);
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
        // TODO
    }

    @FXML
    protected void ButtonCE() {
        display.setText("");
    }

    @FXML
    protected void Buttonequal() {
        // TODO
    }

    // Binary Operators
    @FXML
    protected void ButtonPlus() {
        // TODO
    }

    @FXML
    protected void ButtonMinus() {
        // TODO
    }

    @FXML
    protected void ButtonMultiplication() {
        // TODO
    }

    @FXML
    protected void ButtonDivision() {
        // TODO
    }

    @FXML
    protected void ButtonPower() {
        // TODO
    }

    // Unary Operators
    @FXML
    protected void Buttonsqrt() {
        // TODO
    }

    @FXML
    protected void ButtonSquare() {
        // TODO
    }

    @FXML
    protected void ButtonNagation() {
        // TODO
    }
}