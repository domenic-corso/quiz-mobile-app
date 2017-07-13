package com.lvdcfactory.quizapp.quiz;

/**
 * Created by Domenic on 13/07/2017.
 */

public class QuizValidation {

    private static final int MAX_DESC_CHARS = 100;
    private static final int MAX_TITLE_CHARS = 35;
    private static final int MAX_AUTHOR_CHARS = 70;

    private static boolean tooLong(String s, int l) {
        return (s.length() > l);
    }

    private static boolean isWhiteSpace(String s) {
        return (s.trim().length() == 0);
    }

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
