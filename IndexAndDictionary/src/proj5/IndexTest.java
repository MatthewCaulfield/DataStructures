package proj5;

import static org.junit.Assert.*;

import org.junit.Test;

public class IndexTest {

	@Test
	public void testToStringEmpty() {
		Index aIndex = new Index();
		assertEquals("", aIndex.toString());
	}
	
	@Test
	public void testToStringMultiple() {
		Index aIndex = new Index();
		aIndex.insert("bat", 1);
		aIndex.insert("cat", 1);
		aIndex.insert("dog", 2);
		aIndex.insert("rat", 3);
		assertEquals("bat {1}\ncat {1}\ndog {2}\nrat {3}", aIndex.toString());
	}
	
	@Test
	public void testaddPageNumber() {
		Index aIndex = new Index();
		aIndex.insert("bat", 1);
		aIndex.addPageNumber("bat", 3);
		aIndex.addPageNumber("bat", 4);
		aIndex.addPageNumber("bat", 7);
		assertEquals("bat {1, 3, 4, 7}", aIndex.toString());
	}

	@Test
	public void testContainsPageNumberTrue() {
		Index aIndex = new Index();
		aIndex.insert("bat", 1);
		aIndex.addPageNumber("bat", 3);
		aIndex.addPageNumber("bat", 4);
		aIndex.addPageNumber("bat", 7);
		assertEquals("bat {1, 3, 4, 7}", aIndex.toString());
		assertEquals(true, aIndex.containsPageNumber("bat", 1));
		assertEquals(true, aIndex.containsPageNumber("bat", 3));
		assertEquals(true, aIndex.containsPageNumber("bat", 4));
		assertEquals(true, aIndex.containsPageNumber("bat", 7));
	}
	
	@Test 
	public void testContainsPageNumberFalse() {
		Index aIndex = new Index();
		aIndex.insert("bat", 1);
		aIndex.addPageNumber("bat", 3);
		aIndex.addPageNumber("bat", 4);
		aIndex.addPageNumber("bat", 7);
		assertEquals("bat {1, 3, 4, 7}", aIndex.toString());
		assertEquals(false, aIndex.containsPageNumber("bat", 5));
	}
	
	@Test
	public void testSearch() {
		Index aIndex = new Index();
		aIndex.insert("bat", 1);
		assertEquals(true, aIndex.search("bat"));
		assertEquals(false, aIndex.search("cat"));
	}
	
	@Test
	public void testDelete() {
		Index aIndex = new Index();
		aIndex.insert("bat", 1);
		aIndex.insert("cat", 1);
		aIndex.insert("dog", 2);
		aIndex.insert("rat", 3);
		assertEquals("bat {1}\ncat {1}\ndog {2}\nrat {3}", aIndex.toString());
		aIndex.delete("dog");
		assertEquals("bat {1}\ncat {1}\nrat {3}", aIndex.toString());
	}
	@Test
	public void testStringIndexElement() {
		Index aIndex = new Index();
		aIndex.insert("bat", 1);
		aIndex.insert("cat", 1);
		aIndex.insert("dog", 2);
		aIndex.insert("rat", 3);
		assertEquals("bat {1}", aIndex.stringOfIndexEntry("bat"));
	}
	
	@Test
	public void testIsPageListFull() {
		Index aIndex = new Index();
		aIndex.insert("bat", 1);
		assertEquals(false, aIndex.isPageListFull("bat"));
		aIndex.addPageNumber("bat", 3);
		assertEquals(false, aIndex.isPageListFull("bat"));
		aIndex.addPageNumber("bat", 4);
		assertEquals(false, aIndex.isPageListFull("bat"));
		aIndex.addPageNumber("bat", 7);	
		assertEquals(true, aIndex.isPageListFull("bat"));
	}
}
