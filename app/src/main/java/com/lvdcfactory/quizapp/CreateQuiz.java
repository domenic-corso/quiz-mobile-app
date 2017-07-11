package com.lvdcfactory.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class CreateQuiz extends AppCompatActivity {

    Button btnContinue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_quiz);

        findViews();
        addListeners();
    }

    private void findViews() {
        btnContinue = (Button) findViewById(R.id.createQuiz_btnCreateQuizContinue);
    }

    private void addListeners(){
        btnContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("CreateQuiz", "Continue Button Clicked");
            }
        });
    }
}
