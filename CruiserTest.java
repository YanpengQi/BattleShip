package battle;

import static org.junit.Assert.*;

import org.junit.Test;

public class CruiserTest {

	@Test
	public void testGetShipType() {
		Cruiser testBattleShip = new Cruiser();
		assertEquals(testBattleShip.getShipType(), "cruiser");
	}

	@Test
	public void testCruiser() {
		Cruiser testBattleShip = new Cruiser();
		assertEquals(testBattleShip.getLength(), 3);
		assertEquals(testBattleShip.getHit()[0], false);
		assertEquals(testBattleShip.getHit()[1], false);
		assertEquals(testBattleShip.getHit()[2], false);
	}

}
