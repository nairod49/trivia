package com.adaptionsoft.games.uglytrivia;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class Game {

	ArrayList<Player> players = new ArrayList();




    int[] places = new int[6];
    int[] purses  = new int[6];
    boolean[] inPenaltyBox  = new boolean[6];
    public boolean Rock=false;

	int popint2=0;
	int scienceint2=0;
	int sportint2=0;
	int rockint2=0;
	int techint2=0;

	

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
			if (roll % 2 != 0) {
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
		if (currentCategory() == "Pop"){
			System.out.println(popQuestions.get(popint2).question);
		 popint2++;
		}
		if (currentCategory() == "Science"){
			System.out.println(scienceQuestions.get(scienceint2).question);
			scienceint2++;}
		if (currentCategory() == "Sports"){
			System.out.println(sportsQuestions.get(sportint2).question);
			sportint2++;}
		if (currentCategory() == "Rock" ){
			System.out.println(rockQuestions.get(rockint2).question);
			rockint2++;}
		if (currentCategory() == "Technologie" ){
			System.out.println(technologieQuestion.get(techint2).question);
			techint2++;	}

		}

	

	private String currentCategory() {
		if (places[currentPlayer] == 0) {players.get(currentPlayer).incpop();
			return "Pop";}
		if (places[currentPlayer] == 4) {players.get(currentPlayer).incpop();
			return "Pop";}
		if (places[currentPlayer] == 8) {players.get(currentPlayer).incpop();
			return "Pop";}
		if (places[currentPlayer] == 1) {players.get(currentPlayer).incscience();
			return "Science";}
		if (places[currentPlayer] == 5){players.get(currentPlayer).incscience();
			return "Science";}
		if (places[currentPlayer] == 9) {players.get(currentPlayer).incscience();
			return "Science";}
		if (places[currentPlayer] == 2) {players.get(currentPlayer).incsport();
			return "Sports";}
		if (places[currentPlayer] == 6) {players.get(currentPlayer).incsport();
			return "Sports";}
		if (places[currentPlayer] == 10) {players.get(currentPlayer).incsport();
			return "Sports";}
		
		if (Rock==true)
		{players.get(currentPlayer).incrock();
			return "Rock";}
		else
		{players.get(currentPlayer).inctech();
			return "Technologie";}

	}


	public boolean wasCorrectlyAnswered() {
		if (inPenaltyBox[currentPlayer]){
				currentPlayer++;
				if (currentPlayer == players.size()) currentPlayer = 0;
				return true;
		} else {

			this.gold = players.get(currentPlayer).getNbCorrectAnswerConsecutitve();
			System.out.println("Answer was corrent!!!!");
			purses[currentPlayer] = purses[currentPlayer] + this.gold;
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
		inPenaltyBox[currentPlayer] = true;
		this.gold = 0;
		players.get(currentPlayer).nbCorrectAnswerConsecutive = 0;
		currentPlayer++;
		if (currentPlayer == players.size()) currentPlayer = 0;
		return true;
	}

	public boolean useJoker(){
		boolean verif = false;
		if(players.get(currentPlayer).joker == 1) {
			Scanner sc = new Scanner(System.in);
			System.out.println("Voulez vous utiliser un joker (Y/N) :");
			String yesNo = sc.next();

			if (yesNo.equals("Y")) {
				verif = true;
				players.get(currentPlayer).joker = 0;
			}
		}
		return verif;
	}
	private boolean didPlayerWin() {
		if(purses[currentPlayer] == goldWin){
			
			affichage_categorie();
			
			return false;
		}
		else return true;
		
		
	}

	public void affichage_categorie(){
		int val= players.size();

		for (int i=0;i<val;i++){
			System.out.println(players.get(i).getName());
			System.out.println("Pop: "+ players.get(i).getpop());
			System.out.println("Science: "+ players.get(i).getscience());
			System.out.println("Sport: "+ players.get(i).getsport());
			System.out.println("Rock: "+ players.get(i).getrock());
			System.out.println("Tech: "+ players.get(i).gettec());
		}

	}



	public Boolean leave(){
		boolean finish = true;
		players.remove(currentPlayer);
		if (players.size()==1){
			finish = false;
		}
		return finish;
	}
}
