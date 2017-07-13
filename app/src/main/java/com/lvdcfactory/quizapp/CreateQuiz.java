package com.lvdcfactory.quizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.lvdcfactory.quizapp.quiz.Quiz;
import com.lvdcfactory.quizapp.quiz.QuizValidation;

public class CreateQuiz extends AppCompatActivity {

    public static final String QUIZ_EXTRA = "quiz_extra";
    private Button btnContinue;
    private EditText etQuizTitle, etQuizDescription, etQuizAuthor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_quiz);

        findViews();
        addListeners();

    }

    private void findViews() {
        btnContinue = (Button) findViewById(R.id.createQuiz_btnCreateQuizContinue);
        etQuizTitle = (EditText) findViewById(R.id.createQuiz_editTextTitle);
        etQuizDescription = (EditText)findViewById(R.id.createQuiz_editTextDesc);
        etQuizAuthor = (EditText) findViewById(R.id.createQuiz_editTextAuthor);
    }

    private void addListeners() {
        btnContinue.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if (userInputValid()) {
                    showAddQuestionActivity();
                }
            }
        });
    }

    /* Checks the input fields for author, title and description. Returns true/false depending
    if they meet validation requirements or not
     */
    private boolean userInputValid() {
        final String ERR_MSG = "Field cannot be empty.";

        /* User-inputted values */
        String author, title, desc;
        boolean authorValid, titleValid, descValid;

        author = etQuizAuthor.getText().toString();
        title = etQuizTitle.getText().toString();
        desc = etQuizDescription.getText().toString();

        authorValid = QuizValidation.authorValid(author);
        titleValid = QuizValidation.titleValid(title);
        descValid = QuizValidation.descriptionValid(desc);

        if (!authorValid) etQuizAuthor.setError(ERR_MSG);
        if (!titleValid) etQuizTitle.setError(ERR_MSG);
        if (!descValid) etQuizDescription.setError(ERR_MSG);

        return (authorValid && titleValid && descValid);

    }

    private void showAddQuestionActivity() {
        String author = etQuizAuthor.getText().toString();
        String title = etQuizTitle.getText().toString();
        String description = etQuizDescription.getText().toString();

        Quiz quiz = new Quiz(author, title, description);

        Intent intent = new Intent(CreateQuiz.this, AddQuestion.class);
        intent.putExtra(QUIZ_EXTRA, quiz);
        startActivity(intent);
    }

}
