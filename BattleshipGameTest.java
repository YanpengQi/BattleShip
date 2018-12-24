package battle;

import static org.junit.Assert.*;

import org.junit.Test;

public class BattleshipGameTest {

	/**
	 * this is a method I created to check the input format
	 */
	@Test
	public void testCheckInput() {
		BattleshipGame testBattleGame = new BattleshipGame();

		//test for 1-9
		assertTrue(testBattleGame.checkInput("1"));
		assertTrue(testBattleGame.checkInput("5"));
		
		//test for other numbers
		assertFalse(testBattleGame.checkInput("10"));
		
		//test for characters
		assertFalse(testBattleGame.checkInput("a"));
		assertFalse(testBattleGame.checkInput("T"));
		assertFalse(testBattleGame.checkInput("Y"));
		
		//test for weird cases
		assertFalse(testBattleGame.checkInput("10a"));
		assertFalse(testBattleGame.checkInput(" "));
	}

}
