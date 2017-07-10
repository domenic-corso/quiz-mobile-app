package com.lvdcfactory.quizapp.questions;

/**
 * Created by Domenic on 10/07/2017.
 */

public interface Question {

    public final String SUFFIX = "?";

    void setQuestion(String questionText);
    String getQuestion();
    String getAnswerText();
    boolean isCorrect(String givenAnswer);

}
