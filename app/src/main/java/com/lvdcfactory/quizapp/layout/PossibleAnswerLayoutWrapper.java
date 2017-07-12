package com.lvdcfactory.quizapp.layout;

import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.lvdcfactory.quizapp.AddQuestion;

/**
 * Created by Domenic on 12/07/2017.
 */

public class PossibleAnswerLayoutWrapper {

    private AddQuestion addQuestionActivity;
    private ViewGroup parent;
    private CheckBox checkBox;
    private EditText answerText;
    private Button btnDelete;

    public PossibleAnswerLayoutWrapper(final AddQuestion addQuestionActivity, ViewGroup parent) {
        this.addQuestionActivity = addQuestionActivity;
        this.parent = parent;

        /* Get child views */
        checkBox = (CheckBox) parent.getChildAt(0);
        answerText = (EditText) parent.getChildAt(1);
        btnDelete = (Button) parent.getChildAt(2);

        //Onclick listener
        btnDelete.setOnClickListener(new DeleteButtonClickedListener(this));
    }

    class DeleteButtonClickedListener implements View.OnClickListener {

        private PossibleAnswerLayoutWrapper wrapper;

        public DeleteButtonClickedListener(PossibleAnswerLayoutWrapper wrapper) {
            this.wrapper = wrapper;
        }

        @Override
        public void onClick(View view) {
            addQuestionActivity.removePossibleAnswerLayout(wrapper);
        }
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
