import junit.framework.TestCase;
import proj3.LinkedList;

/**
 * 
 * @author Matt
 *JUnit test for Linked Lists
 *@version 10/13/2017
 */
public class LinkedListJUnitTests extends TestCase {
	/**
	 * tests removeHead linked list method
	 */
	public void testRemoveHead() {
		LinkedList aLinkedList = new LinkedList();
		aLinkedList.insertAtHead("D");
		aLinkedList.insertAtHead("C");
		aLinkedList.insertAtHead("B");
		aLinkedList.insertAtHead("A");
		assertEquals("(A,B,C,D)", aLinkedList.toString());
		assertEquals(aLinkedList.getLength(), 4);
		aLinkedList.removeHead();
		assertEquals(aLinkedList.getLength(), 3);
		assertEquals("(B,C,D)", aLinkedList.toString());
		aLinkedList.removeHead();
		assertEquals(aLinkedList.getLength(), 2);
		assertEquals("(C,D)", aLinkedList.toString());
		aLinkedList.removeHead();
		assertEquals(aLinkedList.getLength(), 1);
		assertEquals("(D)", aLinkedList.toString());
		aLinkedList.removeHead();
		assertEquals(aLinkedList.getLength(), 0);
		assertEquals("()", aLinkedList.toString());
		aLinkedList.removeHead();
		assertEquals(aLinkedList.getLength(), 0);
		assertEquals("()", aLinkedList.toString());
	}
	
	/**
	 * test insert at tail
	 */
	public void testInsertAtTail() {
		LinkedList aLinkedList = new LinkedList();
		aLinkedList.insertAtTail("A");
		assertEquals(aLinkedList.getLength(), 1);
		assertEquals("(A)", aLinkedList.toString());
		aLinkedList.insertAtTail("B");
		assertEquals("(A,B)", aLinkedList.toString());
		assertEquals(aLinkedList.getLength(), 2);
		aLinkedList.insertAtTail("C");
		assertEquals("(A,B,C)", aLinkedList.toString());
		assertEquals(aLinkedList.getLength(), 3);
		aLinkedList.insertAtTail("D");
		assertEquals("(A,B,C,D)", aLinkedList.toString());
		assertEquals(aLinkedList.getLength(), 4);
	}
	
	/**
	 * test of indexOf
	 */
	public void testIndexOf() {
		LinkedList aLinkedList = new LinkedList();
		assertEquals(-1, aLinkedList.indexOf("A"));
		assertEquals("()", aLinkedList.toString());
		assertEquals(aLinkedList.getLength(), 0);
		aLinkedList.insertAtTail("A");
		assertEquals(aLinkedList.indexOf("A"), 0);
		assertEquals(-1, aLinkedList.indexOf("B"));
		assertEquals(aLinkedList.getLength(), 1);
		assertEquals("(A)", aLinkedList.toString());
		aLinkedList.insertAtTail("B");
		aLinkedList.insertAtTail("C");
		assertEquals(aLinkedList.indexOf("A"), 0);
		assertEquals(1, aLinkedList.indexOf("B"));
		assertEquals(2, aLinkedList.indexOf("C"));
		assertEquals(-1, aLinkedList.indexOf("D"));
		assertEquals(aLinkedList.getLength(), 3);
		assertEquals("(A,B,C)", aLinkedList.toString());
		
	}
	
	/**
	 * tests the insertAtIndex function for an empty Linked List
	 */
	public void test_insertAtIndexEmpty() {
		LinkedList aLinkedList = new LinkedList();
		aLinkedList.insertAtIndex("A", 0);
		assertEquals("(A)", aLinkedList.toString());
		aLinkedList.removeHead();
		assertEquals("()", aLinkedList.toString());
		aLinkedList.insertAtIndex("A", 1);
		assertEquals("(A)", aLinkedList.toString());
	}
	
	/**
	 * tests the insertAtIndex function for a LL with strings in it 
	 */
	public void test_insertAtIndexFull() {
		LinkedList aLinkedList = new LinkedList();
		aLinkedList.insertAtTail("A");
		aLinkedList.insertAtTail("B");
		aLinkedList.insertAtTail("C");
		assertEquals("(A,B,C)", aLinkedList.toString());
		aLinkedList.insertAtIndex("E", 1);
		assertEquals("(A,E,B,C)", aLinkedList.toString());
		assertEquals(4, aLinkedList.getLength());
		aLinkedList.insertAtIndex("F", 0);
		assertEquals("(F,A,E,B,C)", aLinkedList.toString());
		assertEquals(5, aLinkedList.getLength());
		aLinkedList.insertAtIndex("G", 4);
		assertEquals("(F,A,E,B,G,C)", aLinkedList.toString());
		assertEquals(6, aLinkedList.getLength());
		aLinkedList.insertAtIndex("H", 6);
		assertEquals("(F,A,E,B,G,C,H)", aLinkedList.toString());
		assertEquals(7, aLinkedList.getLength());	
	}
	
	/**
	 * test the return by index function for an empty LL
	 */
	public void test_returnByIndexEmpty(){
		LinkedList aLinkedList = new LinkedList();
		assertEquals(null,aLinkedList.returnByIndex(0));
		assertEquals(null,aLinkedList.returnByIndex(1));
		assertEquals(null, aLinkedList.returnByIndex(-1));
	}
	
	/**
	 * test the return by index function for a full LL
	 */
	public void test_returnByIndexFull() {
		LinkedList aLinkedList = new LinkedList();
		aLinkedList.insertAtTail("A");
		aLinkedList.insertAtTail("B");
		aLinkedList.insertAtTail("C");
		assertEquals("(A,B,C)", aLinkedList.toString());
		assertEquals("A", aLinkedList.returnByIndex(0));
		assertEquals("B", aLinkedList.returnByIndex(1));
		assertEquals("C", aLinkedList.returnByIndex(2));
		assertEquals(null, aLinkedList.returnByIndex(3));
		assertEquals(null, aLinkedList.returnByIndex(-1));
		assertEquals("(A,B,C)", aLinkedList.toString());
		assertEquals(3, aLinkedList.getLength());
	}

	/***
	 * test the changeAtIndex function for an empty LL
	 */
	public void test_changeAtIndexEmpty() {
		LinkedList aLinkedList = new LinkedList();
		aLinkedList.changeAtIndex("A", 0);
		assertEquals("()", aLinkedList.toString());
		aLinkedList.changeAtIndex("A", 1);
		assertEquals("()", aLinkedList.toString());
		aLinkedList.changeAtIndex("A", -1);
		assertEquals("()", aLinkedList.toString());
	}
	
	/**
	 * test the changeAtIndex function for a full LL
	 */
	public void test_changeAtIndexFull() {
		LinkedList aLinkedList = new LinkedList();
		aLinkedList.insertAtTail("A");
		aLinkedList.insertAtTail("B");
		aLinkedList.insertAtTail("C");
		assertEquals("(A,B,C)", aLinkedList.toString());
		aLinkedList.changeAtIndex("D", -1);
		assertEquals("(A,B,C)", aLinkedList.toString());
		aLinkedList.changeAtIndex("D", 0);
		assertEquals("(D,B,C)", aLinkedList.toString());
		aLinkedList.changeAtIndex("D", 1);
		assertEquals("(D,D,C)", aLinkedList.toString());
		aLinkedList.changeAtIndex("D", 2);
		assertEquals("(D,D,D)", aLinkedList.toString());
		aLinkedList.changeAtIndex("D", 3);
		assertEquals("(D,D,D)", aLinkedList.toString());
	}
	
	/**
	 * test the clone function for an empty LL
	 */
	public void test_cloneEmpty() {
		LinkedList aLinkedList = new LinkedList();
		assertEquals("()", aLinkedList.clone().toString());
	}
	
	/**
	 * test the clone function for a full LL
	 */
	public void test_cloneFull() {
		LinkedList aLinkedList = new LinkedList();
		aLinkedList.insertAtTail("A");
		aLinkedList.insertAtTail("B");
		aLinkedList.insertAtTail("C");
		assertEquals("(A,B,C)", aLinkedList.toString());
		LinkedList aClone = aLinkedList.clone();
		assertEquals("(A,B,C)", aClone.toString());
		assertEquals(3, aClone.getLength());
	}
	
}