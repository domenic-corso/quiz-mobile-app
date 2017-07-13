package com.lvdcfactory.quizapp.layout;

import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

import com.lvdcfactory.quizapp.AddQuestion;

import java.util.List;

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

        btnDelete.setOnClickListener(new DeleteButtonClickedListener(this));
        checkBox.setOnCheckedChangeListener(new CheckBoxChangedListener());
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

    class CheckBoxChangedListener implements CompoundButton.OnCheckedChangeListener{

        @Override
        public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
            /* Only proceed if the checked state is true */
            if (!b) {
                return;
            }

            /* Get all the other wrappers */
            List<PossibleAnswerLayoutWrapper> otherWrappers = addQuestionActivity.getPossibleAnswerLayoutWrappers();

            /* Loop through the other wrappers, make them all unchecked as long as they
            are not the one that was recently checked (compoundButton which triggered this
            event listener)
             */
            for (PossibleAnswerLayoutWrapper w : otherWrappers) {
                if (w.getCheckBox() != compoundButton) {
                    w.getCheckBox().setChecked(false);
                }
            }
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
