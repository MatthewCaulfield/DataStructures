package proj5;
/** 
 * Node for binary search tree can 
 * only hold comparable
 * @author Matthew Caulfield
 * @version 11/12/17
 */
public class BSTNode <T>{

	public T key;
	public BSTNode<T> llink;
	public BSTNode<T> rlink;
	
	/**
	 * non-default constructor
	 * @param newKey string that node will hold
	 */
	public BSTNode(T newKey)
	{
		key = newKey;
		llink = null;
		rlink = null;
	}
	
	/**
	 * returns key as printable string
	 * @return the key
	 */
	public String toString()
	{
		return key.toString();
	}
	
    /**
     * returns the left most descendant of a node
     * @return the left most descendant
     */
    public BSTNode<T> getLeftMostDescendant(){
   	 	boolean stillLeftChild = true;
   	 	BSTNode<T> currentNode = this;
   	 	while(stillLeftChild) {
   	 		if(currentNode.llink == null) {
   	 			stillLeftChild = false;
   	 		}
   	 		else {
   	 			currentNode = currentNode.llink;
   	 		}
   	 	}
   	 	return currentNode;
    }
    
    /**
     * returns key
     * @return the key
     */
    public T getKey() {
    	return key;
    }
    
    /**
     * sets the key
     * @param newKey that key is set to 
     */
    public void setKey(T newKey) {
    	key = newKey;
    }
    
    /**
     * returns the number of children a node has
     */
    public int getNumChildren() {
   	    if(llink == null && rlink == null) {
   		    return 0;
   	    }
   	    else if(llink == null && rlink != null) {
   	    	return 1;
   	    }
   	    else if(llink != null && rlink == null) {
   	    	return 1;
   	    }
   	    else {
   	    	return 2;
   	    }
    }
    
    /**
     * returns the right most descendant of a node
     * @return the right most descendant of a node
     */
    public BSTNode<T> getRightMostDescendant(){
     	 boolean stillRightChild = true;
     	 BSTNode<T> currentNode = this;
     	 while(stillRightChild) {
     		 if(currentNode.rlink == null) {
     			 stillRightChild = false;
     		 }
     		 else {
     			 currentNode = currentNode.rlink;
     		 }
     	 }
     	 return currentNode;
    }
    
    /**
     * checks if the node is a leaf
     * @return boolean expression of if it is a leaf
     */
    public boolean isLeaf() {
    	return getNumChildren()==0;
    }
    
}
