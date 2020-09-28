package proj5;

import static org.junit.Assert.*;

import org.junit.Test;

public class DictionaryTest {

	@Test
	public void testInsert() {
		Dictionary aDictionary = new Dictionary();
		aDictionary.insert("cat");
		assertEquals("cat\n", aDictionary.toString());
	}
	
	@Test
	public void testToStringEmpty() {
		Dictionary aDictionary = new Dictionary();
		assertEquals("", aDictionary.toString());
	}
	
	@Test public void testToStringMultiple() {
		Dictionary aDictionary = new Dictionary();
		aDictionary.insert("cat");
		aDictionary.insert("dog");
		aDictionary.insert("rat");
		aDictionary.insert("bat");
		assertEquals("bat\ncat\ndog\nrat\n", aDictionary.toString());
	}
	
	@Test
	public void testSearchEmpty() {
		Dictionary aDictionary = new Dictionary();
		assertEquals(false, aDictionary.search("cat"));
	}
	
	@Test
	public void testSearchMultiple() {
		Dictionary aDictionary = new Dictionary();
		aDictionary.insert("cat");
		aDictionary.insert("dog");
		aDictionary.insert("rat");
		aDictionary.insert("bat");
		assertEquals(true, aDictionary.search("cat"));
	}

}
