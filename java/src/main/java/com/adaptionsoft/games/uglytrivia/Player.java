package com.adaptionsoft.games.uglytrivia;

public class Player {
    private String name;
    private int score;
    private int totalScore;
    private int correctAnswerConsecutive;

    public Player(String name, int score, int correctAnswerConsecutive){
        this.name = name;
        this.score = score;
        this.correctAnswerConsecutive = correctAnswerConsecutive;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getCorrectAnswerConsecutive() {
        return correctAnswerConsecutive;
    }

    public void setCorrectAnswerConsecutive(int correctAnswerConsecutive) {
        this.correctAnswerConsecutive = correctAnswerConsecutive;
    }

    /**
     * Calcul le total du score
     * @return le total de score d'un joueur
     */
    public int scoreTotal (){
        this.totalScore = getScore() + 1;
        return this.totalScore;
    }
}
