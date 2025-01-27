
package com.adaptionsoft.games.trivia.runner;
import java.util.Random;
import java.util.Scanner;

import com.adaptionsoft.games.uglytrivia.Game;
import com.adaptionsoft.games.uglytrivia.Player;

import static java.lang.Integer.parseInt;


public class GameRunner {

	private static boolean notAWinner;

	public static void main(String[] args) {
		String continuer;
		Game aGame = new Game();
		Player player1 = new Player("Chet","Chet",10,0);
		Player player2 = new Player("Chet 2","Chet 2",15,0);


		aGame.add(player1);
		aGame.add(player2);

		Scanner mode = new Scanner(System.in);
		System.out.println("Mode demonstration 1 Mode prod 2");
		if(mode.next().equals("1")) {
			if (aGame.verif()) {
				Random rand = new Random();
				do {
					aGame.roll(rand.nextInt(5) + 1);
					if (rand.nextInt(9) == 7) {
						//notAWinner = aGame.wrongAnswer();
					} else {
						notAWinner = aGame.wasCorrectlyAnswered();
					}

				} while (notAWinner);
			} else {
				System.out.println("Number of player is not correct");
			}
		}else{
			if(aGame.verif()){
				Random rand = new Random();
				do {
					aGame.roll(rand.nextInt(5) + 1);
					Scanner sc = new Scanner(System.in);
					System.out.println("Repondre 1 quitter 2");
					continuer = sc.next();
					if(!continuer.equals("2")) {
						if (rand.nextInt(9) == 7) {
							if (!aGame.useJoker()) {
								notAWinner = aGame.wrongAnswer();
							}
						} else {
							notAWinner = aGame.wasCorrectlyAnswered();
						}
					}else{
						notAWinner = aGame.leave();
					}
				} while (notAWinner);
			}else{
				System.out.println("Number of player is not correct");
			}
		}
		
	}
}
