package com.adaptionsoft.games.uglytrivia;

public class Player {
    private  String name, pseudo;
    private int age;
    private int score;
    private int totalScore;

    public Player(String name, String pseudo, int age, int score){
        this.name = name;
        this.pseudo = pseudo;
        this.age = age;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
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
