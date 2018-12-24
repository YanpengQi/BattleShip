package battle;

import static org.junit.Assert.*;

import org.junit.Test;

public class BattleShipTest {

	@Test
	public void testGetShipType() {
		BattleShip testBattleShip = new BattleShip();
		assertEquals(testBattleShip.getShipType(), "battleship");
	}

	@Test
	public void testBattleShip() {
		BattleShip testBattleShip = new BattleShip();
		assertEquals(testBattleShip.getLength(), 4);
		assertEquals(testBattleShip.getHit()[0], false);
		assertEquals(testBattleShip.getHit()[1], false);
		assertEquals(testBattleShip.getHit()[2], false);
		assertEquals(testBattleShip.getHit()[3], false);
	}

}
