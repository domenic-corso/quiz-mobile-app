package com.lvdcfactory.quizapp.other;

/**
 * Created by Domenic on 13/07/2017.
 */

public class GeneralValidation {

    /* TODO QuestionValidation and QuizValidation should return an Enum type describing
     the outcome of their validation, such as TOO_LONG, EMPTY, VALID, that way
     error messages can make use of it, passing the enum value into a method defined
     here which will return the error message*/

    public static boolean tooLong(String s, int l) {
        return (s.length() > l);
    }

    public static boolean isWhiteSpace(String s) {
        return (s.trim().length() == 0);
    }

}
