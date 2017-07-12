package com.lvdcfactory.quizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.lvdcfactory.quizapp.quiz.Quiz;

public class AddQuestion extends AppCompatActivity {

    private Quiz newlyCreatedQuiz;

    private Button btnBasicQuestion, btnMultipleChoiceQuestion;
    private ViewGroup basicQuestionLayout, multipleChoiceQuestionLayout;

    private ViewGroup possibleAnswersContainer;
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
    }

    private void findViews() {
        btnBasicQuestion = (Button) findViewById(R.id.addQuestion_btnBasic);
        btnMultipleChoiceQuestion = (Button) findViewById(R.id.addQuestion_btnMultipleChoice);

        basicQuestionLayout = (ViewGroup) findViewById(R.id.addQuestion_layout_basicQuestion);
        multipleChoiceQuestionLayout = (ViewGroup) findViewById(R.id.addQuestion_layout_multipleChoice);

        btnAddPossibleAnswer = (Button) findViewById(R.id.addQuestion_btnAddPossibleAnswer);
        possibleAnswersContainer = (ViewGroup) findViewById(R.id.addQuestion_possibleAnswersContainer);
    }

    private void addEventListeners() {
        btnBasicQuestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showQuestionTypeLayout(basicQuestionLayout);
            }
        });

        btnMultipleChoiceQuestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showQuestionTypeLayout(multipleChoiceQuestionLayout);
            }
        });

        btnAddPossibleAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addPossibleAnswerLayout();
            }
        });
    }

    /* Switches between the user input modes for a basic question or a multiple choice question */
    private void showQuestionTypeLayout(ViewGroup layout) {
        basicQuestionLayout.setVisibility(View.GONE);
        multipleChoiceQuestionLayout.setVisibility(View.GONE);

        layout.setVisibility(View.VISIBLE);
    }

    private void addPossibleAnswerLayout() {
        /* Inflate a 'Possible Answer View' */
        LayoutInflater inflater = getLayoutInflater();
        View possibleAnswerView = inflater.inflate(R.layout.possible_answer_view, null);

        possibleAnswersContainer.addView(possibleAnswerView, 0);
    }
}
