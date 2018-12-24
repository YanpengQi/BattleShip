package battle;

public class Destroyer extends Ship{
	/**
	 * this is a constructor for destroyer
	 * set the length as 2 and hit array
	 */
	public Destroyer(){
		length = 2;
		for(int i = 0; i < length; i++){
			hit[i] = false;
		}
	}
	
	/**
	 * return the string of destroyer
	 */
	@Override
	public String getShipType(){
		return "destroyer";
	}
}
