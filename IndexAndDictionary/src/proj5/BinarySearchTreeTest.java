package proj5;

import static org.junit.Assert.*;

import org.junit.Test;

public class BinarySearchTreeTest {

	@Test
	/**
	 *  Testing toString for an empty BST
	 */
	public void testToStringEmpty() {
		BinarySearchTree aTree = new BinarySearchTree();
		assertEquals(aTree.toString(),"");
	}
	
	
	/**
	 * testing is empty
	 */
	@Test
	public void isEmpty() {
		BinarySearchTree aTree = new BinarySearchTree();
		assertEquals(true, aTree.isEmpty());
		aTree.insert("cat");
		assertEquals(false, aTree.isEmpty());
	}
	
	@Test
	/**
	 *  Testing toString for a BST with one node
	 */
	public void testToStringOne() {
		BinarySearchTree aTree = new BinarySearchTree();
		aTree.recursiveInsert("dog");
		assertEquals(aTree.toString(),"(dog)");
	}
	
	@Test
	/**
	 *  Testing toString for a BST with multiple node
	 */
	public void testToStringMulti() {
		BinarySearchTree aTree = new BinarySearchTree();
		aTree.recursiveInsert("dog");
		aTree.recursiveInsert("cat");
		aTree.recursiveInsert("mouse");
		aTree.recursiveInsert("hat");
		aTree.recursiveInsert("sock");
		assertEquals(aTree.toString(),"((cat)dog((hat)mouse(sock)))");
	}
	
	@Test
	/**
	 * testing search on an empty tree
	 */
	public void testSearchEmpty() {
		BinarySearchTree aTree = new BinarySearchTree();
		assertEquals(aTree.search(""), false);
		assertEquals(aTree.search("HI"), false);
	}
	
	@Test
	/**
	 * testing search on a tree with one node
	 */
	public void testSearchOne() {
		BinarySearchTree aTree = new BinarySearchTree();
		aTree.recursiveInsert("cat");
		assertEquals(aTree.search("cat"), true);
		assertEquals(aTree.search("dog"), false);
	}
	
	@Test
	/**
	 * testing search on a tree with multiple nodes
	 */
	public void testSearchMultiple(){
		BinarySearchTree aTree = new BinarySearchTree();
		aTree.recursiveInsert("dog");
		aTree.recursiveInsert("cat");
		aTree.recursiveInsert("mouse");
		aTree.recursiveInsert("hat");
		aTree.recursiveInsert("sock");
		assertEquals(aTree.search("cat"), true);
		assertEquals(aTree.search("dog"), true);
		assertEquals(aTree.search("mouse"), true);
		assertEquals(aTree.search("hat"), true);
		assertEquals(aTree.search("sock"), true);
		assertEquals(aTree.search("hello"), false);
	}
	
	/**
	 * testing insert on an empty tree
	 */
	@Test
	public void testInsertEmpty() {
		BinarySearchTree aTree = new BinarySearchTree();
		aTree.insert("dog");
		assertEquals(aTree.toString(),"(dog)");
	}
	
	/**
	 * testing insert on a tree with one node
	 */
	@Test
	public void testInsertOne() {
		BinarySearchTree aTree = new BinarySearchTree();
		aTree.insert("dog");
		aTree.insert("cat");
		assertEquals(aTree.toString(),"((cat)dog)");
	}
	
	/**
	 * testing insert on a tree with multiple nodes
	 * multiple times
	 */
	@Test
	public void testInsertMulti() {
		BinarySearchTree aTree = new BinarySearchTree();
		aTree.insert("dog");
		aTree.insert("cat");
		aTree.insert("mouse");
		aTree.insert("hat");
		aTree.insert("sock");
		assertEquals(aTree.toString(),"((cat)dog((hat)mouse(sock)))");
	}
	
	/**
	 * testing delete from an empty tree
	 */
	@Test 
	public void testDeleteEmpty() {
		BinarySearchTree<String> aTree = new BinarySearchTree<String>();
		aTree.delete("cat");
		assertEquals(aTree.toString(), "");
		
	}
	
	/**
	 * testing delete an a tree with one node
	 */
	@Test
	public void testDeleteOneNode() {
		BinarySearchTree<String> aTree = new BinarySearchTree<String>();
		aTree.insert("cat");
		aTree.delete("cat");
		assertEquals("", aTree.toString());
	}
	
	/**
	 * testing delete for deleting leaf
	 */
	@Test
	public void testDeleteLeaf() {
		BinarySearchTree<String> aTree = new BinarySearchTree<String>();
		aTree.insert("cat");
		aTree.insert("art");
		aTree.insert("dog");
		aTree.delete("art");
		assertEquals("(cat(dog))", aTree.toString());
	}
	
	
	/**
	 * testing delete of one child
	 */
	@Test 
	public void testDeleteOneChild() {
		BinarySearchTree<String> aTree = new BinarySearchTree<String>();
		aTree.insert("cat");
		aTree.insert("art");
		aTree.insert("dog");
		aTree.insert("fog");
		aTree.delete("dog");
		assertEquals("((art)cat(fog))", aTree.toString());
	}
	
	/**
	 * testing delete with two children
	 */
	@Test
	public void testDeleteTwoKids() {
		BinarySearchTree<String> aTree = new BinarySearchTree<String>();
		aTree.insert("bat");
		aTree.insert("art");
		aTree.insert("dog");
		aTree.insert("cat");
		aTree.insert("fog");
		assertEquals("((art)bat((cat)dog(fog)))", aTree.toString());
		aTree.delete("dog");
		assertEquals("((art)bat(cat(fog)))", aTree.toString());
	}
	
	/**
	 * testing get data
	 */
	@Test
	public void testGetData() {
		BinarySearchTree<String> aTree = new BinarySearchTree<String>();
		aTree.insert("bat");
		aTree.insert("art");
		aTree.insert("dog");
		aTree.insert("cat");
		aTree.insert("fog");
		String aString = aTree.getData("dog"); 
		assertEquals("dog", aString);
	}
}
