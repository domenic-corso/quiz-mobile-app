package com.lvdcfactory.quizapp.questions;

/**
 * Created by LU-VUONG on 10-Jul-17.
 */

public class BasicQuestion implements Question {

        private String answerText;
        private String questionText;

        final int ACCURACY_THRESHOLD = 70;

        public BasicQuestion(String questionText, String answerText) {
            this.questionText = questionText;
            this.answerText = answerText;
        }

        @Override
        public String toString(){
            return questionText + Question.SUFFIX;
        }

        @Override
        public String getQuestionText() {
            return questionText;
        }

        @Override
        public String getAnswerText(){
            return answerText;
        }

        @Override
        public boolean isCorrect(String givenAnswer){
            return true;
        }

        public int getAccuracy(String givenAnswer){
        return 0;
    }
}
