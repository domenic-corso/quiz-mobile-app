package com.lvdcfactory.quizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.lvdcfactory.quizapp.quiz.Quiz;

public class CreateQuiz extends AppCompatActivity {

    public static final String QUIZ_EXTRA = "quiz_extra";
    private Button btnContinue;
    private EditText quizTitle, quizDescription, quizAuthor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_quiz);

        findViews();
        addListeners();

    }

    private void findViews() {
        btnContinue = (Button) findViewById(R.id.createQuiz_btnCreateQuizContinue);
        quizTitle = (EditText) findViewById(R.id.createQuiz_editTextTitle);
        quizDescription = (EditText)findViewById(R.id.createQuiz_editTextDesc);
        quizAuthor = (EditText) findViewById(R.id.createQuiz_editTextAuthor);
    }

    private void addListeners() {
        btnContinue.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                showAddQuestionActivity();
            }
        });
    }

    private void showAddQuestionActivity() {
        if(isEditTextValid(quizTitle) && isEditTextValid(quizDescription) && isEditTextValid(quizAuthor)) {
            String author = quizAuthor.getText().toString();
            String title = quizTitle.getText().toString();
            String description = quizDescription.getText().toString();

            Quiz quiz = new Quiz(author, title, description);

            Intent intent = new Intent(CreateQuiz.this, AddQuestion.class);
            intent.putExtra(QUIZ_EXTRA, quiz);
            startActivity(intent);
        }
    }

    private boolean isEditTextValid(EditText input){
        if(input.getText().toString().trim().length() == 0){
            input.setError("Field cannot be empty");
            return false;
        }else{
            return true;
        }
    }
}
