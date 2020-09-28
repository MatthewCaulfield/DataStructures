package proj5;

import static org.junit.Assert.*;

import org.junit.Test;

public class QueueTest {

	@Test
	public void testStringEmpty() {
		Queue aQueue = new Queue(5);
		assertEquals("", aQueue.toString());
	}
	
	@Test 
	public void testStringOneItem() {
		Queue aQueue = new Queue(5);
		aQueue.insert(3);
		assertEquals("{3}", aQueue.toString());
	}
	
	@Test
	public void testStringFourItems() {
		Queue aQueue = new Queue(5);
		aQueue.insert(3);
		aQueue.insert(5);
		aQueue.insert(8);
		aQueue.insert(2);
		assertEquals("{3, 5, 8, 2}", aQueue.toString());
	}

	@Test
	public void testIsEmpty() {
		Queue aQueue = new Queue(5);
		assertEquals(true, aQueue.isEmpty());
		aQueue.insert(3);
		assertEquals(false, aQueue.isEmpty());
	}
	
	@Test
	public void testCount() {
		Queue aQueue = new Queue(5);
		assertEquals(0, aQueue.size());
		aQueue.insert(3);
		assertEquals(1, aQueue.size());
		aQueue.insert(4);
		assertEquals(2, aQueue.size());
		aQueue.insert(1);
		assertEquals(3, aQueue.size());
		aQueue.insert(16);
		assertEquals(4, aQueue.size());
	}
	
	@Test
	public void testRemoveEmpty() {
		Queue aQueue = new Queue(5);
		aQueue.remove();
		assertEquals(true, aQueue.isEmpty());
		assertEquals("", aQueue.toString());
	}
	
	@Test
	public void testRemoveOne() {
		Queue aQueue = new Queue(5);
		aQueue.insert(5);
		int removedItem = aQueue.remove();
		assertEquals(removedItem, 5);
		assertEquals(true, aQueue.isEmpty());
		assertEquals("", aQueue.toString());
	}
	
	@Test
	public void testRemoveFour() {
		Queue aQueue = new Queue(5);
		aQueue.insert(5);
		aQueue.insert(2);
		aQueue.insert(7);
		aQueue.insert(4);
		assertEquals(4, aQueue.size());
		assertEquals("{5, 2, 7, 4}", aQueue.toString());
		int removedItem = aQueue.remove();
		assertEquals(3, aQueue.size());
		assertEquals("{2, 7, 4}", aQueue.toString());
		assertEquals(removedItem, 5);
		removedItem = aQueue.remove();
		assertEquals(2, aQueue.size());
		assertEquals("{7, 4}", aQueue.toString());
		assertEquals(removedItem, 2);
		removedItem = aQueue.remove();
		assertEquals(1, aQueue.size());
		assertEquals("{4}", aQueue.toString());
		assertEquals(removedItem, 7);
		removedItem = aQueue.remove();
		assertEquals(0, aQueue.size());
		assertEquals("", aQueue.toString());
		assertEquals(removedItem, 4);
	}
	
	@Test
	public void testEnsureCapacity() {
		Queue aQueue = new Queue(5);
		aQueue.insert(5);
		aQueue.insert(2);
		aQueue.insert(7);
		aQueue.insert(4);
		assertEquals(5, aQueue.getCapacity());
		assertEquals("{5, 2, 7, 4}", aQueue.toString());
		aQueue.insert(8);
		assertEquals(10, aQueue.getCapacity());
		assertEquals("{5, 2, 7, 4, 8}", aQueue.toString());
		aQueue.insert(6);
		assertEquals("{5, 2, 7, 4, 8, 6}", aQueue.toString());
		assertEquals(10, aQueue.getCapacity());
	}
	
	@Test 
	public void testContainsEmpty() {
		Queue aQueue = new Queue(5);
		assertEquals(false, aQueue.contains(9));
	}
	
	@Test
	public void testContainsMultiple() {
		Queue aQueue = new Queue(5);
		aQueue.insert(5);
		aQueue.insert(2);
		aQueue.insert(7);
		aQueue.insert(4);
		assertEquals(true, aQueue.contains(5));
		assertEquals(true, aQueue.contains(2));
		assertEquals(true, aQueue.contains(7));
		assertEquals(true, aQueue.contains(4));
		assertEquals(false, aQueue.contains(9));
	}
	
}
