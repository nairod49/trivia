package com.adaptionsoft.games.uglytrivia;
import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;
import java.util.LinkedList;


import static java.lang.Integer.parseInt;

public class Game {

	ArrayList<Player> players = new ArrayList();

    int[] places = new int[6];
    int[] purses  = new int[6];
    boolean[] inPenaltyBox  = new boolean[6];
    public boolean Rock=false;

	int popint=0;
	int scienceint=0;
	int sportint=0;
	int rockint=0;
	int techint=0;
    
    int currentPlayer = 0;
    boolean isGettingOutOfPenaltyBox;
	int goldWin = 6;
	int gold;

	LinkedList<Question> popQuestions = new LinkedList();
	LinkedList<Question> scienceQuestions = new LinkedList();
	LinkedList<Question> sportsQuestions = new LinkedList();
	LinkedList<Question> rockQuestions = new LinkedList();
	LinkedList<Question> technologieQuestion = new LinkedList();

	public Game(){

		Scanner sc = new Scanner(System.in);
		String str = "";
		do {
			sc = new Scanner(System.in);
			if (goldWin<6){
				System.out.println("more 6 please? ");
			}else {
				System.out.println("What is objective gold for win ? ");
			}
			str = sc.nextLine();
			goldWin = parseInt(str);
		}while(goldWin<6);


		sc = new Scanner(System.in);
		System.out.println("Voulez vous échangé la catégorie rock par une catégorie technologie ?(Y/N)");
		str = sc.nextLine();
		Rock = str.equalsIgnoreCase("n" ) ? true : false;

		for (int i = 0; i < 50; i++) {
			popQuestions.addLast(new Question(i,new Category(i,"Pop"),"Pop Question " + i));
			scienceQuestions.addLast(new Question(i,new Category(i,"Science"),"Science Question " + i));
			sportsQuestions.addLast(new Question(i,new Category(i,"Sports"),"Sports Question " + i));
			if(Rock==true)
				rockQuestions.addLast(new Question(i,new Category(i,"Rocks"),"Rocks Question " + i));
			else
				technologieQuestion.addLast(new Question(i,new Category(i,"Technologies"),"Technologies Question " +i));
		}
	}
	public boolean isPlayable() {
		return (howManyPlayers() >= 2);
	}
	public boolean verif() {
		boolean numberPlayerIsGood = true;

		if(howManyPlayers()<2 || howManyPlayers()>6){
			numberPlayerIsGood = false;
		}

		return numberPlayerIsGood;
	}

	public boolean add(Player player) {
	    players.add(player);
	    places[howManyPlayers()] = 0;
	    purses[howManyPlayers()] = 0;
	    inPenaltyBox[howManyPlayers()] = false;
	    
	    System.out.println(player.getName().toString()
				+ " was added");
	    System.out.println("They are player number " + players.size());
		return true;
	}
	
	public int howManyPlayers() {
		return players.size();
	}

	public void roll(int roll) {
		System.out.println(players.get(currentPlayer).getName() + " is the current player");
		System.out.println("They have rolled a " + roll);
		
		if (inPenaltyBox[currentPlayer]) {
			Random rand = new Random();

			System.out.println("nb turn : " + players.get(currentPlayer).nbTurnInJail);


			double limitRandom = players.get(currentPlayer).nbTurnInJail * (players.get(currentPlayer).nbTurnInJailConsecutive * 10.0 / 100.0);
			double start = 0;
			double end = limitRandom;
			double random = new Random().nextDouble();
			double rollPenaltyBox = start + (random * (end - start));
			System.out.println("limitRandom : " + limitRandom);
			System.out.println("rollPenaltyBox : " + rollPenaltyBox);

			//double rollPenaltyBox = rand.nextDouble(limitRandom) + 1.0;


			System.out.println("roll : " + rollPenaltyBox);

			if (rollPenaltyBox == 1) {
				isGettingOutOfPenaltyBox = true;

				System.out.println(players.get(currentPlayer).getName() + " is getting out of the penalty box");
				inPenaltyBox[currentPlayer]=false;
				places[currentPlayer] = places[currentPlayer] + roll;
				if (places[currentPlayer] > 12) places[currentPlayer] = places[currentPlayer] - 13;
				
				System.out.println(players.get(currentPlayer).getName()
						+ "'s new location is " 
						+ places[currentPlayer]);
				System.out.println("The category is " + currentCategory());
				askQuestion();
			} else {
				System.out.println(players.get(currentPlayer).getName() + " is not getting out of the penalty box");
				isGettingOutOfPenaltyBox = false;
				players.get(currentPlayer).getNbTurnInJail();
				players.get(currentPlayer).getNbTurnInJailConsecutive();

				}
			
		} else {
		
			places[currentPlayer] = places[currentPlayer] + roll;
			if (places[currentPlayer] > 11) places[currentPlayer] = places[currentPlayer] - 12;

			System.out.println(players.get(currentPlayer).getName()
					+ "'s new location is " 
					+ places[currentPlayer]);
			System.out.println("The category is " + currentCategory());
			askQuestion();
		}
		
	}

	private void askQuestion() {
		if (currentCategory() == "Pop")
			System.out.println(popQuestions.get(0).question);
		if (currentCategory() == "Science")
			System.out.println(scienceQuestions.get(0).question);
		if (currentCategory() == "Sports")
			System.out.println(sportsQuestions.get(0).question);
		if (currentCategory() == "Rock" )
			System.out.println(rockQuestions.get(0).question);
		if (currentCategory() == "Technologie" )
			System.out.println(technologieQuestion.get(0).question);
		}
	
	private String currentCategory() {
		if (places[currentPlayer] == 0) {popint++;
			return "Pop";}
		if (places[currentPlayer] == 4) {popint++;
			return "Pop";}
		if (places[currentPlayer] == 8) {popint++;
			return "Pop";}
		if (places[currentPlayer] == 1) {scienceint++;
			return "Science";}
		if (places[currentPlayer] == 5){scienceint++;
			return "Science";}
		if (places[currentPlayer] == 9) {scienceint++;
			return "Science";}
		if (places[currentPlayer] == 2) {sportint++;
			return "Sports";}
		if (places[currentPlayer] == 6) {sportint++;
			return "Sports";}
		if (places[currentPlayer] == 10) {sportint++;
			return "Sports";}
		
		if (Rock==true)
		{rockint++;
			return "Rock";}
		else
		{techint++;
			return "Technologie";}
	}

	public boolean wasCorrectlyAnswered() {
		if (inPenaltyBox[currentPlayer]){
				currentPlayer++;
				if (currentPlayer == players.size()) currentPlayer = 0;
				return true;
		} else {

			this.gold = players.get(currentPlayer).getNbCorrectAnswerConsecutitve();
			System.out.println("Answer was correct!!!!");
			purses[currentPlayer] = 1 + gold;
			System.out.println(players.get(currentPlayer).getName()
					+ " now has "
					+ purses[currentPlayer]
					+ " Gold Coins.");
			
			boolean winner = didPlayerWin();
			currentPlayer++;
			if (currentPlayer == players.size()) currentPlayer = 0;
			
			return winner;
		}
	}
	
	public boolean wrongAnswer(){
		System.out.println("Question was incorrectly answered");
		System.out.println(players.get(currentPlayer).getName()+ " was sent to the penalty box");

		players.get(currentPlayer).getNbTurnInJail();
		players.get(currentPlayer).getNbTurnInJailConsecutive();

		inPenaltyBox[currentPlayer] = true;
		this.gold = 0;

		players.get(currentPlayer).nbCorrectAnswerConsecutive = 0;
		currentPlayer++;
		if (currentPlayer == players.size()) currentPlayer = 0;
		return true;
	}

	private boolean didPlayerWin() {
		System.out.println("pop a été choisi "+popint);
		System.out.println("science a été choisi "+scienceint);
		System.out.println("sport a été choisi "+sportint);
		if (Rock==true){
			System.out.println("rock a été choisi "+rockint);
		}
		else
		System.out.println("technologie a été choisi "+techint);
		
		return !(purses[currentPlayer] == goldWin);
	}
}
