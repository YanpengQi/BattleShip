package battle;

import static org.junit.Assert.*;

import org.junit.Test;

public class DestroyerTest {

	@Test
	public void testGetShipType() {
		Destroyer testBattleShip = new Destroyer();
		assertEquals(testBattleShip.getShipType(), "destroyer");
	}

	@Test
	public void testDestroyer() {
		Destroyer testBattleShip = new Destroyer();
		assertEquals(testBattleShip.getLength(), 2);
		assertEquals(testBattleShip.getHit()[0], false);
		assertEquals(testBattleShip.getHit()[1], false);
	}

}
