package battle;

import static org.junit.Assert.*;

import org.junit.Test;

import junit.framework.TestResult;

public class EmptySeaTest {

	@Test
	public void testGetShipType() {
		EmptySea testEmptySea = new EmptySea();
		assertEquals(testEmptySea.getShipType(), "empty");
	}

	@Test
	public void testShootAt() {
		EmptySea testEmptySea = new EmptySea();
		Boolean TestResult = testEmptySea.shootAt(3, 4);
		assertTrue(testEmptySea.hit[0]);
		assertFalse(TestResult);
	}

	@Test
	public void testIsSunk() {
		EmptySea testEmptySea = new EmptySea();
		assertFalse(testEmptySea.isSunk());
	}

	@Test
	public void testToString() {
		EmptySea testEmptySea = new EmptySea();
		assertTrue(testEmptySea.toString() == ".");
		testEmptySea.shootAt(3, 4);
		assertTrue(testEmptySea.toString() == "-");
	}

	@Test
	public void testEmptySea() {
		EmptySea testEmptySea = new EmptySea();
		assertEquals(testEmptySea.getLength(), 1);
	}

}
