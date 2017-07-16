package com.lvdcfactory.quizapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.lvdcfactory.quizapp.layout.PossibleAnswerLayoutWrapper;
import com.lvdcfactory.quizapp.layout.QuestionSummaryLayoutWrapper;
import com.lvdcfactory.quizapp.questions.Question;
import com.lvdcfactory.quizapp.quiz.Quiz;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

public class QuizSummary extends AppCompatActivity {

    private Quiz newlyCreatedQuiz;
    private Button btnStartTest, btnSaveTest;
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
        btnStartTest = (Button) findViewById(R.id.quizSummary_btnStartTest);
        btnSaveTest = (Button) findViewById(R.id.quizSummary_btnSave);
    }

    private void addListeners() {
        btnStartTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showStartTestActivity();
            }
        });

        btnSaveTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                exportQuiz();
                readQuiz();
            }
        });
    }

    private void exportQuiz() {
        // Should prompt user to enter a name
        String filename = "quiz";
        ObjectOutput output;

        try {
            output = new ObjectOutputStream(new FileOutputStream(getFilesDir() + File.separator+filename));
            output.writeObject(newlyCreatedQuiz);
            output.close();
            Toast toast = Toast.makeText(getApplicationContext(), "Quiz Saved", Toast.LENGTH_SHORT);
            toast.show();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void readQuiz() {
        ObjectInputStream input;
        String filename = "quiz";

        try {
            input = new ObjectInputStream(new FileInputStream(getFilesDir() + File.separator+filename));
            Quiz myQuiz = (Quiz) input.readObject();
            Log.v("Reading From File", "Quiz Questions="+myQuiz.getQuestions());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void showStartTestActivity() {
        Intent intent = new Intent(QuizSummary.this, PlayQuiz.class);
        intent.putExtra(CreateQuiz.QUIZ_EXTRA, newlyCreatedQuiz);
        startActivity(intent);
    }

    private void showQuestions() {
        QuestionSummaryLayoutWrapper wrapper;
        for (Question q : newlyCreatedQuiz.getQuestions()) {
            wrapper = new QuestionSummaryLayoutWrapper(this, q, questionsContainer);
            questionsContainer.addView(wrapper.getParent());
        }
    }
}
