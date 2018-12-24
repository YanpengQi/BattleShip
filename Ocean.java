package battle;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Ocean {
	//use to quickly determine which ship is in any given location
	Ship[][] ships = new Ship[10][10];
	//use to record visited/hit positions
	boolean[][] visited = new boolean[10][10];
	//The total number of shots fired by the user.
	int shotsFired;
	/*
	 * The number of times a shot hit a ship
	 * if the user shoots the same part of a ship more than once
	 * every hit is counted, even though additional"hits" don't do the user any good.
	 */
	int hitCount;
	//The number of ships sunk (10 ships in all)
	int shipSunk;

	/**
	 * The constructor of Ocean
	 * Creates an "empty" ocean (fills the ships array with EmptySeas)
	 * Also initializes any game variables, such as how many shots have been fired
	 */
	public Ocean(){
		for(int i = 0; i < 10; i++){
			for(int j = 0; j < 10; j++){
				ships[i][j] = new EmptySea();
				visited[i][j] = false;
			}
		}
		shotsFired = 0;
		hitCount = 0;
		shipSunk = 0;
	}

	/**
	 * Place all ten ships randomly on the (initially empty) ocean.
	 * Place larger ships before smaller ones 
	 */
	public void pleaceAllShipRandomly(){
		//import java.util.Random to use random
		Random random = new Random();
		//create shipList
		List<Ship> shipList = new ArrayList<>();
		//put 10 ships into shipList
		shipList.add(new BattleShip());
		shipList.add(new Cruiser());
		shipList.add(new Cruiser());
		shipList.add(new Destroyer());
		shipList.add(new Destroyer());
		shipList.add(new Destroyer());
		shipList.add(new Submarine());
		shipList.add(new Submarine());
		shipList.add(new Submarine());
		shipList.add(new Submarine());

		//use for loop to put 10 ships into ocean
		for(Ship ship : shipList){
			int row;
			int col;
			boolean horizontal;
			do{
				//make each parameters random and suitable
				row = random.nextInt(10);
				col = random.nextInt(10);
				int hori = random.nextInt(2);
				horizontal = false;
				if(hori == 0){
					horizontal = true;
				}
			}
			//make sure the position and orientation is suitable
			while(!ship.okToPlaceShipAt(row, col, horizontal, this));
			//then place it
			ship.placeShipAt(row, col, horizontal, this);
		}

	}
	
	/**
	 * Returns true if the given location contains a ship
	 * false if it does not.
	 * @param row
	 * @param col
	 * @return boolean
	 */
	public boolean isOccupied(int row, int col){
		//judge if the point is empty sea
		if(this.ships[row][col].getShipType().equals("empty")){
			return false;
		}
		return true;
	}
	
	/**
	 * Returns true if the given location contains a 'real' ship, still afloat(not an EmptySea)  
	 * false if it does not. 
	 * this method updates the number of shots that have been fired and the number of hits
	 * @param row
	 * @param col
	 * @return boolean
	 */
	public boolean shootAt(int row, int col){
		//record into visited array
		visited[row][col] = true;
		//update all information
		this.shotsFired++;
		Ship hitShip = this.ships[row][col];
		if(hitShip.shootAt(row, col)){
			//update hitCount
			this.hitCount++;
			if(hitShip.isSunk()) {
				//update shipSunk
				shipSunk++;
			}
			return true;
		}
		return false;
		
	}
	
	/**
	 * @return the number of shots fired 
	 */
	public int getShotsFired(){
		return this.shotsFired;
	}
	
	/**
	 * Returns the number of hits recorded (in this game)
	 * All hits are counted, not just the first time a given square is hit.
	 */
	public int getHitCount(){
		return this.hitCount;
	}
	
	/**
	 * Returns the number of ships sunk
	 */
	public int getShipsSunk(){
		return this.shipSunk;
	}
	
	/**
	 * Returns true if all ships have been sunk, otherwise false
	 */
	public boolean isGameOver(){
		return this.shipSunk == 10;
	}
	
	/**
	 * Returns the 10x10 array of Ships
	 */
	public Ship[][] getShipArray(){
		return ships;
	}
	
	/**
	 * Prints the Ocean
	 * To aid the user, row numbers will be displayed along the left edge of the array
	 * column numbers should be displayed along the top
	 */
	public void print(){
		//print the first line to help user
		System.out.println("   0  1  2  3  4  5  6  7  8  9");
		for(int i = 0; i <= 9; i++){
			System.out.print(i + " ");
			for(int j = 0; j <= 9; j++){
				String infomation = ".";
				if(visited[i][j]){
					infomation = ships[i][j].toString();
				}
				System.out.print("[" + infomation + "]");
			}
			System.out.println("");
		}
	}
	
	


}
