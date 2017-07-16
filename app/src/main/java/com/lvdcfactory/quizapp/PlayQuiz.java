package com.lvdcfactory.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;

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
        // TODO add listeners for submit button
    }

    private void findViews() {
        // TODO find these views
    }

    // TODO create event listener for the MPA radio buttons (inner class)
}
