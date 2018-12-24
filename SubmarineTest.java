package battle;

import static org.junit.Assert.*;

import org.junit.Test;

public class SubmarineTest {

	@Test
	public void testGetShipType() {
		Submarine testBattleShip = new Submarine();
		assertEquals(testBattleShip.getShipType(), "submarine");
	}

	@Test
	public void testSubmarine() {
		Submarine testBattleShip = new Submarine();
		assertEquals(testBattleShip.getLength(), 1);
		assertEquals(testBattleShip.getHit()[0], false);
	}

}
