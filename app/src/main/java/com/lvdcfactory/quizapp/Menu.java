package com.lvdcfactory.quizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.lvdcfactory.quizapp.questions.BasicQuestion;
import com.lvdcfactory.quizapp.questions.MultipleChoiceAnswer;
import com.lvdcfactory.quizapp.questions.MultipleChoiceQuestion;
import com.lvdcfactory.quizapp.quiz.Quiz;

public class Menu extends AppCompatActivity {

    Button btnCreateQuiz, btnViewYourQuizzes, btnDev;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        findViews();
        addListeners();
    }

    private void _testQuizSummary() {
        Quiz q = new Quiz("Domenic Corso", "My Quiz Title", "My Quiz Description");

        MultipleChoiceQuestion mp = new MultipleChoiceQuestion("What is Linux?");
        MultipleChoiceAnswer a1 = new MultipleChoiceAnswer("Programming Language");
        MultipleChoiceAnswer a2 = new MultipleChoiceAnswer("Mobile App");
        MultipleChoiceAnswer a3 = new MultipleChoiceAnswer("Operating System");

        mp.addAnswer(a1);
        mp.addAnswer(a2);
        mp.addAnswer(a3);

        mp.setCorrectAnswer(a3);

        q.addQuestion(mp);

        BasicQuestion bq = new BasicQuestion("What is the capital of Australia?", "Canberra");
        q.addQuestion(bq);

        Intent intent = new Intent(getBaseContext(), QuizSummary.class);
        intent.putExtra(CreateQuiz.QUIZ_EXTRA, q);

        startActivity(intent);
    }

    private void _testShowPlayQuiz() {
        startActivity(new Intent(getBaseContext(), PlayQuiz.class));
    }

    private void findViews() {
        btnCreateQuiz = (Button) findViewById(R.id.menu_btnCreateQuiz);
        btnViewYourQuizzes = (Button) findViewById(R.id.menu_btnViewYourQuizzes);
        btnDev = (Button) findViewById(R.id.btnDev);
    }

    private void addListeners() {

        btnCreateQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getBaseContext(), CreateQuiz.class));
            }
        });

        btnViewYourQuizzes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("Menu", "'View Your Quizzes' Button Clicked");
            }
        });

        btnDev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //_testQuizSummary();
                _testShowPlayQuiz();
            }
        });

    }

}
