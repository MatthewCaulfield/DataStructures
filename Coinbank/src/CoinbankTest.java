/**
 * JUnit test class.  Use these tests as models for your own.
 */
import org.junit.*;
import org.junit.rules.Timeout;
import static org.junit.Assert.*;

import proj1.Coinbank;

public class CoinbankTest {
	
	@Rule // a test will fail if it takes longer than 1/10 of a second to run
 	public Timeout timeout = Timeout.millis(100); 

	/**
	 * Sets up a bank with the given coins
	 * @param pennies number of pennies you want
	 * @param nickels number of nickels you want
	 * @param dimes number of dimes you want
	 * @param quarters number of quarters you want
	 * @return the Coinbank filled with the requested coins of each type
	 */
	private Coinbank makeBank(int pennies, int nickels, int dimes, int quarters) {
		Coinbank c = new Coinbank();
		int[] money = new int[]{pennies, nickels, dimes, quarters};
		int[] denom = new int[]{1,5,10,25};
		for (int index=0; index<money.length; index++) {
			int numCoins = money[index];
			for (int coin=0; coin<numCoins; coin++) {
				c.insert(denom[index]);
			}
		}
		return c;
	}

	@Test // bank should be empty upon construction
	public void testConstruct() {
		Coinbank emptyDefault = new Coinbank();
		assertEquals(0, emptyDefault.get(1));
		assertEquals(0, emptyDefault.get(5));
		assertEquals(0, emptyDefault.get(10));
		assertEquals(0, emptyDefault.get(25));
	}
	

	@Test // inserting penny should return true & one penny should be in bank
	public void testInsertPenny_return()
	{
		Coinbank c = new Coinbank();
		assertTrue(c.insert(1));
		assertEquals(1,c.get(1));
	}
	
	@Test // inserting nickel should return true & one nickel should be in bank
	public void testInsertNickel_return()
	{
		Coinbank c = new Coinbank();
		assertTrue(c.insert(5));
		assertEquals(1,c.get(5));
	}
	
	@Test // inserting dime should return true & one dime should be in bank
	public void testInsertDime_return()
	{
		Coinbank c = new Coinbank();
		assertTrue(c.insert(10));
		assertEquals(1,c.get(10));
	}
	@Test // inserting quarter should return true & one quarter should be in bank
	
	public void testInsertQuarter_return()
	{
		Coinbank c = new Coinbank();
		assertTrue(c.insert(25));
		assertEquals(1,c.get(25));
	}
	
	@Test // inserting invalid coin should return false & no coins should be in bank
	public void testInsertInvalid_return()
	{
		Coinbank c = new Coinbank();
		assertFalse(c.insert(3));
		assertEquals(-1,c.get(3));
	}
	
	@Test // getter should return correct values
	public void testGet()
	{
		Coinbank c = makeBank(0,2,15,1);
		assertEquals(0,c.get(1));
		assertEquals(2,c.get(5));
		assertEquals(15,c.get(10));
		assertEquals(1,c.get(25));
		assertEquals(-1, c.get(3));
	}
	
	@Test // getter should not alter the bank
	public void testGet_contents()
	{
		Coinbank c = makeBank(0,2,15,1);
		c.get(1);
		c.get(5);
		c.get(10);
		c.get(25);
		c.get(3);
		String expected = "The bank currently holds $1.85 consisting of \n0 pennies\n2 nickels\n15 dimes\n1 quarters\n";
		assertEquals(expected,c.toString());
	}

	@Test //test of remove removing to many coins
	public void testRemove_toMany() {
		Coinbank c = makeBank(2,1,0,3);
		assertEquals(1, c.remove(5, 3));
		String expected = "The bank currently holds $0.77 consisting of \n2 pennies\n0 nickels\n0 dimes\n3 quarters\n";
		assertEquals(expected,c.toString());
	}
	
	@Test //test of remove removing less coins
	public void testRemove_less() {
		Coinbank c = makeBank(1,2,3,3);
		assertEquals(2, c.remove(10, 2));
		String expected = "The bank currently holds $0.96 consisting of \n1 pennies\n2 nickels\n1 dimes\n3 quarters\n";
		assertEquals(expected,c.toString());
	}
	
	@Test //test of remove removing invalid
	public void testRemove_invalid() {
		Coinbank c = makeBank(1,2,3,3);
		assertEquals(0, c.remove(6, 2));
		String expected = "The bank currently holds $1.16 consisting of \n1 pennies\n2 nickels\n3 dimes\n3 quarters\n";
		assertEquals(expected,c.toString());
	}
	
	@Test // test of remove
	public void testRemove_justEnough()
	{
		Coinbank c = makeBank(4,1,3,5);
		assertEquals(5,c.remove(25,5));
		String expected = "The bank currently holds $0.39 consisting of \n4 pennies\n1 nickels\n3 dimes\n0 quarters\n";
		assertEquals(expected,c.toString());
	}
	
	@Test // remove should not do anything if a 3-cent coin is requested
	public void testRemove_invalidCoin()
	{
		Coinbank c = makeBank(4,1,3,5);
		assertEquals(0,c.remove(3,1));
	}
}
