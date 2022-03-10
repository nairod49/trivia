package com.adaptionsoft.games.uglytrivia;

import java.util.ArrayList;


public class Plateau {

    ArrayList<Player>  listOfPlayer;
    ArrayList<Integer> listOfCurrentPlayerPlace = new ArrayList();


    public Plateau(ArrayList<Integer> listOfCruentPlayerPlace , ArrayList<Player> listOfPlayer ) {
        //this.listOfCurrentPlayerPlace.size() = listOfCruentPlayerPlace.size();

        for(int i = 0;  i < listOfPlayer.size() ; i ++){
            listOfCurrentPlayerPlace.add(0);
        }
    }

}
