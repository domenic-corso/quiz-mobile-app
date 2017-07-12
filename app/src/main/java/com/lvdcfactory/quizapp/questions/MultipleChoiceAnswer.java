package com.lvdcfactory.quizapp.questions;

/**
 * Created by Domenic on 10/07/2017.
 */

public class MultipleChoiceAnswer implements java.io.Serializable {

    private String answerText;

    public MultipleChoiceAnswer(String answerText) {
        this.answerText = answerText;
    }

    public String getAnswerText() {
        return answerText;
    }

}
