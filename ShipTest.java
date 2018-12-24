package battle;

import static org.junit.Assert.*;

import org.junit.Test;

public class ShipTest {
	
	Ship testship;
	Ocean testOcean;

	@Test
	public void testGetLength() {
		//test for battleship
		testship = new BattleShip();
		assertEquals(testship.getLength(), 4);
		
		//test for cruiser
		testship = new Cruiser();
		assertEquals(testship.getLength(), 3);
		
		//test for emptysea
		testship = new EmptySea();
		assertEquals(testship.getLength(), 1);
		
		//test for destroyer
		testship = new Destroyer();
		assertEquals(testship.getLength(), 2);
		
		//test for submarine
		testship = new Submarine();
		assertEquals(testship.getLength(), 1);
	}
	
	@Test
	public void testGetAndSetBowRow() {
		//test for battleship
		testship = new BattleShip();
		testship.setBowRow(4);
		assertEquals(testship.getBowRow(), 4);
		
		//test for cruiser
		testship = new Cruiser();
		testship.setBowRow(3);
		assertEquals(testship.getBowRow(), 3);
				
		//test for Destroyer
		testship = new Destroyer();
		testship.setBowRow(2);
		assertEquals(testship.getBowRow(), 2);

		//test for Submarine
		testship = new Submarine();
		testship.setBowRow(5);
		assertEquals(testship.getBowRow(), 5);
	}

	@Test
	public void testGetAndSetBowColumn() {
		//test for battleship
		testship = new BattleShip();
		testship.setBowColumn(4);
		assertEquals(testship.getBowColumn(), 4);
		
		//test for cruiser
		testship = new Cruiser();
		testship.setBowColumn(5);
		assertEquals(testship.getBowColumn(), 5);
		
		//test for Destroyer
		testship = new Destroyer();
		testship.setBowColumn(6);
		assertEquals(testship.getBowColumn(), 6);
		
		//test for Submarine
		testship = new Submarine();
		testship.setBowColumn(1);
		assertEquals(testship.getBowColumn(), 1);
	}
	
	@Test
	public void testGetBowRow() {
		//test for battleship
		testship = new BattleShip();
		testship.bowRow = 4;
		assertEquals(testship.getBowRow(), testship.bowRow);
		
		//test for cruiser
		testship = new Cruiser();
		testship.bowRow = 3;
		assertEquals(testship.getBowRow(), testship.bowRow);
				
		//test for Destroyer
		testship = new Destroyer();
		testship.bowRow = 2;
		assertEquals(testship.getBowRow(), testship.bowRow);

		//test for Submarine
		testship = new Submarine();
		testship.bowRow = 1;
		assertEquals(testship.getBowRow(), testship.bowRow);
	}

	@Test
	public void testGetBowColumn() {
		//test for battleship
		testship = new BattleShip();
		testship.bowCol = 4;
		assertEquals(testship.getBowColumn(), testship.bowCol);
		
		//test for cruiser
		testship = new Cruiser();
		testship.bowCol = 3;
		assertEquals(testship.getBowColumn(), testship.bowCol);
				
		//test for Destroyer
		testship = new Destroyer();
		testship.bowCol = 2;
		assertEquals(testship.getBowColumn(), testship.bowCol);

		//test for Submarine
		testship = new Submarine();
		testship.bowCol = 1;
		assertEquals(testship.getBowColumn(), testship.bowCol);
	}

	@Test
	public void testGetHit() {
		//test for no hit battle ship
		testship = new BattleShip();
		testOcean = new Ocean();	
		testship.placeShipAt(3, 4, true, testOcean);
		assertEquals(testship.getHit()[0], false);
		assertEquals(testship.getHit()[1], false);
		assertEquals(testship.getHit()[2], false);
		assertEquals(testship.getHit()[3], false);
		
		//test for no hit cruiser ship
		testship = new Cruiser();
		testOcean = new Ocean();	
		testship.placeShipAt(3, 4, true, testOcean);
		assertEquals(testship.getHit()[0], false);
		assertEquals(testship.getHit()[1], false);
		assertEquals(testship.getHit()[2], false);

		//test for no hit destroyer ship
		testship = new Destroyer();
		testOcean = new Ocean();	
		testship.placeShipAt(3, 4, true, testOcean);
		assertEquals(testship.getHit()[0], false);
		assertEquals(testship.getHit()[1], false);
	
		//test for no hit submarine ship
		testship = new Submarine();
		testOcean = new Ocean();	
		testship.placeShipAt(3, 4, true, testOcean);
		assertEquals(testship.getHit()[0], false);
		
		//test for battle ship
		testship = new BattleShip();
		testOcean = new Ocean();	
		testship.placeShipAt(3, 4, true, testOcean);
		testship.shootAt(3, 4);
		assertEquals(testship.getHit()[0], true);
		assertEquals(testship.getHit()[1], false);
		assertEquals(testship.getHit()[2], false);
		assertEquals(testship.getHit()[3], false);
				
		//test for cruiser ship
		testship = new Cruiser();
		testOcean = new Ocean();
		testship.placeShipAt(3, 4, true, testOcean);
		testship.shootAt(3, 4);
		assertEquals(testship.getHit()[0], true);
		assertEquals(testship.getHit()[1], false);
		assertEquals(testship.getHit()[2], false);
		assertEquals(testship.getHit()[3], false);
				
				
		//test for destroyer ship
		testship = new Destroyer();
		testOcean = new Ocean();
		testship.placeShipAt(3, 4, true, testOcean);
		testship.shootAt(3, 4);
		assertEquals(testship.getHit()[0], true);
		assertEquals(testship.getHit()[1], false);
		assertEquals(testship.getHit()[2], false);
		assertEquals(testship.getHit()[3], false);
				
				
				
		//test for submarine ship
		testship = new Submarine();
		testOcean = new Ocean();
		testship.placeShipAt(3, 4, true, testOcean);
		testship.shootAt(3, 4);
		assertEquals(testship.getHit()[0], true);
		assertEquals(testship.getHit()[1], false);
		assertEquals(testship.getHit()[2], false);
		assertEquals(testship.getHit()[3], false);
				
				
				
	}

	@Test
	public void testSetAndIsHorizontal() {
		//test for battleship
		testship = new BattleShip();
		testship.setHorizontal(true);
		assertEquals(testship.isHorizontal(), true);
		
		//test for cruiser
		testship = new Cruiser();
		testship.setHorizontal(true);
		assertEquals(testship.isHorizontal(), true);
				
		//test for Destroyer
		testship = new Destroyer();
		testship.setHorizontal(false);
		assertEquals(testship.isHorizontal(), false);

		//test for Submarine
		testship = new Submarine();
		testship.setHorizontal(false);
		assertEquals(testship.isHorizontal(), false);
	}
	
	@Test
	public void testIsHorizontal() {
		//test for battleship
		testship = new BattleShip();
		testship.horizontal = true;
		assertEquals(testship.isHorizontal(), testship.horizontal);
		
		//test for cruiser
		testship = new Cruiser();
		testship.horizontal = true;
		assertEquals(testship.isHorizontal(), testship.horizontal);
				
		//test for Destroyer
		testship = new Destroyer();
		testship.horizontal = true;
		assertEquals(testship.isHorizontal(), testship.horizontal);

		//test for Submarine
		testship = new Submarine();
		testship.horizontal = false;
		assertEquals(testship.isHorizontal(), testship.horizontal);
	}

	@Test
	public void testGetShipType() {
		//test for battleship
		testship = new BattleShip();
		assertEquals(testship.getShipType(), "battleship");
		
		//test for cruiser
		testship = new Cruiser();
		assertEquals(testship.getShipType(), "cruiser");
				
		//test for Destroyer
		testship = new Destroyer();
		assertEquals(testship.getShipType(), "destroyer");

		//test for Submarine
		testship = new Submarine();
		assertEquals(testship.getShipType(), "submarine");
		
		//test for emptysea
		testship = new EmptySea();
		assertEquals(testship.getShipType(), "empty");
	}

	@Test
	public void testSetBowRow() {
		//test for battleship
		testship = new BattleShip();
		testship.setBowRow(1);
		assertEquals(testship.bowRow, 1);
		
		//test for cruiser
		testship = new Cruiser();
		testship.setBowRow(2);
		assertEquals(testship.bowRow, 2);
				
		//test for Destroyer
		testship = new Destroyer();
		testship.setBowRow(3);
		assertEquals(testship.bowRow, 3);

		//test for Submarine
		testship = new Submarine();
		testship.setBowRow(4);
		assertEquals(testship.bowRow, 4);
	}

	@Test
	public void testSetBowColumn() {
		//test for battleship
		testship = new BattleShip();
		testship.setBowColumn(1);
		assertEquals(testship.bowCol, 1);
		
		//test for cruiser
		testship = new Cruiser();
		testship.setBowColumn(2);
		assertEquals(testship.bowCol, 2);
				
		//test for Destroyer
		testship = new Destroyer();
		testship.setBowColumn(3);
		assertEquals(testship.bowCol, 3);

		//test for Submarine
		testship = new Submarine();
		testship.setBowColumn(4);
		assertEquals(testship.bowCol, 4);
	}

	@Test
	public void testSetHorizontal() {
		//test for battleship
		testship = new BattleShip();
		testship.setHorizontal(true);
		assertEquals(testship.isHorizontal(), true);
		
		//test for cruiser
		testship = new Cruiser();
		testship.setHorizontal(true);
		assertEquals(testship.isHorizontal(), true);
				
		//test for Destroyer
		testship = new Destroyer();
		testship.setHorizontal(false);
		assertEquals(testship.isHorizontal(), false);

		//test for Submarine
		testship = new Submarine();
		testship.setHorizontal(false);
		assertEquals(testship.isHorizontal(), false);
	}

	@Test
	public void testOkToPlaceShipAt() {
		//test for battleship
		testship = new BattleShip();
		testOcean = new Ocean();
		assertTrue(testship.okToPlaceShipAt(0, 0, true, testOcean));
		
		//test for cruiser
		testship = new Cruiser();
		testOcean = new Ocean();
		assertTrue(testship.okToPlaceShipAt(4, 2, true, testOcean));
		
		//test for destroyer
		testship = new Destroyer();
		testOcean = new Ocean();
		assertFalse(testship.okToPlaceShipAt(9, 9, false, testOcean));
		
		//test for submarine
		testship = new Submarine();
		testOcean = new Ocean();
		assertTrue(testship.okToPlaceShipAt(0, 0, true, testOcean));
	}

	@Test
	public void testPlaceShipAt() {
		//test for battle ship
		testship = new BattleShip();
		testOcean = new Ocean();
		testship.placeShipAt(3, 4, true, testOcean);
		for (int i = 4; i < 8; i++) {
			assertTrue(testOcean.ships[3][i].equals(testship));
			assertFalse(testOcean.ships[4][i].equals(testship));
			assertTrue(testOcean.ships[3][i].getShipType().equals("battleship"));
		}
		assertFalse(testOcean.ships[3][8].equals(testship));
		assertFalse(testOcean.ships[3][3].equals(testship));
		
		//test for cruiser ship
		testship = new Cruiser();
		testOcean = new Ocean();
		testship.placeShipAt(3, 4, true, testOcean);
		for (int i = 4; i < 7; i++) {
			assertTrue(testOcean.ships[3][i].equals(testship));
			assertFalse(testOcean.ships[4][i].equals(testship));
			assertTrue(testOcean.ships[3][i].getShipType().equals("cruiser"));
		}
		assertFalse(testOcean.ships[3][7].equals(testship));
		assertFalse(testOcean.ships[3][3].equals(testship));
		
		//test for destroyer ship
		testship = new Destroyer();
		testOcean = new Ocean();
		testship.placeShipAt(3, 4, true, testOcean);
		for (int i = 4; i < 6; i++) {
			assertTrue(testOcean.ships[3][i].equals(testship));
			assertFalse(testOcean.ships[4][i].equals(testship));
			assertTrue(testOcean.ships[3][i].getShipType().equals("destroyer"));
		}
		assertFalse(testOcean.ships[3][6].equals(testship));
		assertFalse(testOcean.ships[3][3].equals(testship));
		
		//test for submarine ship
		testship = new Submarine();
		testOcean = new Ocean();
		testship.placeShipAt(3, 4, true, testOcean);
		for (int i = 4; i < 5; i++) {
			assertTrue(testOcean.ships[3][i].equals(testship));
			assertFalse(testOcean.ships[4][i].equals(testship));
			assertTrue(testOcean.ships[3][i].getShipType().equals("submarine"));
		}
		assertFalse(testOcean.ships[3][5].equals(testship));
		assertFalse(testOcean.ships[3][3].equals(testship));
		
	}

	@Test
	public void testShootAt() {
		//test for general cases
		testOcean = new Ocean();
		testship = new BattleShip();
		testship.placeShipAt(3, 3, true, testOcean);
		boolean hitResult = testship.shootAt(3, 3);
		assertTrue(testship.hit[0]);
		assertFalse(testship.hit[1]);
		assertFalse(testship.hit[2]);
		assertFalse(testship.hit[3]);
		assertTrue(hitResult);
		
		//test when the ship is sunk
		testship.shootAt(3, 4);
		assertTrue(testship.hit[1]);
		testship.shootAt(3, 5);
		assertTrue(testship.hit[2]);
		testship.shootAt(3, 6);
		assertTrue(testship.hit[3]);
		boolean hitResult1 = testship.shootAt(3, 6);
		assertFalse(hitResult1);
		
		//test when there is no ship
		testOcean = new Ocean();
		testship = new Cruiser();
		testship.placeShipAt(4, 5, true, testOcean);
		boolean hitResult2 = testship.shootAt(3, 6);
		assertFalse(hitResult2);
		for (int i = 0; i < 4; i++) {
			assertFalse(testship.hit[i]);
		}
	}

	@Test
	public void testIsSunk() {
		//for general cases
		testship = new Destroyer();
		testOcean = new Ocean();
		testship.placeShipAt(3, 4, true, testOcean);
		testship.shootAt(3, 4);
		assertFalse(testship.isSunk());
		
		//test for a ship which is already sunk
		testship.shootAt(3, 5);
		assertTrue(testship.isSunk());
		
		//test for empty sea
		testship = new EmptySea();
		testOcean = new Ocean();
		testship.placeShipAt(3, 4, true, testOcean);
		testship.shootAt(3, 4);
		assertFalse(testship.isSunk());
	}

	@Test
	public void testToString() {
		//test for not hit ship
		testship = new BattleShip();
		testOcean = new Ocean();
		testship.placeShipAt(3, 4, true, testOcean);
		testship.shootAt(4, 8);
		assertTrue(testship.toString().equals("S"));
		
		//test for hit ship but not sunk
		testship = new BattleShip();
		testOcean = new Ocean();
		testship.placeShipAt(3, 4, true, testOcean);
		testship.shootAt(3, 4);
		assertTrue(testship.toString().equals("S"));
		testship.shootAt(3, 5);
		assertTrue(testship.toString().equals("S"));
		testship.shootAt(3, 6);
		assertTrue(testship.toString().equals("S"));
		
		//test for sunk ship
		testship.shootAt(3, 7);
		assertTrue(testship.toString().equals("x"));
	}

}
