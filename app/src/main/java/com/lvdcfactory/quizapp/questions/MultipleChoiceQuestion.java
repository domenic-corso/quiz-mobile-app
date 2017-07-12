package com.lvdcfactory.quizapp.questions;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Domenic on 10/07/2017.
 */

public class MultipleChoiceQuestion implements Question, java.io.Serializable {

    private String questionText;
    private List<MultipleChoiceAnswer> possibleAnswers;
    private MultipleChoiceAnswer correctAnswer;

    public MultipleChoiceQuestion(String questionText) {
        possibleAnswers = new ArrayList<MultipleChoiceAnswer>();

        this.questionText = questionText;
    }

    @Override
    public String getQuestionText() {
        return questionText;
    }

    @Override
    public String getAnswerText() {
        return correctAnswer.getAnswerText();
    }

    @Override
    public boolean isCorrect(String givenAnswer) {
        return false;
    }

    public MultipleChoiceAnswer getCorrectAnswer() {
        return correctAnswer;
    }

    public List<MultipleChoiceAnswer> getPossibleAnswers() {
        return possibleAnswers;
    }

    public void addAnswer(String answerText) {

    }

    public void addAnswer(MultipleChoiceAnswer answer) {
        possibleAnswers.add(answer);
    }

    public void setCorrectAnswer(MultipleChoiceAnswer answer) {
        // TODO Ensure the answer exists in possibleAnswers
        correctAnswer = answer;
    }
}
