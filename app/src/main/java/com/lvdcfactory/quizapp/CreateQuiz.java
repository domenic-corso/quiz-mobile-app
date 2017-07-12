package com.lvdcfactory.quizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class CreateQuiz extends AppCompatActivity {

    private Button btnContinue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_quiz);

        findViews();

        btnContinue.setOnClickListener(new ContinueButtonClicked());

    }

    private void findViews() {
        btnContinue = (Button) findViewById(R.id.createQuiz_btnCreateQuizContinue);
    }

    class ContinueButtonClicked implements View.OnClickListener {
        public void onClick(View view){
            Log.i("Continue Button", "Continue Button Clicked");
            //startActivity(new Intent(CreateQuiz.this, AddQuestion.class));
        }
    }

}
