package com.lvdcfactory.quizapp.questions;

/**
 * Created by Domenic on 10/07/2017.
 */

public interface Question {

    public final String SUFFIX = "?";

    String getQuestionText();
    String getAnswerText();
    boolean isCorrect(String givenAnswer);

}
