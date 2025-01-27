package com.adaptionsoft.games.uglytrivia;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;
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
	int rapint2=0;
	int philint2=0;
	int litint2=0;
	int geoint2=0;
	int peopint2=0;


	

    int currentPlayer = 0;
    boolean isGettingOutOfPenaltyBox;
	int goldWin = 6;
	int gold;
	Category catRpzPlaceJoueurOuIdDonneParPerdnant;
	LinkedList<Question> popQuestions = new LinkedList();
	LinkedList<Question> scienceQuestions = new LinkedList();
	LinkedList<Question> sportsQuestions = new LinkedList();
	LinkedList<Question> rockQuestions = new LinkedList();
	LinkedList<Question> technologieQuestion = new LinkedList();
	LinkedList<Question> rapQuestions = new LinkedList();
	LinkedList<Question> philosophyQuestions = new LinkedList();
	LinkedList<Question> literratureQuestions = new LinkedList();
	LinkedList<Question> geographyQuestions = new LinkedList();
	LinkedList<Question> peopleQuestions = new LinkedList();
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

		for (int i = 0; i < 100; i++) {
			popQuestions.addLast(new Question(i,new Category(i,"Pop"),"Pop Question " + i));
			scienceQuestions.addLast(new Question(i,new Category(i,"Science"),"Science Question " + i));
			sportsQuestions.addLast(new Question(i,new Category(i,"Sports"),"Sports Question " + i));
			rapQuestions.addLast(new Question(i,new Category(i,"Rap"),"Rap Question " + i));
			philosophyQuestions.addLast(new Question(i,new Category(i,"Philosophy"),"Philosophy Question " + i));
			literratureQuestions.addLast(new Question(i,new Category(i,"Literrature"),"Literrature Question " + i));
			geographyQuestions.addLast(new Question(i,new Category(i,"Geography"),"Geography Question " + i));
			peopleQuestions.addLast(new Question(i,new Category(i,"People"),"People Question " + i));
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

			int rollPenaltyBox = rand.nextInt(players.get(currentPlayer).nbTurnInJail) + 1;

			System.out.println("roll : 1/" +players.get(currentPlayer).nbTurnInJail+1 );

			if (rollPenaltyBox == 1) {
				isGettingOutOfPenaltyBox = true;

				System.out.println(players.get(currentPlayer).getName() + " is getting out of the penalty box");
				inPenaltyBox[currentPlayer]=false;
				places[currentPlayer] = places[currentPlayer] + roll;
				if (places[currentPlayer] > 8) places[currentPlayer] = places[currentPlayer] - 9;
				
				System.out.println(players.get(currentPlayer).getName()
						+ "'s new location is " 
						+ places[currentPlayer]);
						System.out.println("The category is " + retournerCategorieQuestion(places[currentPlayer]).typeCategory);

			} else {
				System.out.println(players.get(currentPlayer).getName() + " is not getting out of the penalty box");
				isGettingOutOfPenaltyBox = false;
				//players.get(currentPlayer).getNbTurnInJail();
				}
			
		} else {
		
			places[currentPlayer] = places[currentPlayer] + roll;
			if (places[currentPlayer] > 8) places[currentPlayer] = places[currentPlayer] - 9;

			System.out.println(players.get(currentPlayer).getName()
					+ "'s new location is " 
					+ places[currentPlayer]);
				// if this.precedentJoueurAPerdu = true;
			//int x = entierPermettantDeChoisirLaQuestion
			//if(precedentJoueurAPerdu){

			//	catRpzPlaceJoueurOuIdDonneParPerdnant = askLoser();
		//	}
		//	else{
				// catRpzPlaceJoueurOuIdDonneParPerdnant =
				catRpzPlaceJoueurOuIdDonneParPerdnant = retournerCategorieQuestion(places[currentPlayer]);
		//	}
			System.out.println("The category is " + catRpzPlaceJoueurOuIdDonneParPerdnant.typeCategory);
			// useless
			askQuestion();
			}
			}

	private int verifQuestion(int categori){
		if(categori==50){
			return 0;
		}
		return categori;
	}
	private void askQuestion() {
		if (currentCategory() == "Pop"){
			System.out.println(popQuestions.get(popint2).question);
		 popint2++;
		 popint2 = verifQuestion(popint2);
		}
		if (currentCategory() == "Science"){
			System.out.println(scienceQuestions.get(scienceint2).question);
			scienceint2++;
			scienceint2 = verifQuestion(scienceint2);
		}
		if (currentCategory() == "Sports"){
			System.out.println(sportsQuestions.get(sportint2).question);
			sportint2++;
			sportint2 = verifQuestion(sportint2);
		}
		if (currentCategory() == "Rap"){
			System.out.println(rapQuestions.get(rapint2).question);
			rapint2++;
			rapint2 = verifQuestion(rapint2);
		}
		if (currentCategory() == "Philosophy"){
			System.out.println(philosophyQuestions.get(philint2).question);
			philint2++;
			philint2 = verifQuestion(philint2);
		}
		if (currentCategory() == "Literrature"){
			System.out.println(literratureQuestions.get(litint2).question);
			litint2++;
			litint2 = verifQuestion(litint2);
		}
		if (currentCategory() == "Geography"){
			System.out.println(geographyQuestions.get(geoint2).question);
			geoint2++;
			geoint2 = verifQuestion(geoint2);
		}
		if (currentCategory() == "People"){
			System.out.println(peopleQuestions.get(peopint2).question);
			peopint2++;
			peopint2 = verifQuestion(peopint2);
		}
		if (currentCategory() == "Rock" ){
			System.out.println(rockQuestions.get(rockint2).question);
			rockint2++;
			rockint2 = verifQuestion(rockint2);
		}
		if (currentCategory() == "Technologie" ){
			System.out.println(technologieQuestion.get(techint2).question);
			techint2++;
			techint2 = verifQuestion(techint2);
		}

		}




	private String currentCategory() {
		if (places[currentPlayer] == 0) {players.get(currentPlayer).incpop();
			return "Pop";}
		if (places[currentPlayer] == 1) {players.get(currentPlayer).incscience();
			return "Science";}
		if (places[currentPlayer] == 2) {players.get(currentPlayer).incsport();
			return "Sports";}
		if (places[currentPlayer] == 3) {players.get(currentPlayer).incRap();
			return "Rap";}
		if (places[currentPlayer] == 4){players.get(currentPlayer).incPhil();
			return "Philosophy";}
		if (places[currentPlayer] == 5) {players.get(currentPlayer).incLit();
			return "Literrature";}
		if (places[currentPlayer] == 6) {players.get(currentPlayer).incGeo();
			return "Geography";}
		if (places[currentPlayer] == 7) {players.get(currentPlayer).incPeop();
			return "People";}
		
		if (Rock==true)
		{players.get(currentPlayer).incrock();
			return "Rock";}
		else
		{players.get(currentPlayer).inctech();
			return "Technologie";}
		}
	public Category askLoser(){
	
			Category categorie  = new Category(0, "");
	
	
	
				sc = new Scanner(System.in);
				String newLine = System.getProperty("line.separator");
				System.out.println("What is the kind of the next question?  " + newLine+ " pop: 1 "+ newLine +" science: 2 "+ newLine + " sport: 3 " + newLine+ " Rap: 4 " + newLine + " Philosophy: 5 " + newLine + " Literrature: 6 " + newLine + "Geography: 7 " + newLine + " People: 8 ");
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

					case 4:
						categorie.setIdCategory(3);
						categorie.setTypeCategory("Rap");
						break;

					case 5:
						categorie.setIdCategory(4);
						categorie.setTypeCategory("Philosophy");
						break;

					case 6:
						categorie.setIdCategory(5);
						categorie.setTypeCategory("Literrature");
						break;

					case 7:
						categorie.setIdCategory(6);
						categorie.setTypeCategory("Geography");
						break;

					case 8:
						categorie.setIdCategory(7);
						categorie.setTypeCategory("People");
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
					players.get(currentPlayer).incpop();
					break;
	
				case 1:
					categorie.setIdCategory(1);
					categorie.setTypeCategory("Science");
					players.get(currentPlayer).incscience();
					break;
	
				case 2:
					categorie.setIdCategory(2);
					categorie.setTypeCategory("Sport");
					players.get(currentPlayer).incsport();
					break;

				case 3:
					categorie.setIdCategory(3);
					categorie.setTypeCategory("Rap");
					players.get(currentPlayer).incRap();
					break;

				case 4:
					categorie.setIdCategory(4);
					categorie.setTypeCategory("Philosophy");
					players.get(currentPlayer).incPhil();
					break;

				case 5:
					categorie.setIdCategory(5);
					categorie.setTypeCategory("Literrature");
					players.get(currentPlayer).incLit();
					break;

				case 6:
					categorie.setIdCategory(6);
					categorie.setTypeCategory("Geography");
					players.get(currentPlayer).incGeo();
					break;

				case 7:
					categorie.setIdCategory(7);
					categorie.setTypeCategory("People");
					players.get(currentPlayer).incPeop();
					break;
	
				case 8:
					categorie.setIdCategory(8);
					if(Rock==true){
					categorie.setTypeCategory("Rock");
					players.get(currentPlayer).incrock();}
					else{categorie.setTypeCategory("Technologie");
					players.get(currentPlayer).inctech();}

					break;

				default:
					System.out.println("place superieur à 8");
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

		inPenaltyBox[currentPlayer] = true;
		this.gold = 0;

		players.get(currentPlayer).nbCorrectAnswerConsecutive = 0;
		currentPlayer++;
		if (currentPlayer == players.size()) currentPlayer = 0;
		this.precedentJoueurAPerdu = true;
		return true;
	}

	private boolean didPlayerWin() {
		if(purses[currentPlayer] >= goldWin){
			
			affichage_categorie();
			
			return false;
		}
		else return true;
		
		
	}
	public void affichage_categorie(){
		int val= players.size();

		for (int i=0;i<val;i++){
			System.out.println("");
			System.out.println(players.get(i).getName());
			System.out.println("Pop: "+ players.get(i).getpop());
			System.out.println("Science: "+ players.get(i).getscience());
			System.out.println("Sport: "+ players.get(i).getsport());
			System.out.println("Rap: "+ players.get(i).getRap());
			System.out.println("Philosphy: "+ players.get(i).getPhilosophy());
			System.out.println("Literrature: "+ players.get(i).getLiterrature());
			System.out.println("Geography: "+ players.get(i).getGeography());
			System.out.println("People: "+ players.get(i).getPeople());
			System.out.println("Rock: "+ players.get(i).getrock());
			System.out.println("Tech: "+ players.get(i).gettec());
		}

	}



	public Boolean leave(){
		boolean finish = true;
		System.out.println(players.get(currentPlayer).getName() + " leave");
		players.remove(currentPlayer);
		if (players.size()==1){
			finish = false;
			for (Player player:  players
				 ) {
				System.out.println(player.getName() + " you win");
			}

		}
		return finish;
	}
	public String currentPlayer(){
		return players.get(currentPlayer).getName();
	}

	public boolean useJoker() {
		return true;
	}
}
