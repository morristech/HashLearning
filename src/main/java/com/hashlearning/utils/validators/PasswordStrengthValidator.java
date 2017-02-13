package com.hashlearning.utils.validators;

import com.jfoenix.validation.base.ValidatorBase;
import javafx.scene.control.TextInputControl;

/**
 * Created by Omar Sahl on 09-Dec-16
 */

public class PasswordStrengthValidator extends ValidatorBase {

    @Override
    protected void eval() {
        if (srcControl.get() instanceof TextInputControl)
            evalTextInputField();
    }

    private void evalTextInputField() {
        TextInputControl textField = (TextInputControl) srcControl.get();
        if (textField.getText() == null || textField.getText().equals("") ||
                !PasswordChecker.checkPassword(textField.getText()).isValid()) hasErrors.set(true);
        else hasErrors.set(false);
    }

}
