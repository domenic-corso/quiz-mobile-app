package com.lvdcfactory.quizapp.questions;

/**
 * Created by LU-VUONG on 10-Jul-17.
 */

public class BasicQuestion implements Question {

        private String answerText;
        private String question;

        final int ACCURACY_THRESHOLD = 70;

        public BasicQuestion(String questionText) {
            setQuestion(questionText);
        }

        @Override
        public String getQuestion() {
            return question;
        }

        @Override
        public String getAnswerText(){
            return answerText;
        }

        public int getAccuracy(String givenAnswer){
            return 0;
        }

        @Override
        public void setQuestion(String question) {
            this.question = question;
        }

        public void setAnswerText(String answerText){
            this.answerText = answerText;
        }

        @Override
        public boolean isCorrect(String givenAnswer){
            return true;
        }

        public String toString(){
            return question + Question.SUFFIX;
        }
}
