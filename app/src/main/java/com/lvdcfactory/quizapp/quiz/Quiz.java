package com.lvdcfactory.quizapp.quiz;

import com.lvdcfactory.quizapp.questions.Question;

import java.util.List;

/**
 * Created by LU-VUONG on 10-Jul-17.
 */

public class Quiz {

    private String author;
    private String createdAt;
    private String title;
    private String description;
    private List<Question> questions;

    public Quiz(String author, String createdAt, String title, String description) {
        this.author = author;
        this.createdAt = createdAt;
        this.title = title;
        this.description = description;
    }

    public String getAuthor(){
        return author;
    }

    public String getCreatedAt() {
        return createdAt;
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
