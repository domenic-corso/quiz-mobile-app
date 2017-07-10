package com.lvdcfactory.quizapp.quiz;

import com.lvdcfactory.quizapp.questions.Question;

/**
 * Created by Domenic on 10/07/2017.
 */

public class ActiveQuestion {

    private Question question;
    private boolean answered;
    private boolean correct;

    public ActiveQuestion(Question question) {
        answered = false;
        correct = false;
    }

    public boolean isAnswered() {
        return answered;
    }

    public boolean isCorrect() {
        return correct;
    }

    public void setAnswered(boolean b) {
        answered = b;
    }

    public void setCorrect(boolean b) {
        correct = b;
    }

}
