package com.lvdcfactory.quizapp.quiz;

import com.lvdcfactory.quizapp.questions.Question;

import java.util.List;
import java.util.Date;

/**
 * Created by LU-VUONG on 10-Jul-17.
 */

public class Quiz {

    private String author;
    private String title;
    private String description;
    private List<Question> questions;

    /* Stored as milliseconds since Epoch */
    private long createdAt;

    public Quiz(String author, String title, String description) {
        this.author = author;
        this.title = title;
        this.description = description;

        /* Finds number of milliseconds since Epoch */
        createdAt = new Date().getTime();
    }

    public String getAuthor(){
        return author;
    }

    public String getCreatedAt() {
        Date date = new Date(createdAt);
        return date.toString();
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
