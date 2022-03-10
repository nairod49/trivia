package com.adaptionsoft.games.uglytrivia;
import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;
import java.util.LinkedList;


import static java.lang.Integer.parseInt;

public class Game {
    ArrayList players = new ArrayList();


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

	Category catRpzPlaceJoueurOuIdDonneParPerdnant;

	LinkedList<Question> popQuestions = new LinkedList();
	LinkedList<Question> scienceQuestions = new LinkedList();
	LinkedList<Question> sportsQuestions = new LinkedList();
	LinkedList<Question> rockQuestions = new LinkedList();
	LinkedList<Question> technologieQuestion = new LinkedList();

	boolean precedentJoueurAPerdu = false;

	Scanner sc;

	public Game(){

		sc = new Scanner(System.in);
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
	public boolean add(String playerName) {


	    players.add(playerName);
	    places[howManyPlayers()] = 0;
	    purses[howManyPlayers()] = 0;
	    inPenaltyBox[howManyPlayers()] = false;
	    
	    System.out.println(playerName + " was added");
	    System.out.println("They are player number " + players.size());
		return true;
	}
	
	public int howManyPlayers() {
		return players.size();
	}

	public void roll(int roll) {
		System.out.println(players.get(currentPlayer) + " is the current player");
		System.out.println("They have rolled a " + roll);
		
		if (inPenaltyBox[currentPlayer]) {
			if (roll % 2 != 0) {
				isGettingOutOfPenaltyBox = true;
				
				System.out.println(players.get(currentPlayer) + " is getting out of the penalty box");
				inPenaltyBox[currentPlayer]=false;
				places[currentPlayer] = places[currentPlayer] + roll;
				if (places[currentPlayer] > 12) places[currentPlayer] = places[currentPlayer] - 13;
				
				System.out.println(players.get(currentPlayer) 
						+ "'s new location is " 
						+ places[currentPlayer]);
				System.out.println("The category is " + retournerCategorieQuestion(places[currentPlayer]).typeCategory);
				askQuestion();
			} else {
				System.out.println(players.get(currentPlayer) + " is not getting out of the penalty box");
				isGettingOutOfPenaltyBox = false;
				}
			
		} else {
		
			places[currentPlayer] = places[currentPlayer] + roll;
			if (places[currentPlayer] > 11) places[currentPlayer] = places[currentPlayer] - 12;
			
			System.out.println(players.get(currentPlayer) 
					+ "'s new location is " 
					+ places[currentPlayer]);
			// if this.precedentJoueurAPerdu = true;
			//int x = entierPermettantDeChoisirLaQuestion
			if(precedentJoueurAPerdu){

				catRpzPlaceJoueurOuIdDonneParPerdnant = askLoser();
			}
			else{
				// catRpzPlaceJoueurOuIdDonneParPerdnant =
				catRpzPlaceJoueurOuIdDonneParPerdnant = retournerCategorieQuestion(places[currentPlayer]);
			}
			System.out.println("The category is " + catRpzPlaceJoueurOuIdDonneParPerdnant.typeCategory);
			// useless
			// askQuestion();
		}
		
	}



	private void  askQuestion() {

	}

	public Category askLoser(){

		Category categorie  = new Category(0, "");



			sc = new Scanner(System.in);
			String newLine = System.getProperty("line.separator");
			System.out.println("What is the kind of the next question?  " + newLine+ " pop: 1 "+ newLine +" science: 2 "+ newLine + " sport: 3 ");
			String str = sc.nextLine();

			int switchCase=Integer.parseInt(str);

			switch(switchCase) {

				case 1:
					categorie.setIdCategory(0);
					categorie.setTypeCategory("Pop");
					break;

				case 2:
					categorie.setIdCategory(1);
					categorie.setTypeCategory("Science");
					break;

				case 3:
					categorie.setIdCategory(2);
					categorie.setTypeCategory("Sport");
					break;


			}
			precedentJoueurAPerdu = false;


		return categorie;
	}

	public Category retournerCategorieQuestion(int EntierRepresentantLAPacedeLUser){

		Category categorie  = new Category(0, "");



		switch(EntierRepresentantLAPacedeLUser){

			case 0:
				categorie.setIdCategory(0);
				categorie.setTypeCategory("Pop");
				break;

			case 1:
				categorie.setIdCategory(1);
				categorie.setTypeCategory("Science");
				break;

			case 2:
				categorie.setIdCategory(2);
				categorie.setTypeCategory("Sport");
				break;

			case 3:
				categorie.setIdCategory(3);
				categorie.setTypeCategory("Pop");
				break;

			case 4:
				categorie.setIdCategory(4);
				categorie.setTypeCategory("Science");
				break;

			case 5:
				categorie.setIdCategory(5);
				categorie.setTypeCategory("Sport");
				break;
			case 6:
				categorie.setIdCategory(6);
				categorie.setTypeCategory("Pop");
				break;
			case 7:
				categorie.setIdCategory(7);
				categorie.setTypeCategory("Science");
				break;
			case 8:
				categorie.setIdCategory(8);
				categorie.setTypeCategory("Sport");
				break;
			case 9:
				categorie.setIdCategory(9);
				categorie.setTypeCategory("Pop");
				break;
			case 10:
				categorie.setIdCategory(10);
				categorie.setTypeCategory("Science");
				break;
			case 11:
				categorie.setIdCategory(11);
				categorie.setTypeCategory("Sport");
				break;
			default:
				System.out.println("place superieur à 11");
				break;
		}

		return  categorie;

	}


	public boolean wasCorrectlyAnswered() {
		if (inPenaltyBox[currentPlayer]){
				currentPlayer++;
				if (currentPlayer == players.size()) currentPlayer = 0;
				return true;
		} else {
		
			System.out.println("Answer was corrent!!!!");
			purses[currentPlayer]++;
			System.out.println(players.get(currentPlayer) 
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
		System.out.println(players.get(currentPlayer)+ " was sent to the penalty box");
		inPenaltyBox[currentPlayer] = true;
		
		currentPlayer++;
		if (currentPlayer == players.size()) currentPlayer = 0;

		this.precedentJoueurAPerdu = true;

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
