package com.adaptionsoft.games.uglytrivia;

import java.util.LinkedList;

public class Question {
    int idQuestion;
    Category questionCategory;
    String question;

    public Question(int idQuestion, Category questionCategory, String question) {
        this.idQuestion = idQuestion;
        this.questionCategory = questionCategory;
        this.question = question;
    }

    public int getIdQuestion() {
        return idQuestion;
    }

    public void setIdQuestion(int idQuestion) {
        this.idQuestion = idQuestion;
    }

    public Category getQuestionCategory() {
        return questionCategory;
    }

    public void setQuestionCategory(Category questionCategory) {
        this.questionCategory = questionCategory;
    }
}
