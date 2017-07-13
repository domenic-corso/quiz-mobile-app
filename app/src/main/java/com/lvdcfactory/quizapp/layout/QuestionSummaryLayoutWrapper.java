package com.lvdcfactory.quizapp.layout;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lvdcfactory.quizapp.R;
import com.lvdcfactory.quizapp.questions.BasicQuestion;
import com.lvdcfactory.quizapp.questions.MultipleChoiceQuestion;
import com.lvdcfactory.quizapp.questions.Question;

/**
 * Created by Domenic on 13/07/2017.
 */

public class QuestionSummaryLayoutWrapper {

    private Question question;

    private ViewGroup parent;

    private TextView tvQuestion;
    private TextView tvAnswerTitle;

    public QuestionSummaryLayoutWrapper(Context context, Question question) {
        this.question = question;

        /* Create the parent view by inflating from XML */
        LayoutInflater inflater = LayoutInflater.from(context);
        parent = (ViewGroup) inflater.inflate(R.layout.question_summary_layout, null);

        tvQuestion = (TextView) parent.getChildAt(0);
        tvAnswerTitle = (TextView) parent.getChildAt(1);

        tvQuestion.setText(question.getQuestionText());

        /* Answer title can either be 'Answer' or 'Answers',
         * assume basic question and 'Answer' */
        String answerTitle = "ANSWER";
        if (question instanceof MultipleChoiceQuestion) {
            answerTitle = "ANSWERS";
        }

        tvAnswerTitle.setText(answerTitle);
        insertQuestions();
    }

    private void insertQuestions() {

    }

}
