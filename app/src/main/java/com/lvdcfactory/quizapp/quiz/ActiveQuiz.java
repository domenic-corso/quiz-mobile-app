package com.lvdcfactory.quizapp.quiz;

import com.lvdcfactory.quizapp.questions.Question;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Domenic on 10/07/2017.
 */

public class ActiveQuiz {

    private Quiz quiz;
    private List<ActiveQuestion> activeQuestions;

    public ActiveQuiz(Quiz quiz) {
        activeQuestions = new ArrayList<ActiveQuestion>();

        this.quiz = quiz;

        for (Question q : quiz.getQuestions()) {
            activeQuestions.add(new ActiveQuestion(q));
        }
    }

}
