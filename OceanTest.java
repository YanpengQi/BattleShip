package battle;

import static org.junit.Assert.*;

import org.junit.Test;

public class OceanTest {
	
	Ocean testOcean;

	@Test
	public void testOcean() {
		testOcean = new Ocean();
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				assertTrue(testOcean.ships[i][j].toString().equals("."));
				assertEquals(testOcean.ships[i][j].getShipType(), "empty");
				assertEquals(testOcean.ships[i][j].getLength(), 1);
				assertEquals(testOcean.ships[i][j].isSunk(), false);
			}
			
		}
		assertEquals(testOcean.shotsFired, 0);
		assertEquals(testOcean.hitCount, 0);
		assertEquals(testOcean.shipSunk, 0);
	}

	@Test
	public void testPleaceAllShipRandomly() {
		testOcean = new Ocean();
		testOcean.pleaceAllShipRandomly();
		
	}

	@Test
	public void testIsOccupied() {
		//test for no ship
		testOcean = new Ocean();
		assertFalse(testOcean.isOccupied(2, 5));
		
		//test for occupied conditions
		Ship testShip = new BattleShip();
		testShip.placeShipAt(3, 4, true, testOcean);
		assertTrue(testOcean.isOccupied(3, 4));
		assertTrue(testOcean.isOccupied(3, 5));
		assertTrue(testOcean.isOccupied(3, 6));
		assertTrue(testOcean.isOccupied(3, 7));
	}

	@Test
	public void testShootAt() {
		//initialize ocean and set ship
		testOcean = new Ocean();
		Ship testShip = new BattleShip();
		testShip.placeShipAt(3, 4, true, testOcean);
		assertEquals(testOcean.shotsFired, 0);
		assertEquals(testOcean.hitCount, 0);
		assertEquals(testOcean.shipSunk, 0);
		assertEquals(testOcean.visited[3][4], false);
		
		//miss shoot
		boolean shotResult = testOcean.shootAt(5, 4);
		assertEquals(testOcean.shotsFired, 1);
		assertEquals(testOcean.hitCount, 0);
		assertEquals(testOcean.shipSunk, 0);
		assertEquals(testOcean.visited[3][4], false);
		assertEquals(shotResult, false);
		assertFalse(testOcean.ships[3][4].hit[0]);
		
		//shoot the body
		boolean shotResult1 = testOcean.shootAt(3, 4);
		assertEquals(testOcean.shotsFired, 2);
		assertEquals(testOcean.hitCount, 1);
		assertEquals(testOcean.shipSunk, 0);
		assertEquals(testOcean.visited[3][4], true);
		assertEquals(shotResult1, true);
		assertTrue(testOcean.ships[3][4].hit[0]);
		
		//shoot and sunk the ship
		testOcean.shootAt(3, 5);
		testOcean.shootAt(3, 6);
		boolean shotResult2 = testOcean.shootAt(3, 7);
		assertEquals(testOcean.shotsFired, 5);
		assertEquals(testOcean.hitCount, 4);
		assertEquals(testOcean.shipSunk, 1);
		assertEquals(testOcean.visited[3][4], true);
		assertEquals(shotResult2, true);
		assertTrue(testOcean.ships[3][4].hit[3]);
	}

	@Test
	public void testGetShotsFired() {
		//test for general cases
		testOcean = new Ocean();
		testOcean.shootAt(1, 2);
		testOcean.shootAt(2, 2);
		testOcean.shootAt(3, 2);
		assertEquals(testOcean.getShotsFired(), 3);
		
		//test for shooting at one point
		testOcean = new Ocean();
		testOcean.shootAt(1, 2);
		testOcean.shootAt(1, 2);
		testOcean.shootAt(1, 2);
		assertEquals(testOcean.getShotsFired(), 3);
		
		//test for no fire
		testOcean = new Ocean();
		assertEquals(testOcean.getShotsFired(), 0);
	}

	@Test
	public void testGetHitCount() {
		testOcean = new Ocean();
		Ship testShip = new BattleShip();
		testShip.placeShipAt(3, 4, true, testOcean);
		
		//test for no fire
		assertEquals(testOcean.getHitCount(), 0);
		
		//test for general caes
		testOcean.shootAt(3, 4);
		assertEquals(testOcean.getHitCount(), 1);
		testOcean.shootAt(3, 5);
		assertEquals(testOcean.getHitCount(), 2);
		testOcean.shootAt(3, 6);
		assertEquals(testOcean.getHitCount(), 3);
		
		//test for sunk ship
		testOcean.shootAt(3, 7);
		assertEquals(testOcean.getHitCount(), 4);
		
		//test for shooting at the same point
		testOcean.shootAt(3, 6);
		assertEquals(testOcean.getHitCount(), 4);
		testOcean.shootAt(3, 6);
		assertEquals(testOcean.getHitCount(), 4);
	}

	@Test
	public void testGetShipsSunk() {
		testOcean = new Ocean();
		Ship testShip = new BattleShip();
		testShip.placeShipAt(3, 4, true, testOcean);
		
		//test for no fire
		assertEquals(testOcean.getShipsSunk(), 0);
		
		//test for general caes
		testOcean.shootAt(3, 4);
		assertEquals(testOcean.getShipsSunk(), 0);
		testOcean.shootAt(3, 5);
		assertEquals(testOcean.getShipsSunk(), 0);
		testOcean.shootAt(3, 6);
		assertEquals(testOcean.getShipsSunk(), 0);
		testOcean.shootAt(3, 7);
		assertEquals(testOcean.getShipsSunk(), 1);
		
		
		//test for shooting at the same point
		testOcean.shootAt(3, 6);
		assertEquals(testOcean.getShipsSunk(), 1);
		testOcean.shootAt(3, 6);
		assertEquals(testOcean.getShipsSunk(), 1);
	}

	@Test
	public void testIsGameOver() {
		testOcean = new Ocean();
		//test for game start
		assertFalse(testOcean.isGameOver());
		
		//test for during game process
		testOcean.shipSunk = 5;
		assertFalse(testOcean.isGameOver());
		
		//test for end
		testOcean.shipSunk = 10;
		assertTrue(testOcean.isGameOver());
		
	}

	@Test
	public void testGetShipArray() {
		testOcean = new Ocean();
		//test for empty sea, all elements are empty seas
		for(int i = 0; i < 10; i++){
			for(int j = 0; j < 10; j++){
				assertEquals(testOcean.getShipArray()[i][j].getLength(), 1);
				assertEquals(testOcean.getShipArray()[i][j].getShipType(), "empty");
				assertEquals(testOcean.getShipArray()[i][j].isSunk(), false);
				assertTrue(testOcean.getShipArray()[i][j].toString().equals("."));
			}
		}
		
		//test for general case
		Ship testShip = new BattleShip();
		testShip.placeShipAt(3, 4, true, testOcean);
		assertEquals(testOcean.getShipArray()[3][4].getLength(), 4);
		assertEquals(testOcean.getShipArray()[3][4].getShipType(), "battleship");
	}

}
