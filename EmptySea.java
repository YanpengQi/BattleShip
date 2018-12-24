package battle;

public class EmptySea extends Ship{
	/**
	 * This constructor sets the inherited length variable to 1
	 */
	public EmptySea(){
		length = 1;
	}
	
	/**
	 * this method override shootAt(int row, int column) from ship
	 * always return false to indicate that nothing was hit
	 */
	@Override
	public boolean shootAt(int row, int col){
		hit[0] = true;
		return false;
	}
	
	/**
	 * This method overrides isSunk() that is inherited from Ship
	 * always returns false to indicate that you didn’t sink anything
	 */
	@Override
	public boolean isSunk(){
		return false;
	}
	
	/**
	 * 
	 */
	@Override
	public String getShipType(){
		return "empty";
	}
	
	/**
	 * Returns a single-character String to use in the Ocean's print method
	 * if this point is hit, return "-" to indicate that this point is hit
	 * otherwise return"."
	 */
	@Override
	public String toString(){
		//hit signal
		if(hit[0]){
			return "-";
		}
		//not hit
		return ".";
	}
	
	
}
