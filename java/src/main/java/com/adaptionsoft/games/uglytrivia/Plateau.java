package com.adaptionsoft.games.uglytrivia;

import java.util.ArrayList;


public class Plateau {


    ArrayList<Integer> listOfCurrentPlayerPlace = new ArrayList();


    public Plateau(ArrayList<Player> listOfPlayer ) {


        for(int i = 0;  i < listOfPlayer.size() ; i ++){
            listOfCurrentPlayerPlace.add(0);
        }
    }

}
