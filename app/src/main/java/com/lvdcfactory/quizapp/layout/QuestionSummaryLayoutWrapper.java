package com.lvdcfactory.quizapp.layout;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.lvdcfactory.quizapp.R;
import com.lvdcfactory.quizapp.questions.BasicQuestion;
import com.lvdcfactory.quizapp.questions.MultipleChoiceAnswer;
import com.lvdcfactory.quizapp.questions.MultipleChoiceQuestion;
import com.lvdcfactory.quizapp.questions.Question;

/**
 * Created by Domenic on 13/07/2017.
 */

public class QuestionSummaryLayoutWrapper {

    private Context activityContext;
    private LayoutInflater inflater;

    private Question question;

    private LinearLayout parent;

    private TextView tvQuestion;
    private TextView tvAnswerTitle;

    public QuestionSummaryLayoutWrapper(Context context, Question question, ViewGroup questionsContainer) {
        this.activityContext = context;
        this.question = question;

        /* Create the parent view by inflating from XML */
        inflater = LayoutInflater.from(context);
        parent = (LinearLayout) inflater.inflate(R.layout.question_summary_layout, questionsContainer, false);

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
        insertAnswers();
    }

    private void insertAnswers() {
        TextView toAdd;

        if (question instanceof BasicQuestion) {
            toAdd = getAnswerTextView(question.getAnswerText(), true);
            parent.addView(toAdd);
            return;
        }

        if (question instanceof MultipleChoiceQuestion) {
            MultipleChoiceQuestion mcq = (MultipleChoiceQuestion) question;

            boolean isCorrectAnswer;
            for (MultipleChoiceAnswer a : mcq.getPossibleAnswers()) {
                isCorrectAnswer = mcq.getCorrectAnswer() == a;
                toAdd = getAnswerTextView(a.getAnswerText(), isCorrectAnswer);
                parent.addView(toAdd);
            }
        }
    }

    private TextView getAnswerTextView(String answerText, boolean isCorrectAnswer) {
        TextView textView = (TextView) inflater.inflate(R.layout.question_summary_answer_text_view, null);

        textView.setText(answerText);

        /* Assume answer is incorrect */
        int textColor = Color.RED;

        if (isCorrectAnswer) {
            textColor = Color.parseColor("#4CBF26");
        }

        textView.setTextColor(textColor);

        return textView;
    }

    public ViewGroup getParent() {
        return parent;
    }

    public TextView getTvQuestion() {
        return tvQuestion;
    }

    public TextView getTvAnswerTitle() {
        return tvAnswerTitle;
    }

}
