package battle;

public class Submarine extends Ship{
	/**
	 * this is a constructor for submarine
	 * set the length as 1 and hit array
	 */
	public Submarine(){
		length = 1;
		for(int i = 0; i < length; i++){
			hit[i] = false;
		}
	}
	
	/**
	 * return the string of submarine
	 */
	@Override
	public String getShipType(){
		return "submarine";
	}
}
