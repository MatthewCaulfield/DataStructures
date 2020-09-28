package proj5;
/**
 * The dictionary class stores all words
 * in alphabetical order
 * @author Matt
 *@version 11/12/2017
 */
public class Dictionary {
	//wordTree stores the tree in alphabetical order
	//can only be changed by insert
	BinarySearchTree<String> wordTree;
	Dictionary(){
		wordTree = new BinarySearchTree<String>();
	}
	
	/**
	 * inserts a string into the dictionary
	 * @param toInsert
	 */
	public void insert(String toInsert) {
		wordTree.recursiveInsert(toInsert);
	}
	
	/**
	 * returns the dictionary as a string
	 * @return dictionary as a string
	 */
	public String toString() {
		String indexString = wordTree.toString();
		String [] arrayOfIndex= indexString.split("\\(|\\)");
		int indexLength = arrayOfIndex.length;
		String toReturn = "";
		for(int i = 0; i<indexLength; i++) {
			if(!arrayOfIndex[i].equals("")) {
				toReturn+=arrayOfIndex[i] + "\n";
			}
		}
		return toReturn;
	}
	
	/**
	 * returns true if a target word is in the tree
	 * false otherwise
	 * @param target word to check for
	 * @return boolean for if the target is in the tree
	 */
	public boolean search(String target) {
		return wordTree.search(target);
	}
}
