package com.lvdcfactory.quizapp.questions;

import static com.lvdcfactory.quizapp.other.GeneralValidation.*;

/**
 * Created by Domenic on 13/07/2017.
 */

public class QuestionValidation {

    private static final int MAX_QUESTION_CHARS = 50;
    private static final int MAX_ANSWER_CHARS = 50;

    public static boolean questionValid(String s) {
        if (tooLong(s, MAX_QUESTION_CHARS)) return false;
        if (isWhiteSpace(s)) return false;

        return true;
    }

    public static boolean answerValid(String s) {
        if (tooLong(s, MAX_ANSWER_CHARS)) return false;
        if (isWhiteSpace(s)) return false;

        return true;
    }



}
