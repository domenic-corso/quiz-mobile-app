package com.lvdcfactory.quizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lvdcfactory.quizapp.layout.QuestionSummaryLayoutWrapper;
import com.lvdcfactory.quizapp.questions.Question;
import com.lvdcfactory.quizapp.quiz.Quiz;

public class QuizSummary extends AppCompatActivity {

    private Quiz newlyCreatedQuiz;

    private TextView tvTitle, tvAuthor, tvDesc;
    private ViewGroup questionsContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_summary);

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
        addListeners();

        tvTitle.setText(newlyCreatedQuiz.getTitle());
        tvAuthor.setText(newlyCreatedQuiz.getAuthor());
        tvDesc.setText(newlyCreatedQuiz.getDescription());

        showQuestions();

    }

    private void findViews() {
        tvTitle = (TextView) findViewById(R.id.quizSummary_textViewTitle);
        tvAuthor = (TextView) findViewById(R.id.quizSummary_textViewAuthor);
        tvDesc = (TextView) findViewById(R.id.quizSummary_textViewDesc);
        questionsContainer = (ViewGroup) findViewById(R.id.quizSummary_questionsContainer);
    }

    private void addListeners() {

    }

    private void showQuestions() {
        QuestionSummaryLayoutWrapper wrapper;
        for (Question q : newlyCreatedQuiz.getQuestions()) {
            wrapper = new QuestionSummaryLayoutWrapper(this, q, questionsContainer);
            questionsContainer.addView(wrapper.getParent());
        }
    }
}
