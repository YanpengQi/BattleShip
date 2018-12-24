package battle;

import java.util.Scanner;

public class BattleshipGame {
	/**
	 * this method is used to make sure the input is correct
	 * @param input
	 * @return boolean
	 */
	public boolean checkInput(String input){
		//make sure only input 0-9
		if(input.length() != 1){
			return false;
		}
		char c = input.charAt(0);
		if(!Character.isDigit(c)){
			return false;
		}
		return true;
	}
	
	/**
	 * this is the main function which get everything together
	 */
	public void play(){
		//use scanner to scan input
		Scanner s = new Scanner(System.in);
		//set ocean and set ships
		Ocean ocean = new Ocean();
		ocean.pleaceAllShipRandomly();
		boolean playChoice = true;
		//only when player choose to not to play again, the game will stop
		while(playChoice) {
			while(!ocean.isGameOver()){

				ocean.print();
				System.out.println("Enter a row number 0-9");
				String rowInput = s.nextLine();
				//check the input format
				while(!checkInput(rowInput)){
					System.out.println("Wrong input, enter number 0-9");
					rowInput = s.nextLine();
				}
				int row = rowInput.charAt(0) - '0';
				System.out.println("Enter a column number 0-9");
				String colInput = s.nextLine();
				//check the input format
				while(!checkInput(colInput)){
					System.out.println("Wrong input, enter number 0-9");
					colInput = s.nextLine();
				}
				int col = colInput.charAt(0) - '0';
				
				//check if the point is occupied
				if(ocean.isOccupied(row, col)) {
					System.out.println("you hit");
				}else {
					System.out.println("you miss");
					
				}
				
				//if the ship is sunk, we do not need to show the message again
				if(ocean.ships[row][col].isSunk()) {
					ocean.shootAt(row, col);
				}else {
					ocean.shootAt(row, col);
					if(ocean.ships[row][col].isSunk()) {
						System.out.println("You just sank a " + ocean.ships[row][col].getShipType() + "!");
					}
				}
				
				
				//show the player his information each time
				System.out.println("Shots Fired: " + ocean.getShotsFired());
				System.out.println("Hit Count: " + ocean.getHitCount());
				System.out.println("Ships Sunk: " + ocean.getShipsSunk());
				
				
			}
			//player choose to continue or stop
			System.out.println("Game is Over! Your Score: " + ocean.getShotsFired() + "\nWould you like to play again?(input N to stop)");
			String choice = s.nextLine();
			if(choice.equals("N")) {
				playChoice = false;
			}
		}
		s.close();
	}
	
	public static void main(String[] args){
		BattleshipGame bs = new BattleshipGame();
		System.out.println("Welcome to The Game of Battleship\n");
		bs.play();
		System.out.println("Thanks for playing!");
		
		
		
		
	}
}
