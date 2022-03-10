package com.adaptionsoft.games.uglytrivia;

import java.util.LinkedList;

public class Question {
    int idQuestion;
    Category questionCategory;

    public Question(int idQuestion, Category questionCategory) {
        this.idQuestion = idQuestion;
        this.questionCategory = questionCategory;
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
