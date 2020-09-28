package proj5;
/**
 * The Index Class which contains words and pagenumbers that they
 * appear on
 * the words are in alphabetical order
 * @author Matthew Caulfield
 * @version 11/12/2017
 */
public class Index {
	//Binary Search Tree of Index Elements which hold
	//a word and its associated page list 
	BinarySearchTree<IndexElement> indexTree;
	
	public Index() {
		indexTree = new BinarySearchTree<IndexElement>();
	}
	
	/**
	 * adds a word and the page number that it appears on to 
	 * the index
	 * @param aWord the word
	 * @param pageNum the page number
	 */
	public void insert(String aWord, int pageNum) {
		IndexElement anIndexElement = new IndexElement(aWord, pageNum);
		indexTree.recursiveInsert(anIndexElement);
	}
	
	/**
	 * adds a page number to the page list of the associated word
	 * @param target the word
	 * @param pageNum the page number
	 */
	public void addPageNumber(String target, int pageNum) {
		IndexElement anIndexElement = getIndexElement(target);
		anIndexElement.addPageNumber(pageNum);
	}
	
	/**
	 * returns true if the word is in the index
	 * false otherwise
	 * @param target the word that is being searched for
	 * @return if the word is in the index
	 */
	public boolean search(String target) {
		IndexElement anIndexElement = new IndexElement(target, -1);
		return indexTree.search(anIndexElement);
	}
	
	/**
	 * deletes an index element from the index
	 * @param victim the word of the associated index
	 */
	public void delete(String victim) {
		IndexElement victemIndexElement = getIndexElement(victim);
		indexTree.delete(victemIndexElement);
		
	}
	
	/**
	 * gets the index element associated with a string
	 * @param target string of the index element its searching for
	 * @return the found index element
	 */
	private IndexElement getIndexElement(String target) {
		IndexElement searchElement = new IndexElement(target, -1);
		IndexElement data = indexTree.getData(searchElement);
		return data;
	}
	
	/**
	 * returns the index entry of a word as a string
	 * @param targetWord word of associated entry
	 * @return the index entry as a string in form word {page list}
	 */
	public String stringOfIndexEntry(String targetWord) {
		IndexElement data = getIndexElement(targetWord);
		return data.toString();
	}
	
	/**
	 *checks if the index contains a page number for 
	 *a word
	 * @param element the word 
	 * @param target the page number
	 * @return
	 */
	public boolean containsPageNumber(String element, int target) {
		IndexElement data = getIndexElement(element);
		return data.containsPageNum(target);
	}
	
	/**
	 * @return the index as a string with each element in form
	 * word {page list}
	 */
	public String toString() {
		String indexString = indexTree.toString();
		String [] arrayOfIndex= indexString.split("\\(|\\)");
		int indexLength = arrayOfIndex.length;
		String toReturn = "";
		for(int i = 0; i<indexLength; i++) {
			if(!arrayOfIndex[i].equals("")) {
				toReturn+=arrayOfIndex[i] + "\n";
			}
		}
		toReturn = toReturn.trim();
		return toReturn;
	}
	
	/**
	 * checks of the page list is full
	 * @param the word of the associated page list
	 * @return boolean expression of if the page list is full
	 */
	public boolean isPageListFull(String target) {
		IndexElement anIndexElement = getIndexElement(target);
		return anIndexElement.isFull();
	}
	
}
