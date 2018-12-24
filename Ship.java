package battle;



public class Ship {
	//the row that contains the bow (front part of the ship)
	int bowRow;
	//the column that contains the bow(front part of the ship)
	int bowCol;
	//length of ship
	int length;
	//a boolean that represents whether the ship is going to be place horizontally or vertically
	boolean horizontal;
	//an array of 4 booleans that indicate whether that part of the ship has been hit or not
	boolean[] hit = new boolean[4];

	/**
	 * @return length of ship
	 */
	public int getLength(){
		return this.length;
	}

	/**
	 * @return the row corresponding to the positon of bow
	 */
	public int getBowRow(){
		return bowRow;
	}

	/**
	 * @return the bow column location
	 */
	public int getBowColumn(){
		return bowCol;
	}

	/**
	 * @return hit array
	 */
	public boolean[] getHit(){
		return hit;
	}

	/**
	 * @return whether the ship is horizontal or not
	 */
	public boolean isHorizontal(){
		return horizontal;
	}

	/**
	 * each specific type of ship will override this method
	 * and return the corresponding ship type
	 */
	public String getShipType(){
		return "";
	}

	/**
	 * set the value of bowRow
	 */
	public void setBowRow(int row){
		bowRow = row;
	}

	/**
	 * set the value of bow column
	 */
	public void setBowColumn(int col){
		bowCol = col;
	}

	/**
	 * set the value of the instance variable horizontal
	 */
	public void setHorizontal(boolean horizontal){
		this.horizontal = horizontal;
	}
	
	/**
	 * In this method, we check whether we can set ship in this place
	 * Based on the given row, column, and orientation
	 * returns true if it is okay to put a ship of this length with its bow in this location
	 * false otherwise. The ship must not overlap another ship
	 * or touch another ship (vertically, horizontally, or diagonally
	 * and it must not beyond the array.
	 * @param row
	 * @param col
	 * @param horizontal
	 * @param ocean
	 * @return true or false
	 */
	public boolean okToPlaceShipAt(int row, int col, boolean horizontal, Ocean ocean){
		// check the start point of ship is within the map
		if(row < 0 || row > 9){
			return false;
		}
		if(col < 0 || col > 9){
			return false;
		}

		// check the body is within the map and whether it touches any other ship
		if(!horizontal){
			if(row + length > 9){
				return false;
			}
			for(int i = row - 1; i <= row + length; i++){
				for(int j = col - 1; j <= col + 1; j++){
					if(i >= 0 && i <= 9 && j >= 0 && j <= 9){
						if(ocean.isOccupied(i, j)){
							return false;
						}
					}
				}
			}
		}
		//horizontal direction check
		else{
			if(col + length > 9){
				return false;
			}
			for(int i = row - 1; i <= row + 1; i++){
				for(int j = col - 1; j <= col + length; j++){
					if(i >= 0 && i <= 9 && j >= 0 && j <= 9){
						if(ocean.isOccupied(i, j)){
							return false;
						}
					}
				}
			}
		}
		return true;
	}
	
	/**
	 * this method place ship at some position in ocean in some way
	 * @param row
	 * @param col
	 * @param hori
	 * @param ocean
	 */
	public void placeShipAt(int row, int col, boolean hori, Ocean ocean){
		this.bowRow = row;
		this.bowCol = col;
		this.horizontal = hori;
		//check if the ship is horizontal or not
		if(hori){
			for(int i = col; i < col + length; i++){
				ocean.ships[row][i] = this;
			}
		}
		else{
			for(int i = row; i < row + length; i++){
				ocean.ships[i][col] = this;
			}
		}
	}
	
	/**
	 * If a part of the ship occupies the given row and column, and the ship hasn’t been sunk,
	 * mark that part of the ship as “hit” (in the hit array, index 0 indicates the bow) and return true; otherwise return false.
	 * @param row
	 * @param col
	 * @return boolean
	 */
	public boolean shootAt(int row, int col){
		//if the ship is sunk
		if(this.isSunk()){
			return false;
		}
		//if the ship is horizontal
		if(horizontal){
			//not hit
			if(row != this.bowRow){
				return false;
			}
			//hit the ship body
			for(int i = bowCol; i < bowCol + length; i++){
				if(i == col){
					this.hit[i - bowCol] = true;
					return true;
				}
			}
			return false;
		}
		//if the ship is not horizontal
		else{
			//not hit
			if(col != this.bowCol){
				return false;
			}
			//hit the body
			for(int i = bowRow; i < bowRow + length; i++){
				if(i == row){
					this.hit[i - bowRow] = true;
					return true;
				}
			}
			return false;
		}
	}
	/**
	 * Return true if every part of the ship has been hit, false otherwise.
	 * @return boolean
	 */
	public boolean isSunk(){
		//all body should be hit then return true
		for(int i = 0; i < length; i++){
			if(!hit[i]){
				return false;
			}
		}
		return true;
	}
	
	/**
	 * This method returns 'x' if the ship has been sunk
	 * 'S' if it has not been sunk
	 * This method can be used to print out locations in the ocean that have been shot at 
	 * it should not be used to print locations that have not been shot at.
	 */
	@Override
	public String toString(){
		if(isSunk()){
			//sunk signal
			return "x";
		}
		//not sunk
		return "S";
	}
	
}
