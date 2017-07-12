package com.lvdcfactory.quizapp.layout;

import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

/**
 * Created by Domenic on 12/07/2017.
 */

public class PossibleAnswerLayoutWrapper {

    private ViewGroup parent;
    private CheckBox checkBox;
    private EditText answerText;
    private Button btnDelete;

    public PossibleAnswerLayoutWrapper(ViewGroup parent) {
        this.parent = parent;

        /* Get child views */
        checkBox = (CheckBox) parent.getChildAt(0);
        answerText = (EditText) parent.getChildAt(1);
        btnDelete = (Button) parent.getChildAt(2);
    }

    public ViewGroup getParent() {
        return parent;
    }

    public CheckBox getCheckBox() {
        return checkBox;
    }

    public EditText getAnswerText() {
        return answerText;
    }

    public Button getBtnDelete() {
        return btnDelete;
    }
}
