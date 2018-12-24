package battle;

public class BattleShip extends Ship{
	/**
	 * this is a constructor for battleship
	 * set the length as 4 and hit array
	 */
	public BattleShip(){
		length = 4;
		for(int i = 0; i < length; i++){
			hit[i] = false;
		}
	}
	
	/**
	 * return the string of battleship
	 */
	@Override
	public String getShipType(){
		return "battleship";
	}

}
