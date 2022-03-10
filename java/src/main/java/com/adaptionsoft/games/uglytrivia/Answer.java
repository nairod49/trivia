package com.adaptionsoft.games.uglytrivia;

public class Answer {
    boolean isAnswerTrue;

    public Answer(boolean isAnswerTrue) {
        this.isAnswerTrue = isAnswerTrue;
    }

    public boolean isAnswerTrue() {
        return isAnswerTrue;
    }

    public void setAnswerTrue(boolean answerTrue) {
        isAnswerTrue = answerTrue;
    }
}
