package com.lvdcfactory.quizapp.quiz;

import com.lvdcfactory.quizapp.questions.Question;

import java.util.List;

/**
 * Created by LU-VUONG on 10-Jul-17.
 */

public class Quiz {

    private String author;
    private String title;
    private String description;
    private List<Question> questions;

    /* Stored as seconds since Epoch */
    private int createdAt;

    public Quiz(String author, String title, String description) {
        this.author = author;
        this.title = title;
        this.description = description;

        // TODO Automatically find time since Epoch when instantiated
        this.createdAt = 0;
    }

    public String getAuthor(){
        return author;
    }

    public String getCreatedAt() {
        // TODO Convert Epoch time to string and return
        return "January 1, 1970";
    }

    public String getTitle(){
        return title;
    }

    public String getDescription(){
        return description;
    }

    public int numberOfQuestions(){
        return questions.size();
    }

    public void addQuestion(Question question) {
        questions.add(question);
    }

    public List<Question> getQuestions() {
        return questions;
    }
}
