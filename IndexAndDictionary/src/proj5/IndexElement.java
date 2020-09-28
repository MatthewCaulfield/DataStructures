package proj5;

/**
 * An Index Element that holds a string that is the word
 * and a page list associated to that word
 * @author Matthew Caulfield
 * @version 11/12/2017
 */
public class IndexElement<T> implements Comparable<T> {
	//the string that is the word for the index
	private String key;
	//the pages that the word appears on
	private Queue pageList;
	//the maximum number of pages it can appear on
	//before the page list is full
	private static int capacity = 4; 
	//the number of pages in the page list
	private int size; 
	public IndexElement(String newKey, int pageNumber){
		key = newKey;
		size = 0; 
		pageList = new Queue(capacity);
		pageList.insert(pageNumber); 
		size ++; 
	}
	
	/**
	 * adds a page number to the page list
	 * @param pageNumber
	 */
	public void addPageNumber(int pageNumber) {
		pageList.insert(pageNumber);
		size++;
	}
	
	/**
	 * @return the number of pages in the page list
	 */
	public int getSize() {
		return size; 
	}
	
	/**
	 * @return true if the number of pages is equal to 
	 * or greater than the capacity otherwise returns false
	 */
	public boolean isFull(){
		return getSize() >= capacity;
	}
	
	/**
	 * 
	 * @return the capacity of the queue
	 */
	public int getCapacity() {
		return capacity;
	}
	
	/**
	 * @return the key
	 */
	public String getKey(){
		return key;
	}
	
	
	/**
	 * @return the IndexElement as a String in form word {page list}
	 */
	public String toString() {
		String toReturn = key + " " + pageList.toString();
		return toReturn;
	}
	
	/**
	 * @return whether the page list contains a page number
	 */
	public boolean containsPageNum(int pageNum) {
		return pageList.contains(pageNum);
	}
	
	/**
	 * @param the object to be compared
	 * @return a negative integer, zero,
	 *  or a positive integer as this object is less than, equal to, 
	 *  or greater than the specified object.
	 */
	public int compareTo(T other) {
		String otherKey = ((IndexElement) other).getKey();
		return key.compareTo(otherKey);
	}
}



