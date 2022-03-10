package com.adaptionsoft.games.uglytrivia;

import java.util.ArrayList;


public class Plateau {

    ArrayList<Player>  listOfPlayer;
    ArrayList<Integer> listOfCurrentPlayerPlace = new ArrayList();


    public Plateau(ArrayList<Integer> listOfCruentPlayerPlace , ArrayList<Player> listOfPlayer ) {
        this.listOfCurrentPlayerPlace = listOfCruentPlayerPlace;
        for (int i= 0 ; i < this.listOfCurrentPlayerPlace.size() ; i ++){

            this.listOfCurrentPlayerPlace.set(i, 0);
        }


    }

}
