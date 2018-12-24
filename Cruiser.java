package battle;


public class Cruiser extends Ship{
	/**
	 * this is a constructor for cruiser
	 * set the length as 3 and hit array
	 */
	public Cruiser(){
		length = 3;
		for(int i = 0; i < length; i++){
			hit[i] = false;
		}
	}
	
	/**
	 * return the string of cruiser
	 */
	@Override
	public String getShipType(){
		return "cruiser";
	}
}
