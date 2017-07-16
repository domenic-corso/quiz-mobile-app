package com.lvdcfactory.quizapp;

import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

public class PlayQuiz extends AppCompatActivity {

    TextView textViewQuestion;
    ViewGroup layoutBasicQuestion, layoutMultipleChoice;
    RadioGroup radioGroupMPA;
    Button btnSubmitQuestion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_quiz);

        findViews();
        addListeners();
    }

    private void addListeners() {
        btnSubmitQuestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    private void findViews() {
        textViewQuestion = (TextView) findViewById(R.id.playQuiz_textVIewQuestion);
        layoutBasicQuestion = (ViewGroup) findViewById(R.id.playQuiz_layoutBasicQuestion);
        layoutMultipleChoice = (ViewGroup) findViewById(R.id.playQuiz_layoutMultipleChoice);
        radioGroupMPA = (RadioGroup) findViewById(R.id.playQuiz_radioGroupMPA);
        btnSubmitQuestion = (Button) findViewById(R.id.playQuiz_btnSubmitAnswer);
    }

    class RadioCheckedListener implements RadioButton.OnCheckedChangeListener {

        @Override
        public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

        }
    }
}
