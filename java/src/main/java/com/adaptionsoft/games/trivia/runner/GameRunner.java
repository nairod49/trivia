
package com.adaptionsoft.games.trivia.runner;
import java.util.Random;

import com.adaptionsoft.games.uglytrivia.Game;
import com.adaptionsoft.games.uglytrivia.Player;


public class GameRunner {

	private static boolean notAWinner;

	public static void main(String[] args) {
		Game aGame = new Game();
		Player player1 = new Player("Chet","Chet",10,0);
		Player player2 = new Player("Chet 2","Chet 2",15,0);


		aGame.add(player1);
		aGame.add(player2);
		if(aGame.verif()){
			Random rand = new Random();
			do {
				aGame.roll(rand.nextInt(5) + 1);

				if (rand.nextInt(9) == 7) {
					notAWinner = aGame.wrongAnswer();
				} else {
					notAWinner = aGame.wasCorrectlyAnswered();
				}
			} while (notAWinner);
		}else{
			System.out.println("Number of player is not correct");
		}
		
	}
}
