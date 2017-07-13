package com.lvdcfactory.quizapp;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.lvdcfactory.quizapp.layout.PossibleAnswerLayoutWrapper;
import com.lvdcfactory.quizapp.quiz.Quiz;

import java.util.ArrayList;
import java.util.List;

public class AddQuestion extends AppCompatActivity {

    private Quiz newlyCreatedQuiz;

    private Button btnBasicQuestion, btnMultipleChoiceQuestion;
    private ViewGroup basicQuestionLayout, multipleChoiceQuestionLayout;
    enum ActiveQuestionType {
        BASIC,
        MULTIPLE_CHOICE,
        NONE
    }

    private List<PossibleAnswerLayoutWrapper> possibleAnswerLayoutWrappers;
    private ViewGroup possibleAnswerLayoutsContainer;
    private Button btnAddPossibleAnswer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_question);

        Intent intent = getIntent();

        /* Get the passed object that is supposed to be passed through the Intent */
        Object passedObject;
        passedObject = intent.getSerializableExtra(CreateQuiz.QUIZ_EXTRA);

        /* If no object could be found or it is not a Quiz, close Activity */
        if (passedObject == null || !(passedObject instanceof Quiz)) {
            finish();
            return;
        }

        newlyCreatedQuiz = (Quiz) passedObject;

        findViews();
        addEventListeners();

        possibleAnswerLayoutWrappers = new ArrayList<>();

        /* Show the basic question layout by default */
        btnBasicQuestion.callOnClick();
    }

    private void findViews() {
        btnBasicQuestion = (Button) findViewById(R.id.addQuestion_btnBasic);
        btnMultipleChoiceQuestion = (Button) findViewById(R.id.addQuestion_btnMultipleChoice);

        basicQuestionLayout = (ViewGroup) findViewById(R.id.addQuestion_layout_basicQuestion);
        multipleChoiceQuestionLayout = (ViewGroup) findViewById(R.id.addQuestion_layout_multipleChoice);

        btnAddPossibleAnswer = (Button) findViewById(R.id.addQuestion_btnAddPossibleAnswer);
        possibleAnswerLayoutsContainer = (ViewGroup) findViewById(R.id.addQuestion_possibleAnswersContainer);
    }

    private void addEventListeners() {
        btnBasicQuestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showQuestionTypeLayout(basicQuestionLayout);
                highlightQuestionTypeButton((Button) view);
            }
        });

        btnMultipleChoiceQuestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showQuestionTypeLayout(multipleChoiceQuestionLayout);
                highlightQuestionTypeButton((Button) view);
            }
        });

        btnAddPossibleAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addPossibleAnswerLayout();
            }
        });
    }


    private ActiveQuestionType activeQuestionType() {
        if (basicQuestionLayout.getVisibility() == View.VISIBLE) {
            return ActiveQuestionType.BASIC;
        }

        if (multipleChoiceQuestionLayout.getVisibility() == View.VISIBLE) {
            return ActiveQuestionType.MULTIPLE_CHOICE;
        }

        return ActiveQuestionType.NONE;
    }

    /* Switches between the user input modes for a basic question or a multiple choice question */
    private void showQuestionTypeLayout(ViewGroup layout) {
        basicQuestionLayout.setVisibility(View.GONE);
        multipleChoiceQuestionLayout.setVisibility(View.GONE);

        layout.setVisibility(View.VISIBLE);
    }

    /* Highlights whichever question type button is selected by changing the background
     * color of the buttons */
    private void highlightQuestionTypeButton(Button typeButton) {
        int UNSELECTED = Color.rgb(230, 230, 230);
        int SELECTED = Color.rgb(210, 210, 210);

        btnBasicQuestion.setBackgroundColor(UNSELECTED);
        btnMultipleChoiceQuestion.setBackgroundColor(UNSELECTED);

        typeButton.setBackgroundColor(SELECTED);
    }

    private void addPossibleAnswerLayout() {
        /* Inflate a 'Possible Answer View' */
        LayoutInflater inflater = getLayoutInflater();
        ViewGroup possibleAnswerLayout = (ViewGroup) inflater.inflate(R.layout.possible_answer_layout, null);

        /* Create a new wrapper for the layout */
        PossibleAnswerLayoutWrapper wrapper = new PossibleAnswerLayoutWrapper(this, possibleAnswerLayout);

        /* Add to beginning of list of wrappers */
        possibleAnswerLayoutWrappers.add(0, wrapper);

        /* Add to beginning of the container (with index 0) */
        possibleAnswerLayoutsContainer.addView(wrapper.getParent(), 0);

        /* Get the EditText From the wrapper and request focus after add */
        wrapper.getAnswerText().requestFocus();
    }

    public void removePossibleAnswerLayout(PossibleAnswerLayoutWrapper wrapper) {
        possibleAnswerLayoutsContainer.removeView(wrapper.getParent());

        possibleAnswerLayoutWrappers.remove(wrapper);
    }



}
