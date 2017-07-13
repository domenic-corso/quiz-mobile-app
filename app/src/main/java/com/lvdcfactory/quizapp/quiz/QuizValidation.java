package com.lvdcfactory.quizapp.quiz;


import static com.lvdcfactory.quizapp.other.GeneralValidation.*;

/**
 * Created by Domenic on 13/07/2017.
 */

public class QuizValidation {

    private static final int MAX_DESC_CHARS = 100;
    private static final int MAX_TITLE_CHARS = 35;
    private static final int MAX_AUTHOR_CHARS = 70;

    public static boolean titleValid(String s) {
        if (tooLong(s, MAX_TITLE_CHARS)) return false;
        if (isWhiteSpace(s)) return false;

        return true;
    }

    public static boolean descriptionValid(String s) {
        if (tooLong(s, MAX_DESC_CHARS)) return false;
        if (isWhiteSpace(s)) return false;

        return true;
    }

    public static boolean authorValid(String s) {
        if (tooLong(s, MAX_AUTHOR_CHARS)) return false;
        if (isWhiteSpace(s)) return false;

        return true;
    }

}
