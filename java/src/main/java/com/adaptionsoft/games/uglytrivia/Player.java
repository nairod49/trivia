package com.adaptionsoft.games.uglytrivia;

public class Player {
    private  String name, pseudo;
    private int age;
    private int score;
    private int totalScore;
    int popint=0;
	int scienceint=0;
	int sportint=0;
	int rockint=0;
	int techint=0;
    public int nbCorrectAnswerConsecutive = 0;
    public int joker = 1;
    public int classement;

    public Player(String name, String pseudo, int age, int score){
        this.name = name;
        this.pseudo = pseudo;
        this.age = age;
        this.score = score;
        this.popint =0;
        this.scienceint=0;
        this.sportint=0;
        this.rockint=0;
        this.techint=0;
        this.classement=0;
    }

    public int getpop(){
        return this.popint;
    }
    public int getscience(){
        return this.scienceint;
    }
    public int getsport(){
        return this.sportint;
    }
    public int getrock(){
        return this.rockint;
    }

    public int gettec(){
        return this.techint;
    }
    public void incpop(){
        this.popint++;
    }
    public void incscience(){
        this.scienceint++;
    }
    public void incsport(){
        this.sportint++;
    }
    public void incrock(){
        this.rockint++;
    }
    public void inctech(){
        this.techint++;
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

    public void setClassement(int classement) {this.classement = classement; }

    public int getClassement() { return classement; }

    /**
     * Calcul le total du score
     * @return le total de score d'un joueur
     */
    public int scoreTotal (){
        this.totalScore = getScore() + 1;
        return this.totalScore;
    }
    public int getNbCorrectAnswerConsecutitve(){

        this.nbCorrectAnswerConsecutive++;
        return this.nbCorrectAnswerConsecutive;


    }
}
